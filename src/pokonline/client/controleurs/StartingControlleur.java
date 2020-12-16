package pokonline.client.controleurs;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;

import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.BattleHUD;
import pokonline.client.modeles.BattleModel;
import pokonline.client.modeles.Client;

public class StartingControlleur extends StateBasedGame{

	//private GameContainer container;
	private static String pname;
	private Client c;
	private BattleHUD bth;
	public static Object lock = new Object();
	private int tick = 0;
	private BattleModel bm; 
	public StartingControlleur() {
		super("Pokonline");
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws SlickException {
		Scanner scanner = new Scanner(System.in);
		pname = scanner.nextLine();
		scanner.close();
	    JFrame frame = new JFrame();
	    CanvasGameContainer app = new CanvasGameContainer(new StartingControlleur());
	    frame.setUndecorated(true);
	    frame.setVisible(true);
	    frame.add(app);
	    frame.setSize(1920, 1080);
	    app.start();

		

	}
 	

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		WorldControleurs.init();
		container.setTargetFrameRate(70);
		container.setVSync(true);
		//container.setFullscreen(true);
		AssetManager.loadTexture();
		bth = new BattleHUD(container);
		c = new Client(pname);
		bth.setClient(c);
		c.getP1().setCurrentmap(MapControleurs.m1);
		MapControleurs.initMap();
		bm  = new BattleModel(c.getP1().getCurrentmap());
		c.getP1().addPkmns(AssetManager.bpkmnVenusaur);
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
        addState(new MapGameState(c,bth,bm));
        addState(new CombatGameState(c,bth,bm));
		// TODO Auto-generated method stub
		
	}


}
