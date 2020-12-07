package pokonline.client.vues;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import pokonline.client.modeles.MapModeles;


public class MapView {
	   public static void renderl1(MapModeles map, Graphics g) throws SlickException {
		   map.getMap().render(0, 0, 0);	  

	    }

}
