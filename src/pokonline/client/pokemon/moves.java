package pokonline.client.pokemon;
public class moves {
	String name;/*
   can't be NULL*/
	int power;/*
   NULL if it's a stat move*/
	int accuracy;/*
  chance of hit, can be null, if so accuracy will be 100%
  in any case even with stats modiff (if the target can be reached)*/
	type t;/*
   grass/fire/water/ground... can't be NULL*/
	String cac_dist_none;/*
   if it use Spa or Atk, or if it is a stat move, can be NULL*/
	moves_effect me;/*
   paralysis etc... can be NUll*/
	int pp;/*
   can't be NULL*/

	moves(String n, int p, int a, moves_effect me, int pp, type t, String cdn) {
		name=n;
		power=p;
		accuracy=a;
		this.me=me;
		this.pp=pp;
		this.t=t;
		cac_dist_none=cdn;
	}
	moves(String n, int p, moves_effect me, int pp, type t, String cdn) {
		name=n;
		power=p;
		this.me=me;
		this.pp=pp;
		this.t=t;
		cac_dist_none=cdn;
	}
	moves(String n, int p, int a, int pp, type t, String cdn) {
		name=n;
		power=p;
		accuracy=a;
		this.pp=pp;
		this.t=t;
		cac_dist_none=cdn;
	}
	moves(String n, int p, int pp, type t, String cdn) {
		name=n;
		power=p;
		this.pp=pp;
		this.t=t;
		cac_dist_none=cdn;
	}
	
}
