package pokonline.client.pokemon;
public class Nat extends STATS {
	private final String name;
	private double HP=0;
	private double Atk=0;
	private double Def=0;
	private double Spa=0;
	private double Spd=0;
	private double Spe=0;
	
	public Nat(String name,String s1,String s2){
		this.name=name;
		if (s1.length()>3 || s1.length()<2 || s2.length()>3 || s2.length()<2 || s1==s2) return;
		else {
			switch(s1) {
			case "HP":HP=1.1;switch(s2) {
				case "Atk":Atk=0.9;return;
				case "Def":Def=0.9;return;
				case "Spa":Spa=0.9;return;
				case "Spd":Spd=0.9;return;
				case "Spe":Spe=0.9;return;}
			
			case "Atk":Atk=1.1;switch(s2) {
				case "HP":HP=0.9;return;
				case "Def":Def=0.9;return;
				case "Spa":Spa=0.9;return;
				case "Spd":Spd=0.9;return;
				case "Spe":Spe=0.9;return;}
			
			case "Def":Def=1.1;switch(s2) {
				case "HP":HP=0.9;return;
				case "Atk":Atk=0.9;return;
				case "Spa":Spa=0.9;return;
				case "Spd":Spd=0.9;return;
				case "Spe":Spe=0.9;return;}
			
			case "Spa":Spa=1.1;switch(s2) {
				case "HP":HP=0.9;return;
				case "Atk":Atk=0.9;return;
				case "Def":Def=0.9;return;
				case "Spd":Spd=0.9;return;
				case "Spe":Spe=0.9;return;}
			
			case "Spd":Spd=1.1;switch(s2) {
				case "HP":HP=0.9;return;
				case "Atk":Atk=0.9;return;
				case "Def":Def=0.9;return;
				case "Spa":Spa=0.9;return;
				case "Spe":Spe=0.9;return;}
			
			case "Spe":Spe=1.1;switch(s2) {
				case "HP":HP=0.9;return;
				case "Atk":Atk=0.9;return;
				case "Def":Def=0.9;return;
				case "Spa":Spa=0.9;return;
				case "Spd":Spd=0.9;return;}
			}
		}
	}

	public String getnat() {
		String i="0",j="0";
		if (HP!=1 || i=="0")i="HP";else j="HP";
		if (Atk!=1 || i=="0")i="Atk";else j="Atk";
		if (Def!=1 || i=="0")i="Def";else j="Def";
		if (Spa!=1 || i=="0")i="Spa";else j="Spa";
		if (Spd!=1 || i=="0")i="Spd";else j="Spd";
		if (Spe!=1 || i=="0")i="Spe";else j="Spe";
		if (i!="0") return name+" : "+i+"+ "+j+"-";
		return name+" : neutre";
		}
	public String nat() {
		return name;
	}
	
	public double HP(){return HP;}
	public double Atk(){return Atk;}
	public double Def(){return Def;}
	public double Spa(){return Spa;}
	public double Spd(){return Spd;}
	public double Spe(){return Spe;}
}
