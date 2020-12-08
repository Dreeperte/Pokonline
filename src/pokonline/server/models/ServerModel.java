package pokonline.server.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import pokonline.server.controllers.PlayerController;
import pokonline.server.controllers.WorldController;

public class ServerModel {
	private ServerSocket server_socket;
	static ArrayList<Socket> sockets = new ArrayList<>();
	
	private static int id_count = 0;
	
	private static String incomingInfo = null;
	
	private static ArrayList<PlayerController> players = new ArrayList<>();
	private static boolean notifCo = false;
	
	public static Object incomingInfolock = new Object();
	public static Object playersLock = new Object();
	
	public ServerModel(int port) {
		try {
			server_socket = new ServerSocket(port);
			(new Thread(new WorldController(players))).start();
			(new Thread(new Answer())).start();
			
			Thread t = new Thread(new Runnable() {
	            public void run() {
	            	while (true) {
						try {
							sockets.add(server_socket.accept());
							
							synchronized(playersLock) {
								players.add(new PlayerController(
										new PlayerModel(id_count, 0, 0, "Player " + id_count)));
								notifCo = true;
							}
							(new Thread(new Responder(id_count))).start();
							id_count++;
						} catch (IOException e) { e.printStackTrace(); }
					}
	            }
	        
	        });
			
	        t.start();
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	static class Answer implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					synchronized (playersLock) {
						
						if (notifCo) {
							for (int i = 0; i < players.size() - 1; i++) {
								PrintWriter out = new PrintWriter(sockets.get(players.size() - 1).getOutputStream(), true);
								out.println(players.get(i).getPlayer().getName() + ":position=" +
										players.get(i).getPlayer().getX() + ";" + 
										players.get(i).getPlayer().getY() + ",direction="
										+ players.get(i).getPlayer().getDirection());
							}
							
							notifCo = false;
						}
					}
					
					synchronized (incomingInfolock) {
						if (incomingInfo != null) {
							for (int i = 0; i < sockets.size(); i++) {
								PrintWriter out = new PrintWriter(sockets.get(i).getOutputStream(), true);
								out.println(incomingInfo);
							}
							incomingInfo = null;
						}
					}
				}
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	static class Updater implements Runnable {
        private int id;
		
		public Updater(int id) {
			this.id = id;
		}
		
        @Override
        public void run() {
            try {
				for (int i = 0; i < sockets.size(); i++) {
					if (id != i) {
						PrintWriter out = new PrintWriter(sockets.get(i).getOutputStream(), true);
						
						out.println(players.get(id).getPlayer().getName() + ":position=" +
									players.get(id).getPlayer().getX() + ";" + players.get(id).getPlayer().getY()
									+ ",direction=" + players.get(id).getPlayer().getDirection());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }   
    }
	
	static class Responder implements Runnable {
        private int id;

        public Responder(int id) {
        	this.id = id;
        }
        
        @Override
        public void run() {
            BufferedReader in;
            try {
            	
            	in = new BufferedReader(new InputStreamReader(sockets.get(
            			players.get(id).getPlayer().getId()).getInputStream()));
            	String pseudo = in.readLine();
            	
            	if (!pseudo.isEmpty())
            		players.get(id).getPlayer().setName(pseudo);
            	
            	incomingInfo = players.get(id).getPlayer().getName() + ":position="
            					+ players.get(id).getPlayer().getX() + ";" + players.get(id).getPlayer().getY()
            					+ ",direction=" + players.get(id).getPlayer().getDirection();
            	
                while (true) {
                	String newClientInfo = in.readLine();
                	String requestType = newClientInfo.substring(newClientInfo.indexOf(':') + 1);
                	
                    if (newClientInfo.contains("direction")) {
                    	String login = newClientInfo.substring(0, newClientInfo.indexOf(':'));
                    	String direction = newClientInfo.substring(newClientInfo.indexOf(',') + 11);
                    	
                    	synchronized (incomingInfolock) {
                    		int id = 0;
                    		for (int i = 0; i < players.size(); i++) {
                    			if (players.get(i).getPlayer().getName().equals(login)) {
                    				id = i;
                    				break;
                    			}
                    		}
                    		
                    		players.get(id).getPlayer().setDirection(direction);
                    		(new Thread(new Updater(id))).start();
                    	}
                    }
                    
                    if (requestType.contains("released")) {
                    	players.get(id).getPlayer().setDirection("released");
                    	(new Thread(new Updater(id))).start();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }   
    }
}
