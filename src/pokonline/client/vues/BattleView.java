package pokonline.client.vues;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.BattleHUD;

public class BattleView {
	private static Image img = AssetManager.loadImage("texture/background.png");

	public static void render(Graphics g, GameContainer container, BattleHUD bth) {
		g.resetTransform();
		g.drawImage(img,0,0);
		BattleHUDView.render(bth, g, container);
	}

}
