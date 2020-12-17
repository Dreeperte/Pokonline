package pokonline.client.modeles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

import pokonline.client.controleurs.MapGameState;

public class BattleHUD implements ComponentListener {
	 private static final int SPACE = 0;
    private MouseOverArea switchpoke;
    private MouseOverArea attack;
    private MouseOverArea flee;
    private MouseOverArea bag;
    private Client c;
	  
	public BattleHUD(GameContainer container) {
		this.init(container);
	}
	private void init(GameContainer container) {
		Image button = AssetManager.loadImage("texture/button.png");
		setSwitchpoke(new MouseOverArea(container, button, container.getWidth()-(button.getWidth()+SPACE), container.getHeight() - (button.getHeight() + SPACE),this));
		setAttack(new MouseOverArea(container, button, container.getWidth()-(button.getWidth()*2+SPACE), container.getHeight() - (button.getHeight() + SPACE),this));
		setFlee(new MouseOverArea(container, button, container.getWidth()-(button.getWidth()*2+SPACE), container.getHeight() - (button.getHeight()*2 + SPACE),this));
		setBag(new MouseOverArea(container, button, container.getWidth()-(button.getWidth()+SPACE), container.getHeight() - (button.getHeight()*2 + SPACE),this));
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		if(source == this.switchpoke) {
			System.out.println("switch poke !");
		}
		else if(source == this.attack) {
			System.out.println("Attack !");
		}
		else if(source == this.flee) {
			this.c.getGame().enterState(MapGameState.ID);
			//System.out.println("flee !");
		}
		else if(source == this.bag) {
			System.out.println("open bag !");
		}
		
	}
	public MouseOverArea getSwitchpoke() {
		return switchpoke;
	}
	public void setSwitchpoke(MouseOverArea switchpoke) {
		this.switchpoke = switchpoke;
	}
	public MouseOverArea getAttack() {
		return attack;
	}
	public void setAttack(MouseOverArea attack) {
		this.attack = attack;
	}
	public MouseOverArea getFlee() {
		return flee;
	}
	public void setFlee(MouseOverArea flee) {
		this.flee = flee;
	}
	public MouseOverArea getBag() {
		return bag;
	}
	public void setBag(MouseOverArea bag) {
		this.bag = bag;
	}
	public void setClient(Client c) {
		this.c = c;
	}
	

}
