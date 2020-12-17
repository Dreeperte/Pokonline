package pokonline.client.pokemon;
public final class base_pkmn {
	private static float n0=1;
	private float n=n0;
	private String name;
	private boolean have_a_sex=false;
	protected final STATS stats,
						EvOnD=new STATS(0,0,0,0,0,0);
	protected int expOnD=0;
	protected final type t1, t2;
	protected Abilities[] ab = new Abilities[3];
	protected moves[] moves = new moves[200];
	
	public base_pkmn(String name, STATS stats, type t1, type t2) {
		this.name=name;
		this.stats=stats;
		this.t1=t1;
		this.t2=t2;
		n0++;
	}
	public base_pkmn(String name, STATS stats, type t1) {
		this.name=name;
		this.stats=stats;
		this.t1=t1;
		this.t2=null;
		n0++;
	}
	public String name() {return name;}
	
	public void addm(moves m) {
		for (int i=0;i<moves.length;i++)
			if (m==moves[i])
				break;
	}
	protected void setn(float x) {n=(int)x;if (n0<n) n0=n+1;}
	protected int getn() {return (int)n;}
	public boolean havesex() {return have_a_sex;}
}
