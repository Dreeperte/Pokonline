package pokonline.client.vues;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.MainScreen;

public class MainScreenView {

		private static final int SPACE = 10;
	   public static void render(MainScreen screen, GameContainer container,Graphics g) throws SlickException {
		   g.drawImage(screen.getImage(), 0, 0);
		   screen.getLocalHost().render(container, g);
		   AssetManager.ttf.drawString(screen.getLocalHost().getX()+SPACE, screen.getLocalHost().getY()+screen.getLocalHost().getHeight()/2, "Local host",Color.black);
		   screen.getServer().render(container, g);
		   AssetManager.ttf.drawString(screen.getServer().getX()+SPACE, screen.getServer().getY()+screen.getServer().getHeight()/2, "Server",Color.black);
		   screen.getOffline().render(container, g);
		   AssetManager.ttf.drawString(screen.getOffline().getX()+SPACE, screen.getOffline().getY()+screen.getOffline().getHeight()/2, "Offline",Color.black);
		  
		    

	    }

}
