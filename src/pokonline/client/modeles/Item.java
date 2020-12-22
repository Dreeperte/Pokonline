package pokonline.client.modeles;

import org.newdawn.slick.Image;

public abstract class Item {
	protected int quantity;
	protected int price;
	protected Image itemImage;
	protected String name;
	protected String type;
	public Item(int quantity, int price, Image itemImage, String name) {
		this.quantity = quantity;
		this.price = price;
		this.itemImage = itemImage;
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Image getItemImage() {
		return itemImage;
	}
	public void setItemImage(Image itemImage) {
		this.itemImage = itemImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
