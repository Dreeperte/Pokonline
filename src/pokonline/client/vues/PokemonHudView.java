package pokonline.client.vues;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;
import pokonline.client.pokemon.pokemon;

public class PokemonHudView {
    private static int P_BAR_X;
    private static int P_BAR_Y;
    private static int E_BAR_X; // position de l'hud des enemies en X
    private static int E_BAR_Y; // position de l'hud des enemies en Y
    private static final int BAR_WIDTH = 336;
    private static final int BAR_HEIGHT = 24;
	private static final int X_PADDING = 30 , Y_PADDING = 15;
	private static Image img = AssetManager.loadImage("texture/pokemonHUD.png");
	private static final int xe = 100, ye = 100, xa = 1400 , ya = 700;
	
	
	public static void renderEnemy(pokemon poke, Graphics g, GameContainer container) {
		   g.setColor(Color.green);
           g.fillRect(161, 194, ((float)poke.gethp()/(float)poke.getMaxhp()) * BAR_WIDTH, BAR_HEIGHT);
		   g.drawImage(img, xe,ye);
		   AssetManager.ttf.drawString(xe+X_PADDING, ye+Y_PADDING, poke.bpkmn().name() + "           " +poke.Lvl(),Color.black);
    }
	public static void renderAlly(pokemon poke, Graphics g, GameContainer container) {
		   g.setColor(Color.green);
           g.fillRect(1461, 794, ((float)poke.gethp()/(float)poke.getMaxhp()) * BAR_WIDTH, BAR_HEIGHT);
		   g.drawImage(img, xa,ya);
		   AssetManager.ttf.drawString(xa+X_PADDING, ya+Y_PADDING, poke.bpkmn().name() + "           " +poke.Lvl(),Color.black);
		   AssetManager.ttf.drawString(xa+X_PADDING, ya+(Y_PADDING*5), poke.gethp() + "/"+poke.getMaxhp(),Color.black);
	   

	    }

}
