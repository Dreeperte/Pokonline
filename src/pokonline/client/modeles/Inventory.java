package pokonline.client.modeles;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<>();
	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
