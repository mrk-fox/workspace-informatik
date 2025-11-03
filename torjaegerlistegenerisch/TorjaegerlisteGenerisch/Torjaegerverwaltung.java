public class Torjaegerverwaltung{
  private List<Fussballer> meineListe;
  
  public Torjaegerverwaltung(){
    meineListe = new List<Fussballer>();
  }
  
  /** Die Methode soll einen neuen Fussballer in die Torjaegerliste
  einsortieren. Die Torjaegerliste ist nach Toren absteigend sortiert.
  D.h. der Fussballer mit den meisten Toren steht vorne. Der neue 
  Fussballer wird auch hinter den Fussballern eingereicht, die die 
  gleiche Toranzahl haben.
  */
  public void hinzufuegen(String pName, int pTore, int pBiere, String pVerein){
    meineListe.toFirst();
    while (meineListe.hasAccess() && pTore <= meineListe.getContent().gibTore()) {
      meineListe.next();
    }
    double pQuote = pTore/pBiere;
    Fussballer neuerFussballer = new Fussballer(pName, pTore, pBiere, pVerein, pQuote);
    
    // Wenn das Ende der Liste noch nicht erreicht wurde, wird eingefügt, sonst wird angefügt
    if (meineListe.hasAccess()) {
       meineListe.insert(neuerFussballer);
    } else {
        meineListe.append(neuerFussballer);
    }
    findeFussballer("Mark");
  }
  
  
  
  public void loesche(String pName){
    meineListe.toFirst();
    while (meineListe.hasAccess() && !meineListe.getContent().gibName().equals(pName)) {
      meineListe.next();  
    }  
    meineListe.remove();
  }
  
  
  public int vs(String pVerein){
    meineListe.toFirst();
    int vereinssumme = 0;
	    while (meineListe.hasAccess()) {
	      if (meineListe.getContent().gibVerein().equals(pVerein)) {
	    	  vereinssumme = meineListe.getContent().gibTore() + vereinssumme;
	    	  meineListe.next();
	      }
	      else {
	    	  meineListe.next();
	      }
	    }  
	    return vereinssumme;
  }
  
  
  
  /**
  Alle Fussballer in der Liste werden mit der Toranzahl ausgegeben.
  */
  public String gibAusgabe(){
    String ausgabe = "";
    meineListe.toFirst();
    while (meineListe.hasAccess()) {    
      Fussballer tempFussballer = meineListe.getContent();
      ausgabe += tempFussballer.gibName() + " Tore: " + tempFussballer.gibTore() + " Verein: " + tempFussballer.gibVerein() + " Vereinsumme: " + vs("BVB") + "\n";
      meineListe.next();
    }  
    return ausgabe;
  }
  
  
  public Fussballer findeFussballer(String pName) {
	  meineListe.toFirst();
	  boolean retVal = false;
	  Fussballer aktFussballer = meineListe.getContent();
	  while (meineListe.hasAccess() && !retVal) {
		  
		  if (aktFussballer.gibName().equals(pName)) {
			  retVal = true;
		  }
		  else {
			  meineListe.next();
		  }
	
	  }
	  return aktFussballer;
  }
  
  public Fussballer ermittleBesteQuote() {
	  Fussballer besteQuoteFussballer = meineListe.getContent();
	  meineListe.toFirst();
	  double currentQuote = 0;
	  
	  while(meineListe.hasAccess()) {
		  Fussballer aktFussballer = meineListe.getContent();
		  if(aktFussballer.gibQuote() > currentQuote) {
			  currentQuote = aktFussballer.gibQuote();
			  besteQuoteFussballer = aktFussballer;
			  meineListe.next();
		  }
		  else {
			  meineListe.next();
		  }
	  }	  
	  
	  return besteQuoteFussballer;
  }
  // Für Donnerstag: NetSchubuch Abiball a+b+c
  
  
}
