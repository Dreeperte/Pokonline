package pokonline.client.vues;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import pokonline.client.modeles.PlayerModeles;

public class PlayerView {

   public static void render(PlayerModeles player, Graphics g) throws SlickException {
	   g.setColor(Color.red);
	   g.drawString(player.getName(), player.getX(), player.getY()-20);
	   switch(player.getDirection()) {
	   case("down"):
		   if(player.isMoving())
			   g.drawAnimation(player.getAnimation()[4],player.getX(),player.getY());
		   else
			   g.drawAnimation(player.getAnimation()[0],player.getX(),player.getY());
		   break;
	   case("left"):
		   if(player.isMoving())
			   g.drawAnimation(player.getAnimation()[5],player.getX(),player.getY());
		   else
			   g.drawAnimation(player.getAnimation()[1],player.getX(),player.getY());
		   break;
	   case("right"):
		   if(player.isMoving())
			   g.drawAnimation(player.getAnimation()[6],player.getX(),player.getY());
		   else
			   g.drawAnimation(player.getAnimation()[2],player.getX(),player.getY());
		   break;
	   case("up"):
		   if(player.isMoving())
			   g.drawAnimation(player.getAnimation()[7],player.getX(),player.getY());
		   else
			   g.drawAnimation(player.getAnimation()[3],player.getX(),player.getY());
		   break;
	   }

    	//g.drawImage(player.getImage(), player.getX(), player.getY());
  
    
    	
    	

    }


}
