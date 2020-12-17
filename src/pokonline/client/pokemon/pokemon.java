package pokonline.client.pokemon;
import java.util.Date;

import org.newdawn.slick.Image;

import pokonline.client.modeles.AssetManager;

public class pokemon implements Cloneable{
	private base_pkmn bpkmn; //species
	private String name; //name, by default the species one
	private int Lvl=(int)Math.random()%5;
	private int hp ,maxhp;
	private sexe sexe=null;
	private String dO=null;
	private float nId;
	private double exp=0,expnL=iexpnLVL();
	private Nat nat=null;
	//private moves[] moves= {bpkmn.moves[0],null,null,null};
	private item hold_item=null;
	private Date date=new Date();
	private String Location=null;
	private Image back;
	private Image front;
	private STATS Iv=new STATS(0,0,0,0,0,0),
			Ev=new STATS(0,0,0,0,0,0);
	
	pokemon(){}
	public pokemon(base_pkmn b){
		bpkmn=b;
		this.name = b.name();
		this.hp = (int)real_Stats().HP();
		this.maxhp = (int)real_Stats().HP();
		
		back = AssetManager.loadImage("texture/pokemon/" + b.name() + "Back.png");
		front = AssetManager.loadImage("texture/pokemon/" + b.name() + "Front.png");
		
		if (b.havesex())
			sexe=new sexe((int)Math.random()%2);
		expnLVL();
	}
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}
		return null;
	}

	public pokemon(base_pkmn b,Image front, Image back ,int Lvl,boolean legend){
		bpkmn=b;
		if (b.havesex())
			sexe=new sexe((int)Math.random()%2);
		if (!legend)
			this.Lvl=((int)Math.random()%5)+Lvl;
		else this.Lvl=Lvl;
		expnLVL();
	}
	
	
	public base_pkmn bpkmn() {return bpkmn;}
	public STATS real_Stats() {
		return new STATS(
						(int)Math.floor( ( ( (bpkmn.stats.HP()+Iv.HP()) *2 + (Math.sqrt(Ev.HP())/4) )*Lvl/100) +Lvl+10),//Hp
						(int)Math.floor( ( ( (bpkmn.stats.Atk()+Iv.Atk()) *2 + (Math.sqrt(Ev.Atk())/4) )*Lvl/100) +5),	//Atk
						(int)Math.floor( ( ( (bpkmn.stats.Def()+Iv.Def()) *2 + (Math.sqrt(Ev.Def())/4) )*Lvl/100) +5),	//Def
						(int)Math.floor( ( ( (bpkmn.stats.Spa()+Iv.Spa()) *2 + (Math.sqrt(Ev.Spa())/4) )*Lvl/100) +5),	//Spa
						(int)Math.floor( ( ( (bpkmn.stats.Spd()+Iv.Spd()) *2 + (Math.sqrt(Ev.Spd())/4) )*Lvl/100) +5),	//Spd
						(int)Math.floor( ( ( (bpkmn.stats.Spe()+Iv.Spe()) *2 + (Math.sqrt(Ev.Spe())/4) )*Lvl/100) +5)	//Spe
						);
	}
	public boolean alive() {if (hp<=0) {hp=0;return false;} return true;}
	public void nheal(int i) {
		if (i<0 || !alive()) return;
		for (int y=i;y>0;y--) {
			hp--;
			if (!alive()) {
				System.out.println(name+" have fainted.");
				break;
			}
		}
	}
	public void heal(int i) {
		if (i<0 || !alive()) return;
		for (int y=i;y>0;y--) {
			hp++;
			if (hp>=real_Stats().HP()) {
				System.out.println(y+" hp have been restored.");
				break;
			}
		}
	}
	public int Lvl() {return Lvl;}
	public void expnLVL() {
		if (Lvl<=15)
			expnL=((Lvl^3)*((((Lvl+1)/3)+24)/25));
		else if (Lvl<=36)
			expnL=((Lvl^3)*((Lvl+14)/25));
		else expnL=((Lvl^3)*(((Lvl/2)+32)/25));
	}
	public int iexpnLVL() {
		if (Lvl<=15)
			return ((Lvl^3)*((((Lvl+1)/3)+24)/25));
		else if (Lvl<=36)
			return ((Lvl^3)*((Lvl+14)/25));
		else return ((Lvl^3)*(((Lvl/2)+32)/25));
	}
	public void expOnBattle(pokemon pkmnd) {//*1.5 if lucky egg attached *1.5 more if the pkmn isn't originally from his trainer divided by all the pkmn that've been in battle
		exp+=(pkmnd.bpkmn.expOnD*pkmnd.Lvl/5*((2*pkmnd.Lvl+10)^(5/2))/(pkmnd.Lvl+this.Lvl+10)^(5/2));
	}
	public void OnNLVL() {
		if (exp>=expnL && Lvl<100) {
			exp-=expnL;
			Lvl++;
			expnLVL();
		}
	}
	public Image getBack() {
		return back;
	}
	public void setBack(Image back) {
		this.back = back;
	}
	public Image getFront() {
		return front;
	}
	public void setFront(Image front) {
		this.front = front;
	}
	public int getMaxhp() {
		return maxhp;
	}
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	public int gethp() {
		return this.hp;
	}
	public void sethp(int hp) {
		this.hp = hp;
	}
}
