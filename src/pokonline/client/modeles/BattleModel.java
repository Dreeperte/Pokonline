package pokonline.client.modeles;

import org.newdawn.slick.Image;

public class BattleModel {
	private Client c;
	private Image background;
	public BattleModel(Client c, MapModeles map) {
		this.c = c;
	}
	public Image getBackground() {
		return background;
	}
	public void setBackground(Image background) {
		this.background = background;
	}

}
