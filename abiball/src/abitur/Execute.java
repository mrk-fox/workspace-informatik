package abitur;

public class Execute {

	public static void main(String[] args) {
		Gaestelisteverwaltung gaestelisteverwaltung = new Gaestelisteverwaltung();
		gaestelisteverwaltung.gastHinzufügen("Mark", "Fox", "markfoxsemail@gmail.com");
		gaestelisteverwaltung.gastHinzufügen("Vladimir", "Putin", "russiasdictator@gmail.com");
		gaestelisteverwaltung.gastHinzufügen("Friedrich", "Maerz", "DeutschlandsSchmerz@gmail.com");
		gaestelisteverwaltung.gastHinzufügen("Niemand", "Niemandsson", "@gmail.com");
		//Alles satire :)
		
		
		System.out.println(gaestelisteverwaltung.gastAnzahl());
		gaestelisteverwaltung.gastEntfernen("Niemand", "Niemandsson");
		System.out.println(gaestelisteverwaltung.gastAnzahl());
		System.out.println(gaestelisteverwaltung.gastChecken("Niemand", "Niemandsson"));
		gaestelisteverwaltung.gastAusgabe();
		
		
		
		

	}

}
