package pokonline.client.controleurs;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import pokonline.client.modeles.Client;
import pokonline.client.vues.InventoryView;

public class InventoryGameState extends BasicGameState{
	private Client c;
	public static int ID = 4;
	
	public InventoryGameState(Client c) {
		this.c = c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer g, StateBasedGame state) throws SlickException {
		// TODO Auto-generated method stub
		this.c.setGame(state);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		InventoryView.render(g, container, c.getP1().getInventaire());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer g, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
