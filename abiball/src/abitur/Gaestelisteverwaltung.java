package abitur;

public class Gaestelisteverwaltung {
	
	public List<Person> gaesteliste = new List<Person>();
	
	public void gastHinzufügen(String pName, String pNachname, String pEmail) {
		gaesteliste.toFirst();
		Person tmp_add = new Person(pName, pNachname, pEmail);	
		
	    if (gastAnzahl() == 0) {
	        gaesteliste.append(tmp_add);
	        return;
	    }
		    
		while(gaesteliste.hasAccess()) {
				
			String current_name = gaesteliste.getContent().getNachname();
			if(current_name.contentEquals(pNachname)) {
				gaesteliste.insert(tmp_add);
				break;
			}
			else {
				gaesteliste.next();
			}


		}
		gaesteliste.append(tmp_add);
		
	}
	
	public void gastEntfernen(String pName, String pNachname) {
		gaesteliste.toFirst();
		
		while(gaesteliste.hasAccess()) {
			
			String current_name = gaesteliste.getContent().getName();
			String current_nachname = gaesteliste.getContent().getNachname();
			
			
			if(current_name.contentEquals(pName) && current_nachname.contentEquals(pNachname) && gaesteliste.hasAccess()) {
				gaesteliste.remove();
				break;
			}
			else {
				gaesteliste.next();
			}

		}
		
	}
	
	public boolean gastChecken(String pName, String pNachname) {
		boolean oup = false;
		gaesteliste.toFirst();
		
		while(gaesteliste.hasAccess()) {
			String current_name = gaesteliste.getContent().getName();
			String current_nachname = gaesteliste.getContent().getNachname();
			
			if(current_name.contentEquals(pName) && current_nachname.contentEquals(pNachname) && gaesteliste.hasAccess()) {
				oup = true;
				break;
			}
			else {
				gaesteliste.next();
			}
		}
		return oup;
	}
	
	public void gastAusgabe() {
		gaesteliste.toFirst();
		while(gaesteliste.hasAccess()) {
			System.out.println(gaesteliste.getContent().getName() + "	" + gaesteliste.getContent().getNachname() + "	" + gaesteliste.getContent().getEmail());
			gaesteliste.next();
			}
	}
	
	
	public int gastAnzahl() {
	    int i = 0;
	    gaesteliste.toFirst();
	    while (gaesteliste.hasAccess()) {
	        i++;
	        gaesteliste.next();
	    }
	    return i;
	}
	
	
	
}
