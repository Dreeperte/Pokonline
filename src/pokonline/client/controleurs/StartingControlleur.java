package pokonline.client.controleurs;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.Client;
import pokonline.client.vues.PlayerView;
import pokonline.client.vues.WorldView;

public class StartingControlleur extends BasicGame{

	private GameContainer container;
	private static String pname;
	private Client c;
	public static Object lock = new Object();
	public StartingControlleur() {
		super("Pokonline");
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws SlickException {
		Scanner scanner = new Scanner(System.in);
		pname = scanner.nextLine();
		scanner.close();
		new AppGameContainer(new StartingControlleur(), 1920, 1080, false).start();
		

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
    	g.clear();
		synchronized(lock) {
			WorldView.render(WorldControleurs.getWorld(),this.c ,g,container);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		WorldControleurs.init();
		container.setTargetFrameRate(70);
		//container.setFullscreen(true);
		AssetManager.loadTexture();
		c = new Client(pname);
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

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
			//System.out.println(this.c.getP1());
		synchronized(lock) {
			
			this.c.updateClient(container);

		}
	}
    @Override
    public void keyReleased(int key, char c) {
    	synchronized(lock) {
    		this.c.getP1().setMoving(false);
    		this.c.getP1().setReleased(true);
    	}
    }
    @Override
    public void keyPressed(int key, char c) {
    	switch (key) {
    		case Input.KEY_D:    			
    			synchronized(lock) {
    				
    				this.c.getP1().setDirection("right");
    			}
    			break;
    		case Input.KEY_Q: 
    			synchronized(lock) {
    				this.c.getP1().setDirection("left");
    				
    			}
    			break;
    		case Input.KEY_S:
    			synchronized(lock) {
    				this.c.getP1().setDirection("down");
    				

    			}
    			break;
    		case Input.KEY_Z:
    			synchronized(lock) {
    				this.c.getP1().setDirection("up");
    				
    			}
    			break;
    		case Input.KEY_ESCAPE:
    			synchronized(lock) {
    				this.c.getP1().setLeave(true);
    				
    			}
    			break;

 
    	}

    }


}
