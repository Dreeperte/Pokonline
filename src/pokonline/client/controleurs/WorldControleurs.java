package pokonline.client.controleurs;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import pokonline.client.modeles.Client;
import pokonline.client.modeles.MapModeles;
import pokonline.client.modeles.PlayerModeles;
import pokonline.client.modeles.WorldModeles;

public class WorldControleurs {
	private static WorldModeles world;
	public static void init() {
		world = new WorldModeles();
	}
	public static void updateplayer() {
		for(PlayerModeles p: world.getAllPlayers()) {
			p.update();
		}
	}
    public static boolean isCollision(float x , float y, MapModeles map) { //Collision avec le layer "logic"
        int tileW = map.getMap().getTileWidth();
        int tileH = map.getMap().getTileHeight();
        int logicLayer = map.getMap().getLayerIndex("logic");
        Image tile = map.getMap().getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
         if (collision) {
            Color color = tile.getColor((int) x % tileW, (int) y % tileH);
            collision = color.getAlpha() > 0;
        }
        return collision;
     }
    public static boolean isCollision2(float x , float y,Client c ,MapModeles map) { //Collision avec le layer "l2"
    	
        int tileW = map.getMap().getTileWidth();
        int tileH = map.getMap().getTileHeight();
        int logicLayer = map.getMap().getLayerIndex("l2");
        Image tile = map.getMap().getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
         if (collision && !c.isL2()) {
        	c.setL2(true);
            Color color = tile.getColor((int) x % tileW, (int) y % tileH);
            collision = color.getAlpha() > 0;
        }
        return collision;
     }
	public static WorldModeles getWorld() {
		return world;
	}
	public static void setWorld(WorldModeles nworld) {
		world = nworld;
	}

}
