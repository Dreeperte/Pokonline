package pokonline.client.modeles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class AnimationModeles {

	public AnimationModeles() {
		// TODO Auto-generated constructor stub
	}
	
    public static Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }
	public static Animation[] setAnimationP(SpriteSheet spriteSheet) {
        Animation animations[] = new Animation[8];
        animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
        animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
        animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
        animations[4] = loadAnimation(spriteSheet, 1, 3, 0);
        animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
        animations[6] = loadAnimation(spriteSheet, 1, 3, 2);
        animations[7] = loadAnimation(spriteSheet, 1, 3, 3);
        return animations;
	}

}
