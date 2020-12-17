package pokonline.client.controleurs;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import pokonline.client.modeles.Client;
import pokonline.client.modeles.MainScreen;
import pokonline.client.vues.MainScreenView;

public class MainScreenState extends BasicGameState{
	private MainScreen mainscreen;
	private Client c;
	public static int ID= 0;
	public MainScreenState(MainScreen mainscreen, Client c) {
		this.mainscreen = mainscreen;
		this.c = c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.c.setGame(game);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		MainScreenView.render(mainscreen, container, g);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
