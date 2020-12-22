package pokonline.client.modeles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import pokonline.client.pokemon.pokemon;

public class AnimationModeles {

	public AnimationModeles() {
		// TODO Auto-generated constructor stub
	}
	
    public static Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
        	Image img = spriteSheet.getSprite(x, y);
            animation.addFrame(img, 100);
        }
        animation.setSpeed((float)0.5);
        return animation;
    }
    public static Animation loadAnimationPoke(SpriteSheet spriteSheet, int startX, int endX, int y, pokemon poke) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
        	Image img = spriteSheet.getSprite(x, y);
        	img.setFilter(Image.FILTER_NEAREST);
            animation.addFrame(img.getScaledCopy(8), 100);
            poke.setDuration(poke.getDuration()+100);
        }
        animation.setSpeed((float)3);
        poke.setDuration(poke.getDuration()/3);
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
