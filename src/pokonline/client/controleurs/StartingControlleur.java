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

public class StartingControlleur extends BasicGame{

	private GameContainer container;
	private String pname;
	private Client c;
	private static Object lock = new Object();
	public StartingControlleur() {
		super("Pokonline");
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws SlickException {
		//Scanner scanner = new Scanner(System.in);
		//pname = scanner.nextLine();
		//scanner.close();
		new AppGameContainer(new StartingControlleur(), 640, 480, false).start();
		

	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		synchronized(lock) {
			PlayerView.render(this.c.getP1(), g);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		container.setTargetFrameRate(70);
		//Modif
		AssetManager.loadTexture();
		c = new Client("toto");
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
	public void update(GameContainer arg0, int delta) throws SlickException {
			//System.out.println(this.c.getP1());
		synchronized(lock) {
			if(this.c.getP1().isMoving()) {
				switch(this.c.getP1().getDirection()) {
					case "up": this.c.getP1().setY(this.c.getP1().getY()-1); break;
					case "down": this.c.getP1().setY(this.c.getP1().getY()+1); break;
					case "left": this.c.getP1().setX(this.c.getP1().getX()-1); break;
					case "right": this.c.getP1().setX(this.c.getP1().getX()+1); break;
				}
			}
		}
	}
    @Override
    public void keyReleased(int key, char c) {
    	synchronized(lock) {
    		this.c.getP1().setMoving(false);
    		this.c.getP1().setInfo("released");
    	}
    }
    @Override
    public void keyPressed(int key, char c) {
    	switch (key) {
    		case Input.KEY_D:    			
    			synchronized(lock) {
    				this.c.getP1().setDirection("right");
    				this.c.getP1().setInfo("right");
    			}
    			break;
    		case Input.KEY_Q: 
    			synchronized(lock) {
    				this.c.getP1().setDirection("left");
    				this.c.getP1().setInfo("left");
    			}
    			break;
    		case Input.KEY_S:
    			synchronized(lock) {
    				this.c.getP1().setDirection("down");
    				this.c.getP1().setInfo("down");

    			}
    			break;
    		case Input.KEY_Z:
    			synchronized(lock) {
    				this.c.getP1().setDirection("up");
    				this.c.getP1().setInfo("up");
    			}
    			break;

 
    	}

    }


}
