package pokonline.server;

import pokonline.server.controllers.StartingController;

public class Main {
	static final int PORT = 5015;

	public static void main(String[] args) {
		StartingController sc = new StartingController(PORT);
	}

}
