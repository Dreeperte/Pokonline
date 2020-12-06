package pokonline.client.modeles;

import org.newdawn.slick.Image;

public class PlayerModeles {
	private int x,y;
	private String name;
	private Image image;
	private String direction = "down";
	private boolean update = false;
	public PlayerModeles(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.image = AssetManager.stone;
		// TODO Auto-generated constructor stub
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
		//this.setUpdate(true);
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}

}
