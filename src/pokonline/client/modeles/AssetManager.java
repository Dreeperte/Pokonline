package pokonline.client.modeles;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

import pokonline.client.controleurs.AnimationControleurs;

public class AssetManager {
	static Image stone, grass;
	public static TrueTypeFont ttf;
	public AssetManager() {
	}
	
	public static void loadTexture() {
    	try {
			grass = new Image("texture/Grass.png");
			stone = new Image("texture/Stone.png");
			Font font = new Font("font/Pokemon_GB.ttf", Font.BOLD, 32);
			ttf = new TrueTypeFont(font, true);
			AnimationControleurs.loadSpriteSheet();
		} catch (SlickException e) {
			e.printStackTrace();
		}
    	
	}
	
	public static Image loadImage(String path) 
	{
	    BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(path));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    Texture texture = null;
		try {
			texture = BufferedImageUtil.getTexture("", bufferedImage);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    Image image = null;
		try {
			image = new Image(texture.getImageWidth(), texture.getImageHeight());
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    image.setTexture(texture); 
	    return image;
	}

}
