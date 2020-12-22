package pokonline.client.vues;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.BattleHUD;
import pokonline.client.modeles.BattleModel;
import pokonline.client.modeles.EventObject;
import pokonline.client.modeles.PlayerModeles;


public class BattleView {
	private static Image img = AssetManager.loadImage("texture/background.png");
	private static final int x = 1412, y = 635;
	private static boolean trigger = false;
	
	public static void render(Graphics g, GameContainer container, BattleHUD bth, BattleModel bm, PlayerModeles p1,EventObject event) {
		g.resetTransform();
		g.drawImage(img,0,0);
		BattleHUDView.render(bth, g, container);
		Image back = p1.getPkmns().get(0).getBack().getScaledCopy(8);
		g.drawImage(back, 0, 896-back.getHeight());
		if(trigger) {
			if(!event.isReady()) {	
				Animation front = bm.getPkmn().getFront();
				g.drawAnimation(front, x-(front.getWidth()/2), y-(front.getHeight()));
				
			}
			else {
				bm.getPkmn().getSound().play();
				trigger = false;
			}
			

		}
		else {
			Image last = bm.getPkmn().getLast();
			g.drawImage(last, x-(last.getWidth()/2), y-(last.getHeight()));
		}
		
		PokemonHudView.renderEnemy(bm.getPkmn(), g, container);
		PokemonHudView.renderAlly(p1.getPkmns().get(0), g, container);
	}
	public static  boolean isTrigger() {
		return trigger;
	}
	public static void setTrigger(boolean trigger2) {
		trigger = trigger2;
	}

}
