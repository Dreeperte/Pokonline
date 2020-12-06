package pokonline.server.controllers;

import pokonline.server.models.ServerModel;
import pokonline.server.views.StartingView;

public class StartingController {
	ServerModel model;
	
	public StartingController(int port) {
		StartingView.drawStartOfServer();
		model = new ServerModel(port);
		StartingView.drawServerStarted(port);
	}
}
