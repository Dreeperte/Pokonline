package pokonline.client.modeles;

import java.io.IOException;
import java.net.UnknownHostException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

import pokonline.client.controleurs.MapGameState;

public class MainScreen implements ComponentListener{
	private Image image = AssetManager.loadImage("texture/mainscreen.png");
    private MouseOverArea localHost;
    private MouseOverArea server;
    private MouseOverArea offline;
    private Client c;
    private static final int SPACE = 200;
	public MainScreen(GameContainer container, Client c) {
		Image button = AssetManager.button;
		setLocalHost(new MouseOverArea(container, button, (container.getWidth()/2)-(button.getWidth()/2), (container.getHeight()/2)-(button.getHeight()/2),this));
		setServer(new MouseOverArea(container, button, (container.getWidth()/2)-(button.getWidth()/2), ((container.getHeight()/2)-(button.getHeight()/2))+SPACE,this));
		setOffline(new MouseOverArea(container, button, (container.getWidth()/2)-(button.getWidth()/2), ((container.getHeight()/2)-(button.getHeight()/2))+SPACE*2,this));
		this.c = c;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public MouseOverArea getLocalHost() {
		return localHost;
	}
	public void setLocalHost(MouseOverArea localHost) {
		this.localHost = localHost;
	}
	public MouseOverArea getServer() {
		return server;
	}
	public void setServer(MouseOverArea server) {
		this.server = server;
	}
	@Override
	public void componentActivated(AbstractComponent source) {
		if(source == localHost) {
			c.getGame().enterState(MapGameState.ID);
	        Thread t = new Thread(new Runnable() {
	            public void run() {
	            	try {
						c.StartClient();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        
	        });
	        t.start();
		}
		else if(source == server){
			c.getGame().enterState(MapGameState.ID);
			c.setConnect("151.80.155.244");
	        Thread t = new Thread(new Runnable() {
	            public void run() {
	            	try {
						c.StartClient();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        
	        });
	        t.start();
			
		}
		else if(source == offline) {
			c.getGame().enterState(MapGameState.ID);
		}
		
	}
	public MouseOverArea getOffline() {
		return offline;
	}
	public void setOffline(MouseOverArea offline) {
		this.offline = offline;
	}

}
