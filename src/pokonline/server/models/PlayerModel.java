package pokonline.server.models;

public class PlayerModel {
	private int id;
	private int x,y;
	private int speed = 3;
	private String direction;
    private String name;
    private String map;
    
    private boolean isMoving = false;
    
    public PlayerModel(int id, int x, int y, String name, String map) {
    	this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
        this.direction = "released";
        this.map = map;
    }
    
    public int getSpeed() {
    	return speed;
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
    
    public int getId() {
    	return id;
    }
    
    public void setDirection(String direction) {
    	this.direction = direction;
    }
    
    public String getDirection() {
    	return this.direction;
    }
    
    public void setIsMoving(boolean isMoving) {
    	this.isMoving = isMoving;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
