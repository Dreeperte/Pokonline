package pokonline.client.controleurs;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;



public class AnimationControleurs {
	public static SpriteSheet spritePlayer;

	public static  void loadSpriteSheet() {
		try {
			spritePlayer = new SpriteSheet("texture/playersheet.png", 68, 100);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
