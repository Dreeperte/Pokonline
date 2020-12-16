
package pokonline.client.pokemon;

public class Abilities {
	private String name;
	private boolean damage_impact=false;
	
	protected Abilities(String name) {this.name=name;}
	protected Abilities(String name,boolean b) {this.name=name;damage_impact=b;}
}
