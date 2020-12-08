package pokonline.server.controllers;

import java.util.ArrayList;

import pokonline.server.models.ServerModel;
import pokonline.server.models.WorldModel;

public class WorldController implements Runnable {
	double interpolation = 0;
	final int TICKS_PER_SECOND = 7;
	final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	final int MAX_FRAMESKIP = 5;
	
	private WorldModel worldModel;
	
	public WorldController(ArrayList<PlayerController> players) {
		this.worldModel = new WorldModel(players);
	}

	@Override
	public void run() {
	    double next_game_tick = System.currentTimeMillis();
	    int loops;

	    while (true) {
	        loops = 0;
	        while (System.currentTimeMillis() > next_game_tick
	                && loops < MAX_FRAMESKIP) {

	            synchronized (ServerModel.playersLock) {
	            	worldModel.update();
	            }

	            next_game_tick += SKIP_TICKS;
	            loops++;
	        }

	        interpolation = (System.currentTimeMillis() + SKIP_TICKS - next_game_tick
	                / (double) SKIP_TICKS);
	    }
	}
}
