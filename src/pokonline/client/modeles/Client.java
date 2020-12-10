package pokonline.client.modeles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


import org.newdawn.slick.GameContainer;

import pokonline.client.controleurs.MapControleurs;
import pokonline.client.controleurs.StartingControlleur;
import pokonline.client.controleurs.WorldControleurs;

public class Client {
	private PlayerModeles p1;
	private CameraModeles cam;
	private boolean keypressed = false;
	private boolean collision = false;
	private boolean switchmap = false;
	
	public Client(String pname) {
		this.p1 = new PlayerModeles(200,200,pname);
		this.cam = new CameraModeles();

	}
	public void setSwitchMap(boolean switchmap) {
		this.switchmap = switchmap;
	}
	public void StartClient() throws UnknownHostException, IOException {
		
		Socket sock = new Socket("151.80.155.244", 5015);
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
				            	String direction ="";
				            	String mapswitch ="";
				            	boolean released = false;
				            	boolean setdirection = false;
				                //System.out.println(line2);
				                playerpseudo = line2.substring(0,line2.indexOf(':'));
				                if(line2.contains("position")) {
				                	x = line2.substring(line2.indexOf('=')+1, line2.indexOf(';'));
				                	y = line2.substring(line2.indexOf(';')+1, line2.indexOf(','));
				                	if(line2.contains("direction")) {
				                		String directiontemp = line2.substring(line2.indexOf("direction=")+10);
					                	if(directiontemp.equals("released")) {
					                		released = true;
					                	}
					                	else
					                	{
					                		direction = directiontemp;
					                		setdirection = true;
					                	}
				                	}
				                	else if(line2.contains("transition")) {
				                		mapswitch = line2.substring(line2.indexOf("transition=")+11);
				                	}

				                		
				      
				                }
				                //System.out.println(playerpseudo + " " + x + " " + y + " " + temp + " " + direction);
				                

				                

				                if(!playerpseudo.equals(p1.getName())) {
				                	boolean found = false;
				                	for(PlayerModeles player : WorldControleurs.getWorld().getAllPlayers()) {
				                		if(player.getName().equals(playerpseudo)) {
				                			found = true;
				                			player.setX(Integer.parseInt(x));
				                			player.setY(Integer.parseInt(y));
				                			if(released) {
				                				player.setMoving(false);
				                			}
				                			else if(setdirection) {
				                				player.setDirection(direction);
				                			}
				                			else {
				                				player.setCurrentmap(MapControleurs.searchMap(mapswitch));
				                			}
				                			break;
				                		}
				            
				                	}
				                	if(!found) {
			                			System.out.println("Added new player : " + playerpseudo + " X : " + x +" Y : "+y);
			                			WorldControleurs.getWorld().getAllPlayers().add(new PlayerModeles(Integer.parseInt(x),Integer.parseInt(y),playerpseudo));
				                	}else {
				                		
				                	}
				                }
				                 
				            }

							
						} catch (IOException e) {
							
							e.printStackTrace();
						}

			}
		
		});
		t.start();
		
		out.println(p1.getName());
		//Ecriture sur le serveur 
		while(!p1.isLeave()) {
			//System.out.println(p1);
			synchronized(StartingControlleur.lock) {
				if(this.isKeypressed() && !this.isCollision()) {
					//System.out.println(p1.getName() +":position="+p1.getInfo());
					out.println(p1.getName()+":position="+p1.getX()+";"+p1.getY() + ",direction="+p1.getDirection());
					this.setKeypressed(false);
				}
				if(p1.isReleased()) {
					//out.println(p1.getName()+":"+"released");
					out.println(p1.getName() +":position="+p1.getX()+";"+p1.getY()+",direction=released");
					p1.setReleased(false);
				}
				if(switchmap) {
					out.println(p1.getName()+":position="+p1.getX()+";"+p1.getY()+",transition="+p1.getCurrentmap().getName());
					switchmap = false;
				}
			}
			
		}
		//sock.close();



		
		
	}
	public void updateClient(GameContainer container) {
		if(getP1().isMoving()) {
			if(p1.isLeave()) {
				container.exit();
			}
			/*switch(getP1().getDirection()) {
				case "up": getP1().setY(getP1().getY()-getP1().getSpeed()); break;
				case "down": getP1().setY(getP1().getY()+getP1().getSpeed()); break;
				case "left": getP1().setX(getP1().getX()-getP1().getSpeed()); break;
				case "right": getP1().setX(getP1().getX()+getP1().getSpeed()); break;
			}*/
			
		}
		
	}

	public PlayerModeles getP1() {
		return p1;
	}

	public void setP1(PlayerModeles p1) {
		this.p1 = p1;
	}

	public CameraModeles getCam() {
		return cam;
	}

	public void setCam(CameraModeles cam) {
		this.cam = cam;
	}

	public boolean isKeypressed() {
		return keypressed;
	}

	public void setKeypressed(boolean keypressed) {
		this.keypressed = keypressed;
	}

	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}


}
