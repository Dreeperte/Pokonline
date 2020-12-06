package pokonline.server.views;

public class StartingView {
	
	public static void drawStartOfServer() {
		System.out.println("Starting the Pokonline server...");
	}
	
	public static void drawServerStarted(int port) {
		System.out.println("Server started on port " + port + ".");
	}
}
