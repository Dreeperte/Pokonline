package pokonline.client.vues;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import pokonline.client.modeles.MapModeles;



public class MapView {
	   public static void renderl1(MapModeles map,Graphics g) throws SlickException {
	
		   map.getMap().render(0, 0, 0);	  

	    }
	   public static void renderl2(MapModeles map, Graphics g) throws SlickException {
		   map.getMap().render(0, 0, 1);
	    }
	   public static void renderl3(MapModeles map, Graphics g) throws SlickException {
		   map.getMap().render(0, 0, 2);

	    }

}
