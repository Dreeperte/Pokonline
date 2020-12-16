package pokonline.client.pokemon;
public class type {
	private static int i=0;
	private String name;
	private int nid=i;
	protected type[] strenght=null;
	protected type[] weakness=null;
	protected type[] immunity=null;
	
	
	public type(){}
	public type(String name){this.name=name;i++;}
	
	public String name() 		{return name;}
	public int numbre() 		{return nid;}
	public type[] weakness() 	{return weakness;}
	public type[] strenght() 	{return strenght;}
	public type[] immunity() 	{return immunity;}
	
	public double str(type t) {
		if (immunity!=null)
		for(int i=0;i<immunity.length;i++) {if (t==immunity[i]) return 0;}
		if (strenght!=null)
		for(int i=0;i<strenght.length;i++) {if (t==strenght[i]) return 0.5;}
		if (weakness!=null)
		for(int i=0;i<weakness.length;i++) {if (t==weakness[i]) return 2;}
		return 1;
	}
}
