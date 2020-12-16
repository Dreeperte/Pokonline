package pokonline.client.modeles;

import org.newdawn.slick.Image;

import pokonline.client.pokemon.pokemon;

public class BattleModel {
	private Image background;
	private pokemon pkmn;
	private MapModeles map;
	public BattleModel(MapModeles map) {
		this.map = map;
	}
	
	public Image getBackground() {
		return background;
	}
	public void setBackground(Image background) {
		this.background = background;
	}
	public pokemon getPkmn() {
		return pkmn;
	}
	public void setPkmn(pokemon pkmn) {
		this.pkmn = pkmn;
	}

	public MapModeles getMap() {
		return map;
	}

	public void setMap(MapModeles map) {
		this.map = map;
	}

}
