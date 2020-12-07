package pokonline.client.modeles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import pokonline.client.controleurs.AnimationControleurs;

public class AssetManager {
	static Image stone, grass;
	public AssetManager() {
	}
	
	public static void loadTexture() {
    	try {
			grass = new Image("texture/Grass.png");
			stone = new Image("texture/Stone.png");
			AnimationControleurs.loadSpriteSheet();
		} catch (SlickException e) {
			e.printStackTrace();
		}
    	
	}

}
