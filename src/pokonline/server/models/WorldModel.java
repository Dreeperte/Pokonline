package pokonline.server.models;

import java.util.ArrayList;

import pokonline.server.controllers.PlayerController;

public class WorldModel {
	
	private ArrayList<PlayerController> players = new ArrayList<>();
	
	public WorldModel(ArrayList<PlayerController> players) {
		this.players = players;
	}
	
	public void update() {
		for (int i = 0; i < players.size(); i++) {
			PlayerModel p = players.get(i).getPlayer();
			if (p.getDirection() != "released") {
				switch (p.getDirection()) {
				case "up":
					p.setY(p.getY() - p.getSpeed());
					break;
					
				case "down":
					p.setY(p.getY() + p.getSpeed());
					break;
					
				case "right":
					p.setX(p.getX() + p.getSpeed());
					break;
					
				case "left":
					p.setX(p.getX() - p.getSpeed());
					break;
				}
			}
		}
	}
	
	public PlayerModel getPlayers(int i) {
		return players.get(i).getPlayer();
	}
	
	public void addPlayer(PlayerModel model) {
		players.add(new PlayerController(model));
	}
}
