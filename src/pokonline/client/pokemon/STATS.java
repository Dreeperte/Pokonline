package pokonline.client.pokemon;
public class STATS {
	//base stats
	private int HP=0;
	private int Atk=0;
	private int Def=0;
	private int Spa=0;
	private int Spd=0;
	private int Spe=0;
	
	public STATS(int hp,int atk,int def,int spa,int spd,int spe){
		HP=hp;
		Atk=atk;
		Def=def;
		Spa=spa;
		Spd=spd;
		Spe=spe;
	}
	public STATS(){}
	
	public double HP(){return HP;}
	public double Atk(){return Atk;}
	public double Def(){return Def;}
	public double Spa(){return Spa;}
	public double Spd(){return Spd;}
	public double Spe(){return Spe;}
	
}

