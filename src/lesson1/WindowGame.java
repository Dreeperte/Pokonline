package lesson1;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

import pokonline.client.modeles.AssetManager;


public class WindowGame extends BasicGame {
	
	private GameContainer container;
	Texture text;
	Input input;
	AssetManager asset;
    public WindowGame() {
        super("Lesson 1 :: WindowGame");
    }



    
    @Override
    public void init(GameContainer container) throws SlickException {
    	this.container = container;
    	this.asset = new AssetManager();
    	this.asset.loadTexture();
    	
    	container.setFullscreen(false);

    }
    
    


	@Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	g.clear();

  
    	

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }
    
    public static void main(String[] args) throws SlickException {
    	
        new AppGameContainer(new WindowGame(), 640, 480, false).start();
       
        
    }

    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }
}