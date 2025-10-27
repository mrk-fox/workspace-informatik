package triage;
import java.util.Scanner;

public class processor {
	List<Patient> notaufnahme = new List<Patient>();
	List<Patient> triage = new List<Patient>();
	String name;
	int age;
	String verletzung;
	int kategorie;
	boolean privatversichert;
	

	
	public void input() {
		Scanner s = new Scanner(System.in);
		System.out.print("Name: ");
		name = s.nextLine();

		System.out.print("Alter: ");
		age = Integer.parseInt(s.nextLine());  // hier nextLine + parseInt

		System.out.print("Verletzung: ");
		verletzung = s.nextLine();

		System.out.print("Kategorie: ");
		kategorie = Integer.parseInt(s.nextLine());

		System.out.print("Privatversichert (J/Ja/Nein): ");
		String privatversichert_pre = s.nextLine();
		if (privatversichert_pre.equalsIgnoreCase("Ja") || privatversichert_pre.equalsIgnoreCase("J")) {
			privatversichert = true;
		}
		else {
			privatversichert = false;
		}
		
		
		Patient neuerPatient = new Patient(name, age, verletzung, kategorie, privatversichert);
		notaufnahme.toFirst();
		if (!notaufnahme.isEmpty()) {
			while (notaufnahme.hasAccess() && notaufnahme.getContent().gibKategorie() < neuerPatient.gibKategorie()) {
				notaufnahme.next();
			}
			notaufnahme.insert(neuerPatient);
		}
		else {
			notaufnahme.insert(neuerPatient);
		}
		
	}
	
	public void print() {
		notaufnahme.toFirst();
		System.out.println(notaufnahme.getContent().gibAlles());
		while (notaufnahme.hasAccess()) {
			
			notaufnahme.next();
			System.out.println(notaufnahme.getContent().gibAlles());
		}
		
	}
	
	public void nextPat() {
		
	}
	
	public Patient gibLetzten() {
		notaufnahme.toLast();
		return notaufnahme.getContent();
	}
	

}
