package pokonline.client.controleurs;


import java.util.Scanner;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.Client;

public class StartingControlleur extends BasicGame{

	private GameContainer container;
	private String pname;
	private Client c;
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
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		//Modif
		AssetManager.loadTexture();
        Thread t = new Thread(new Runnable() {
            public void run() {
            	c = new Client("toto");
            }
        
        });
        t.start();

			
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {

	}
    @Override
    public void keyPressed(int key, char c) {
    	switch (key) {
    		case Input.KEY_D:    			
    			this.c.getP1().setDirection("right");
    			break;
    		case Input.KEY_Q: 
    			this.c.getP1().setDirection("left");
    			break;
    		case Input.KEY_S:
    			this.c.getP1().setDirection("back");
    			break;
    		case Input.KEY_Z: 
    			this.c.getP1().setDirection("forward");
    			break;

 
    	}

    }


}
