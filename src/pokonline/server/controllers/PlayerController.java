package pokonline.server.controllers;

import pokonline.server.models.PlayerModel;

public class PlayerController {
	private PlayerModel player;
	
	public PlayerController(PlayerModel player) {
		this.player = player;
	}
	
	public PlayerModel getPlayer() {
		return player;
	}
	
	public void info(String info) {
		
	}
}
