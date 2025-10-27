package triage;

public class Patient {
	private String name;
	private int age;
	private String verletzung;
	private int kategorie;
	private boolean privatversichert;
	
	public Patient(String pName, int pAge, String pVerletzung, int pKategorie, boolean pPrivatversicherung) {
		name = pName;
		age = pAge;
		verletzung = pVerletzung;
		kategorie = pKategorie;
		privatversichert = pPrivatversicherung;
	}
	//getter-methods
	
	public String gibName() {
		return name;
	}
	public int gibAlter() {
		return age;
	}
	public String gibVerletzung() {
		return verletzung;
	}
	public int gibKategorie() {
		return kategorie;
	}
	public boolean gibVersicherung() {
		return privatversichert;
	}
	
	public String gibAlles() {
		String all = name + "\n" + Integer.toString(age) + "\n" + verletzung + "\n" + Integer.toString(kategorie) + "\n" + Boolean.toString(privatversichert);
		return all;
	}
}
