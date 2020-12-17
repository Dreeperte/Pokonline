package pokonline.client.pokemon;
public class Team {
	protected pokemon[] pkmnTeam = {null,null,null,null,null,null};
	private boolean faintedteam=true;

	protected void fainted() {
		for (int i=0;i<pkmnTeam.length-1;i++)
			if (pkmnTeam[i] != null) 
				if (pkmnTeam[i].alive()) {faintedteam=true;return;}
		faintedteam=false;
	}
	public boolean alive() {
		fainted();
		return faintedteam;
	}
}
