package pokonline.client.controleurs;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



import pokonline.client.modeles.BattleHUD;
import pokonline.client.modeles.Client;
import pokonline.client.vues.WorldView;

public class MapGameState extends BasicGameState{
	private Client c;
	private BattleHUD bth;
	public static Object lock = new Object();
	private int tick = 0;
	public static int ID= 0;

	public MapGameState(Client c,BattleHUD bth) 
	{
		this.bth = bth;
		this.c = c;
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		this.c.setGame(state);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
    	g.clear();
		synchronized(lock) {
			WorldView.render(WorldControleurs.getWorld(),this.c ,g,container);
			
		}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame arg1, int delta) throws SlickException {
		// TODO Auto-generated method stub
		synchronized(lock) {
			this.c.updateClient(container);
			WorldControleurs.updateplayer();
			if(this.c.getP1().isLeave()) {
				container.exit();
			}
	        for (int objectID = 0; objectID < this.c.getP1().getCurrentmap().getMap().getObjectCount(0); objectID++) {				//Detection des events sur la tiled map.
	            if (this.c.getP1().getX() > this.c.getP1().getCurrentmap().getMap().getObjectX(0, objectID)
	                    && this.c.getP1().getX() < this.c.getP1().getCurrentmap().getMap().getObjectX(0, objectID) + this.c.getP1().getCurrentmap().getMap().getObjectWidth(0, objectID)
	                    && this.c.getP1().getY() > this.c.getP1().getCurrentmap().getMap().getObjectY(0, objectID)
	                    && this.c.getP1().getY() < this.c.getP1().getCurrentmap().getMap().getObjectY(0, objectID) + this.c.getP1().getCurrentmap().getMap().getObjectHeight(0, objectID)) { //Si le joueur est dans un event
	            	
	            	
	                if ("switch".equals(this.c.getP1().getCurrentmap().getMap().getObjectType(0, objectID))) {
	                	int nx = Integer.parseInt(this.c.getP1().getCurrentmap().getMap().getObjectProperty(0, objectID, "detx","undefined"));
	                	int ny = Integer.parseInt(this.c.getP1().getCurrentmap().getMap().getObjectProperty(0, objectID, "dety","undefined"));
	                	this.c.getP1().setX(nx); 
	                	this.c.getP1().setY(ny);
	                	this.c.getP1().setCurrentmap(MapControleurs.searchMap(this.c.getP1().getCurrentmap().getMap().getObjectProperty(0, objectID, "mapname", "undefined")));
	                	this.c.setSwitchMap(true);

	                } 

	            }
	 





	           
	 
	         }



			if(this.c.getP1().isMoving()) {
	            float futurX = getFuturX(delta);
	            float futurY = getFuturY(delta);
	            if(WorldControleurs.isCollision2(this.c.getP1().getX(), this.c.getP1().getY(), this.c,this.c.getP1().getCurrentmap())) {
	                Random rand = new Random(); //instance of random class
	                int upperbound = 1000;
	                int int_random = rand.nextInt(upperbound);
	                if(int_random < 10) {
	                	this.c.getGame().enterState(CombatGameState.ID);
	                	//this.c.getP1().setInbattle(true);
	                	//this.c.getP1().setMoving(false);
	                	//System.out.println("BATTLE!");
	                }
		        }
	            else {
	            	this.c.setL2(false);
	            }

	            
	            this.c.setCollision( WorldControleurs.isCollision(futurX, futurY, this.c.getP1().getCurrentmap()));
	            if (c.isCollision()) {
	            	this.c.getP1().setMoving(false);
	            	this.c.getP1().setReleased(true);
	            } 

	            else {
	            	this.c.getP1().setX((int) futurX);
	            	this.c.getP1().setY((int) futurY);
	            }
	            
	            

			}


		}
		
	}
	
    private float getFuturX(int delta){
        float futurX = this.c.getP1().getX();
        switch (this.c.getP1().getDirection()) {
        case "left": futurX = this.c.getP1().getX() - this.c.getP1().getSpeed(); break;
        case "right": futurX = this.c.getP1().getX() + this.c.getP1().getSpeed(); break;
        }
        return futurX;
    }

    private float getFuturY(int delta) {
        float futurY = this.c.getP1().getY();
        switch (this.c.getP1().getDirection()) {
        case "up": futurY = this.c.getP1().getY() - this.c.getP1().getSpeed(); break;
        case "down": futurY = this.c.getP1().getY() + this.c.getP1().getSpeed(); break;
        }
        return futurY;
    }
    @Override
    public void keyReleased(int key, char c) {
    	synchronized(lock) {
    		this.c.getP1().setMoving(false);
    		this.c.getP1().setReleased(true);
    	}
    }
    @Override
    public void keyPressed(int key, char c) {
    	synchronized(lock) {
	    	switch (key) {
	    		case Input.KEY_D:    
    				if(!this.c.getP1().isMoving()) {
    					this.c.getP1().setDirection("right");
    					this.c.getP1().setMoving(true);
    					this.c.setKeypressed(true);
    				}
	    			break;
	    		case Input.KEY_Q: 
	    			if(!this.c.getP1().isMoving()) {
	    				this.c.getP1().setDirection("left");
	    				this.c.getP1().setMoving(true);
	    				this.c.setKeypressed(true);
	    			}
	    			break;
	    		case Input.KEY_S:
	    			if(!this.c.getP1().isMoving()) {
	    				this.c.getP1().setDirection("down");
	    				this.c.getP1().setMoving(true);
	    				this.c.setKeypressed(true);
	    			}
	    			break;
	    		case Input.KEY_Z:
	    			if(!this.c.getP1().isMoving()) {
	    				this.c.getP1().setDirection("up");
	    				this.c.getP1().setMoving(true);
	    				this.c.setKeypressed(true);
	    			}
	    			break;
	    		case Input.KEY_ESCAPE:
	    				this.c.getP1().setLeave(true);
	    			break;
	
	 
	    	}
    	}

    }

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
