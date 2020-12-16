package pokonline.client.vues;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.BattleHUD;
import pokonline.client.modeles.BattleModel;
import pokonline.client.modeles.PlayerModeles;
import pokonline.server.models.PlayerModel;

public class BattleView {
	private static Image img = AssetManager.loadImage("texture/background.png");
	private static final int x = 1412, y = 635;
	public static void render(Graphics g, GameContainer container, BattleHUD bth, BattleModel bm, PlayerModeles p1) {
		g.resetTransform();
		g.drawImage(img,0,0);
		BattleHUDView.render(bth, g, container);
		g.drawImage(bm.getPkmn().getFront(), x-(bm.getPkmn().getFront().getWidth()/2), y-(bm.getPkmn().getFront().getHeight()));
		g.drawImage(p1.getPkmns().get(0).getBack(), 0, 896-p1.getPkmns().get(0).getBack().getHeight());
		
	}

}
