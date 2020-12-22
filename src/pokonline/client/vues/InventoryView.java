package pokonline.client.vues;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.Inventory;
import pokonline.client.modeles.Item;



public class InventoryView {
	
	private static Image img = AssetManager.loadImage("texture/inventoryBackGround.png"); 
	private static final int Y_PADDING = 12; 
	private static final int X_PADDING = 52;
	
	public static void render(Graphics g, GameContainer container,Inventory inventory) {
		g.resetTransform();
		g.drawImage(img, 0, 0);
		
		int x = 0, y = 0;
		for(Item i : inventory.getItems()) {
			g.drawImage(i.getItemImage().getScaledCopy(4), x, y);
			y += i.getItemImage().getHeight()*4;
		}
		
		inventory.getBack().render(container, g);
		AssetManager.ttf.drawString(inventory.getBack().getX()+X_PADDING, inventory.getBack().getY()+Y_PADDING, "BACK",Color.black);

	}

}
