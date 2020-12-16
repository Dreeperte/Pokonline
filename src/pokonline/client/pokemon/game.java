package pokonline.client.pokemon;
import java.io.*;
import java.util.*;

public class game {
	
	public void dmg(pokemon pkmn1,moves move, pokemon pkmn2) {
		float Modifier=1;
		if (Math.random()%6>5) Modifier=2; 							//Crit
		if (pkmn1.bpkmn().t2 != null) {								//STAB
			if (move.t==pkmn1.bpkmn().t1 || move.t==pkmn1.bpkmn().t2) Modifier*=1.5;} 
		else if (move.t==pkmn1.bpkmn().t1) Modifier*=1.5;
		if (move.cac_dist_none=="cac")
			 pkmn2.nheal((int)Math.round( 								//physique vs physique
					 (((2*pkmn1.Lvl()/5+2)*move.power*pkmn1.real_Stats().Atk()/pkmn2.real_Stats().Def())/50+2)*Modifier));
		else pkmn2.nheal((int)Math.round( 								//dist vs dist
					 (((2*pkmn1.Lvl()/5+2)*move.power*pkmn1.real_Stats().Spa()/pkmn2.real_Stats().Spd())/50+2)*Modifier));
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		
		// type in file example:	type,:,strength,...,...,...,...,...,	:,weakness,...,...,...,	 :,immunity,;
		//							fire,:,bug,fairy,fire,grass,ice,steel,	:,ground,rock,water,				;
		// example n°2				normal,:,:,fighting,:ghost,;
		type bug = new type("bug");
		type dark = new type("dark");
		type dragon = new type("dragon");
		type electric = new type("electric");
		type fairy = new type("fairy");
		type fighting = new type("fighting");
		type fire = new type("fire");
		type flying = new type("flying");
		type ghost = new type("ghost");
		type grass = new type("grass");
		type ground = new type("ground");
		type ice = new type("ice");
		type normal = new type("normal");
		type poison = new type("poison");
		type psychic = new type("psychic");
		type rock =new type("rock");
		type steel = new type("steel");
		type water = new type("water");
		File types = new File("src\\types");
		
		File str_weak = new File("src\\s&w&i");
		
		/*Scanner sct=new Scanner(types);
		Scanner scstr=new Scanner(str_weak).useDelimiter(",");
		for(;;) {
			String s=sct.nextLine();
			for (;;) {
				
			}
		}*/
		
		
		
		//base_pkmn bpkmnBulbasaur = new base_pkmn("Bulbasaur",new STATS(45,49,49,65,65,45),grass,poison,16);
		//base_pkmn bpkmnIvysaur = new base_pkmn("Ivysaur",new STATS(60,62,63,80,80,60),grass,poison,32);
		base_pkmn bpkmnVenusaur = new base_pkmn("Venusaur",new STATS(80,82,83,100,100,80),grass,poison);
		
		//base_pkmn bpkmnCharmender = new base_pkmn("Charmender",new STATS(39,52,43,60,50,65),fire,16);
		//base_pkmn bpkmnCharmeleon = new base_pkmn("Charmeleon",new STATS(58,64,58,80,65,80),fire,36);
		base_pkmn bpkmnCharizard = new base_pkmn("Charizard",new STATS(78,84,78,109,85,100),fire,flying);
		
		//base_pkmn bpkmnSquirtle = new base_pkmn("Squirtle",new STATS(44,48,65,50,64,43),water,16);
		//base_pkmn bpkmnWartortle = new base_pkmn("Squirtle",new STATS(59,63,80,65,80,58),water,36);
		base_pkmn bpkmnBlastoise = new base_pkmn("Blastoise",new STATS(79,83,100,85,105,78),water);
		
		//base_pkmn bpkmnCaterpie = new base_pkmn("Caterpie",new STATS(45,30,35,20,20,45),bug,7);
		//base_pkmn bpkmnMetapod = new base_pkmn("Metapod",new STATS(50,20,55,25,25,30),bug,10);
		base_pkmn bpkmnButterfree = new base_pkmn("Butterfree",new STATS(60,45,50,90,80,70),bug,flying);
		
		System.out.println(bpkmnButterfree.name() +" "+ bpkmnButterfree.stats.Atk() +" "+ bpkmnButterfree.stats.Def() + " " + bpkmnButterfree.stats.HP());
	}

}
