package pokonline.client.controleurs;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import pokonline.client.modeles.BattleHUD;
import pokonline.client.modeles.BattleModel;
import pokonline.client.modeles.Client;
import pokonline.client.modeles.EventObject;
import pokonline.client.vues.BattleView;

public class CombatGameState extends BasicGameState{
	private BattleHUD bth;
	private BattleModel bm;
	private Client c;
	public static int ID= 2;
	public static 	EventObject singleFireEvent2;
	public CombatGameState(Client c, BattleHUD bth, BattleModel bm) {
		this.c = c;
		this.bth = bth;
		this.bm = bm;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		this.c.setGame(state);
		
		singleFireEvent2 = new EventObject(1000, false);
		this.c.getP1().setReleased(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		BattleView.render( g, container,bth,bm,this.c.getP1(),singleFireEvent2);
		
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int delta) throws SlickException {
		if(this.bm.getPkmn().gethp() <= 0) {
			this.c.getGame().enterState(MapGameState.ID);
		}
		if(this.c.getP1().isPlaterTurn()) {
			this.bm.getPkmn().sethp((int) (this.bm.getPkmn().gethp() - c.getP1().getPkmns().get(0).real_Stats().Atk()));
			this.c.getP1().setPlaterTurn(false);
		}
		singleFireEvent2.update(delta);
		
		// TODO Auto-generated method stub
		
	}

	public static int getIDload(int duration) {
		BattleView.setTrigger(true);
		
		singleFireEvent2 = new EventObject(duration, false);
		return ID;
	}
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
