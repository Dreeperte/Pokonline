package pokonline.client.vues;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.BattleHUD;
import pokonline.client.modeles.BattleModel;
import pokonline.client.modeles.PlayerModeles;


public class BattleView {
	private static Image img = AssetManager.loadImage("texture/background.png");
	private static final int x = 1412, y = 635;
	public static void render(Graphics g, GameContainer container, BattleHUD bth, BattleModel bm, PlayerModeles p1) {
		g.resetTransform();
		g.drawImage(img,0,0);
		BattleHUDView.render(bth, g, container);
		Image front = bm.getPkmn().getFront().getScaledCopy(8);
		Image back = p1.getPkmns().get(0).getBack().getScaledCopy(8);
		g.drawImage(front, x-(front.getWidth()/2), y-(front.getHeight()));
		g.drawImage(back, 0, 896-back.getHeight());
		PokemonHudView.renderEnemy(bm.getPkmn(), g, container);
		PokemonHudView.renderAlly(p1.getPkmns().get(0), g, container);
	}

}
