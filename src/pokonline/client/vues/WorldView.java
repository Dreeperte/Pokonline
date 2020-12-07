package pokonline.client.vues;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import pokonline.client.controleurs.MapControleurs;
import pokonline.client.modeles.Client;
import pokonline.client.modeles.PlayerModeles;
import pokonline.client.modeles.WorldModeles;

public class WorldView {

	   public static void render(WorldModeles world,Client client ,Graphics g, GameContainer container) throws SlickException {
			g.translate(container.getWidth() / 2 - (int) client.getP1().getX(), 
	                container.getHeight() / 2 - (int) client.getP1().getY());
		    MapView.renderl1(MapControleurs.m1, g);
	    	for(PlayerModeles p : world.getAllPlayers()) {
	    		PlayerView.render(p, g);
	    	}
	    	PlayerView.render(client.getP1(), g);

	  
		    	

	    }
}
