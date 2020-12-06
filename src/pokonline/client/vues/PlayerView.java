package pokonline.client.vues;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import pokonline.client.modeles.PlayerModeles;

public class PlayerView {

   public static void render(PlayerModeles player, Graphics g) throws SlickException {
	   g.drawString(player.getName(), player.getX(), player.getY()+20);
    	g.drawImage(player.getImage(), player.getX(), player.getY());
  
    
    	
    	

    }


}
