package pokonline.client.controleurs;

import pokonline.client.modeles.WorldModeles;

public class WorldControleurs {
	private static WorldModeles world;
	public static void init() {
		world = new WorldModeles();
	}
	public static WorldModeles getWorld() {
		return world;
	}
	public static void setWorld(WorldModeles nworld) {
		world = nworld;
	}

}
