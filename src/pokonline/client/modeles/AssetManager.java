package pokonline.client.modeles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AssetManager {
	static Image stone, grass;
	public AssetManager() {
	}
	
	public static void loadTexture() {
    	try {
			grass = new Image("texture/Grass.png");
			stone = new Image("texture/Stone.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
    	
	}

}
