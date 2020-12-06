package pokonline.server.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerModel {
	private ServerSocket server_socket;
	private static int id_count = 0;
	private static String incomingInfo = "";
	public static Object incomingInfolock = new Object();
	
	public ServerModel(int port) {
		try {
			server_socket = new ServerSocket(port);
			
			Thread t = new Thread(new Runnable() {
	            public void run() {
	            	while (true) {
						Socket sock;
						try {
							sock = server_socket.accept();
							
							(new Thread(new Responder(sock, 
									new PlayerModel(id_count, 0, 0, "Player " + id_count)))).start();
							id_count++;
						} catch (IOException e) { e.printStackTrace(); }
					}
	            }
	        
	        });
			
	        t.start();
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	static class Answer implements Runnable {
		private Socket sock;
		
		Answer(Socket sock) {
			this.sock = sock;
		}
		
		@Override
		public void run() {
			try {
				while (!(incomingInfo == "")) {
					synchronized (incomingInfolock) {
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						out.println(incomingInfo);
						incomingInfo = "";
					}
				}
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	static class Responder implements Runnable {
        private Socket sock;
        private PlayerModel player;
        
        Responder(Socket sock, PlayerModel player) {
            this.sock = sock;
            this.player = player;
        }

        @Override
        public void run() {
            BufferedReader in;
            try {
            	System.out.println(player.getName() + " is connected.");
            	
            	in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            	String pseudo = in.readLine();
            	
            	if (!pseudo.isEmpty())
            		player.setName(pseudo);
            	
            	(new Thread(new Answer(sock))).start();
            	
                while (true) {
                	String newClientInfo = in.readLine();
                    System.out.println(newClientInfo);
                    
                    if (newClientInfo.substring(newClientInfo.indexOf(':') + 1).equals("released")) {
                    	System.out.println("EIGBEZIGBEZ");
                    	synchronized (incomingInfolock) {
                    		incomingInfolock = "Ok c'est bon je me stop";
                    	}
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }   
    }
}
