package pokonline.server.models;

public class PlayerModel {
	private int id;
	private int x,y;
    private String name;
    
    public PlayerModel(int id, int x, int y, String name) {
    	this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
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
}
