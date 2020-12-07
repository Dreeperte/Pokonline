package pokonline.client.modeles;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class MapModeles {
	private boolean encounter;
	private TiledMap map;
	private String name;
	public MapModeles(String filemapname,String name,boolean encounter) {
		this.encounter = encounter;
		try {
			this.map = new TiledMap("map/" + filemapname);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	public boolean isEncounter() {
		return encounter;
	}
	public void setEncounter(boolean encounter) {
		this.encounter = encounter;
	}
	public TiledMap getMap() {
		return map;
	}
	public void setMap(TiledMap map) {
		this.map = map;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
