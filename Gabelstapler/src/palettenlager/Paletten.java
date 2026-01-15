package palettenlager;

public class Paletten {
	String name;
	boolean kaputt;
	int groesse;
	
	
	public Paletten(String pName, boolean pKaputt, int pGroesse) {
		name = pName;
		kaputt = pKaputt;
		groesse = pGroesse;
	}
	
	public String gibName() {
		return name;
	}
	
	public boolean gibKaputt() {
		return kaputt;
	}
	
	public int gibGroesse() {
		return groesse;
	}
	
}
