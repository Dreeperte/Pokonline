package pokonline.client.modeles;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

import pokonline.client.controleurs.AnimationControleurs;
import pokonline.client.controleurs.MapControleurs;
import pokonline.client.pokemon.pokemon;

public class PlayerModeles {
	private int x,y;
	private String name;
	private Image image;
	private String direction = "down";
	private String info = "";
	private int speed = 4;
	private boolean update = false;
	private boolean moving = false;
	private boolean leave;
	private boolean released;
	private boolean inbattle = false;
	private boolean platerTurn = false;
	private MapModeles currentmap;
	private ArrayList<pokemon> pkmns = new ArrayList<>();
	private Animation animation[];
	private Inventory inventaire;
	public PlayerModeles(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.animation = AnimationModeles.setAnimationP(AnimationControleurs.spritePlayer);
		this.image = AssetManager.stone;
		this.currentmap = MapControleurs.m1;
		// TODO Auto-generated constructor stub
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		this.setInfo(x+";" +y);
		this.setUpdate(true);
	}
	public int getY() {
		return y;
		
	}
	
	public void update() {
		   switch(this.getDirection()) {
		   case("down"):
			   if(this.isMoving())
				   this.setY(this.getY()+this.getSpeed());
			   break;
		   case("left"):
			   if(this.isMoving())
				   this.setX(this.getX()-this.getSpeed());
			   break;
		   case("right"):
			   if(this.isMoving())
				   this.setX(this.getX()+this.getSpeed());
			   break;
		   case("up"):
			   if(this.isMoving())
				   this.setY(this.getY()-this.getSpeed());
			   break;
		   }
	}
	
	public void setY(int y) {
		this.y = y;
		this.setInfo(x+";"+y);
		this.setUpdate(true);
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
		
		this.setMoving(true);
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
		//this.setUpdate(true);
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Animation[] getAnimation() {
		return animation;
	}
	public void setAnimation(Animation[] animation) {
		this.animation = animation;
	}
	public boolean isLeave() {
		return leave;
	}
	public void setLeave(boolean leave) {
		this.leave = leave;
	}
	public boolean isReleased() {
		return released;
	}
	public void setReleased(boolean released) {
		this.released = released;
	}
	public MapModeles getCurrentmap() {
		return currentmap;
	}
	public void setCurrentmap(MapModeles currentmap) {
		this.currentmap = currentmap;
	}
	public boolean isInbattle() {
		return inbattle;
	}
	public void setInbattle(boolean inbattle) {
		this.inbattle = inbattle;
	}
	public ArrayList<pokemon> getPkmns() {
		return pkmns;
	}
	public void setPkmns(ArrayList<pokemon> pkmns) {
		this.pkmns = pkmns;
	}
	public void addPkmns(pokemon pkmns) {
		this.pkmns.add(pkmns);
	}
	public boolean isPlaterTurn() {
		return platerTurn;
	}
	public void setPlaterTurn(boolean platerTurn) {
		this.platerTurn = platerTurn;
	}
	public Inventory getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventory inventaire) {
		this.inventaire = inventaire;
	}
	
	
	
	

}
