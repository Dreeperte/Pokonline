package pokonline.client.vues;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.BattleHUD;

public class BattleHUDView {
	  
	  private static final int Y_PADDING = 12; 
	  private static final int X_PADDING = 52;
	  private static Image img = AssetManager.loadImage("texture/infobar.png");
	   
	   public static void render(BattleHUD battleHUD, Graphics g, GameContainer container) {
		   g.resetTransform();
		   
		   g.drawImage(img, 0,container.getHeight()-img.getHeight());
		   battleHUD.getAttack().render(container, g);
		   AssetManager.ttf.drawString(battleHUD.getAttack().getX()+X_PADDING, battleHUD.getAttack().getY()+Y_PADDING, "ATTACK",Color.black);
		   battleHUD.getBag().render(container, g);
		   AssetManager.ttf.drawString(battleHUD.getBag().getX()+X_PADDING, battleHUD.getBag().getY()+Y_PADDING, "BAG",Color.black);
		   battleHUD.getFlee().render(container, g);
		   AssetManager.ttf.drawString(battleHUD.getFlee().getX()+X_PADDING, battleHUD.getFlee().getY()+Y_PADDING, "FLEE",Color.black);
		   battleHUD.getSwitchpoke().render(container, g);
		   AssetManager.ttf.drawString(battleHUD.getSwitchpoke().getX()+X_PADDING, battleHUD.getAttack().getY()+Y_PADDING, "POKEMON",Color.black);
		   

	    }
	

}
