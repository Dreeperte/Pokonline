package pokonline.client.modeles;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

import pokonline.client.controleurs.CombatGameState;
import pokonline.client.controleurs.MapGameState;

public class Inventory implements ComponentListener{
	private ArrayList<Item> items = new ArrayList<>();
    private MouseOverArea back;
    private Client c;
	public Inventory(GameContainer container, Client c) {
		Image button = AssetManager.button;
		setBack(new MouseOverArea(container, button, container.getWidth()-(button.getWidth()), container.getHeight() - (button.getHeight()),this));
		this.c = c;
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public void addItems(Item item) {
		this.items.add(item);
	}
	public MouseOverArea getBack() {
		return back;
	}
	public void setBack(MouseOverArea back) {
		this.back = back;
	}
	@Override
	public void componentActivated(AbstractComponent source) {
		if(source == back) {
			if(this.c.isInInventory()) {
				this.c.getGame().enterState(CombatGameState.ID);
			}
			else {
				this.c.getGame().enterState(MapGameState.ID);
			}
		}
		// TODO Auto-generated method stub
		
	}

}
