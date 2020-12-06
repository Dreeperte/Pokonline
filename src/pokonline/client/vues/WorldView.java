package pokonline.client.vues;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import pokonline.client.modeles.PlayerModeles;
import pokonline.client.modeles.WorldModeles;

public class WorldView {

	   public static void render(WorldModeles world, Graphics g) throws SlickException {
	    	for(PlayerModeles p : world.getAllPlayers()) {
	    		PlayerView.render(p, g);
	    	}
	  
		    	

	    }
}
