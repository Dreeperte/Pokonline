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
		private String response;
		
		Answer(Socket sock, String response) {
			this.sock = sock;
			this.response = response;
		}
		
		@Override
		public void run() {
			try {
				PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
				out.println(response);
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	static class Responder implements Runnable {
        private Socket sock;
        private PlayerModel players;
        
        Responder(Socket sock, PlayerModel players) {
            this.sock = sock;
            this.players = players;
        }

        @Override
        public void run() {
            BufferedReader in;
            try {
            	System.out.println(players.getName() + " is connected.");
            	
            	in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            	String pseudo = in.readLine();
            	System.out.println(pseudo);
            	if (!pseudo.isEmpty())
            		players.setName(pseudo);
            	
                while (true) {
                    System.out.println(in.readLine());
                    
                    (new Thread(new Answer(sock, 
                    		players.getName() + " ==> " + players.getX() + ";" + players.getY()))).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }   
    }
}
