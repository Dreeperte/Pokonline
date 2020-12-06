package pokonline.client.modeles;

import java.util.ArrayList;

public class WorldModeles {
	private ArrayList<PlayerModeles> allPlayers = new ArrayList<>();
	public WorldModeles() {
		
		// TODO Auto-generated constructor stub
	}
	
	public void addPlayer(PlayerModeles player) {
		this.allPlayers.add(player);
	}
	public ArrayList<PlayerModeles> getAllPlayers() {
		return allPlayers;
	}
	public void setAllPlayers(ArrayList<PlayerModeles> allPlayers) {
		this.allPlayers = allPlayers;
	}

}
