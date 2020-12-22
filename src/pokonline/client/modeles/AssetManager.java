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
import pokonline.client.pokemon.STATS;
import pokonline.client.pokemon.base_pkmn;
import pokonline.client.pokemon.pokemon;
import pokonline.client.pokemon.type;

public class AssetManager {
	static Image stone, grass, button;
	public static TrueTypeFont ttf;
	public static pokemon bpkmnVenusaur,bpkmnCharizard,bpkmnBlastoise,bpkmnButterfree;
	public AssetManager() {
	}
	
	public static void loadTexture() {
    	try {
			grass = new Image("texture/Grass.png");
			stone = new Image("texture/Stone.png");
			button = AssetManager.loadImage("texture/button.png");
			Font font = new Font("font/Pokemon_GB.ttf", Font.BOLD, 16);
			ttf = new TrueTypeFont(font, true);
			AnimationControleurs.loadSpriteSheet();
			loadpokemon();
		} catch (SlickException e) {
			e.printStackTrace();
		}
    	
	}
	
	public static void loadpokemon() {
		type bug = new type("bug");
		type dark = new type("dark");
		type dragon = new type("dragon");
		type electric = new type("electric");
		type fairy = new type("fairy");
		type fighting = new type("fighting");
		type fire = new type("fire");
		type flying = new type("flying");
		type ghost = new type("ghost");
		type grass = new type("grass");
		type ground = new type("ground");
		type ice = new type("ice");
		type normal = new type("normal");
		type poison = new type("poison");
		type psychic = new type("psychic");
		type rock =new type("rock");
		type steel = new type("steel");
		type water = new type("water");
		bpkmnVenusaur = new pokemon(new base_pkmn("Venusaur",new STATS(80,82,83,100,100,80),grass,poison));
		bpkmnCharizard = new pokemon(new base_pkmn("Charizard",new STATS(78,84,78,109,85,100),fire,flying));
		bpkmnBlastoise = new pokemon(new base_pkmn("Blastoise",new STATS(79,83,100,85,105,78),water));
		bpkmnButterfree = new pokemon(new base_pkmn("Butterfree",new STATS(60,45,50,90,80,70),bug,flying));
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
