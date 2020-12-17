package pokonline.client.pokemon;
public class sexe {
	private int i=0;
	
	public sexe() {}	
	public sexe(int i) {this.i=i;}
	public int ns() {return i;}
	public String sexe() {
		if (ns()==1)
			return "male";
		if (ns()==2)
			return "femelle";
		return null;
	}
}
