package pokonline.client.modeles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import pokonline.client.controleurs.StartingControlleur;
import pokonline.client.controleurs.WorldControleurs;

public class Client {
	private PlayerModeles p1;
	public Client(String pname) {
		this.p1 = new PlayerModeles(0,0,pname);


	}
	
	public void StartClient() throws UnknownHostException, IOException {
		
		Socket sock = new Socket("151.80.155.244", 5015);
		Scanner scanner = new Scanner(System.in);
		PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
		
		Thread t = new Thread(new Runnable() {
			public void run() {

						try {
				            InputStream input = sock.getInputStream();
				            
				            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				 
				            String line2;
				            
				            while ((line2 = reader.readLine()) != null) {
				            	String playerpseudo = "";
				            	String x = "",y = "";
				            	String temp = "";
				                //System.out.println(line2);
				                int i = 0;
				                boolean coordinate = false;
				                for(i = 0; i < line2.length();i++) {
				                	if(line2.charAt(i) == ':') {
				                		playerpseudo = new String(temp);
				                		i++;
				                		temp = "";
				                	}
				                	if(temp.equals("position=")) {
				                		coordinate = true;
				                		temp = "";
				                		
				                	}
				                	
				                	if(coordinate) {
				                		if(line2.charAt(i) == ';') {
				                			
				                			x = new String(temp);
				                			temp = "";
				                			i++;
				                		}
				                	}
				                	temp += line2.charAt(i); 
				                }
				                y = new String(temp);
				                

				                if(!playerpseudo.equals(p1.getName())) {
				                	boolean found = false;
				                	for(PlayerModeles player : WorldControleurs.getWorld().getAllPlayers()) {
				                		if(player.getName().equals(playerpseudo)) {
				                			found = true;
				                			player.setX(Integer.parseInt(x));
				                			player.setY(Integer.parseInt(y));
				                			break;
				                		}
				            
				                	}
				                	if(!found) {
			                			System.out.println("Added new player : " + playerpseudo + " X : " + x +" Y : "+y);
			                			WorldControleurs.getWorld().getAllPlayers().add(new PlayerModeles(Integer.parseInt(x),Integer.parseInt(y),playerpseudo));
				                	}else {
				                		
				                	}
				                }
				                 
				                /*if (line2.substring(0, line2.indexOf('=')).equals("position")){
				                	String positionX = line2.substring(line2.indexOf('=') + 1, line2.indexOf(','));
				                	String positionY = line2.substring(line2.indexOf(',') + 1);
				                	System.out.println("X : " + positionX + " " + "Y : " + positionY);
				                }*/
				            }

							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

			}
		
		});
		t.start();
		
		out.println(p1.getName());
		//Ecriture sur le serveur 
		while(true) {
			//System.out.println(p1);
			synchronized(StartingControlleur.lock) {
				if(p1.isUpdate()) {
					//System.out.println(p1.getName() +":position="+p1.getInfo());
					out.println(p1.getName() +":position="+p1.getInfo());
					p1.setUpdate(false);
				}
			}
			
		}

		
		
	}

	public PlayerModeles getP1() {
		return p1;
	}

	public void setP1(PlayerModeles p1) {
		this.p1 = p1;
	}


}
