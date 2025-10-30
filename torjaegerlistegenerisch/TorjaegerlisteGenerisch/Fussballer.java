public class Fussballer {
  // Name des Fussballers
  private String name;
  // Anzahl der Tore des Fussballers
  private int tore;
  private int biere;
  private String verein;
  private boolean captain;
  
  public Fussballer(String pName, int pTore, int pBiere, String pVerein) {
    // Die Attribute name und tore werden gesetzt.
    name = pName;
    tore = pTore;
    biere = pBiere;
    verein = pVerein;
    //captain = pCaptain;
  }
  
  // Die Anzahl der Tore wird um die neuen Tore,
  // die im Parameter übergeben werden, erhoeht.
  public void addiereTore(int pTore) {
    tore += pTore;
  }
  
  // Der Name wird zurückgeliefert.
  public String gibName() {
    return name;
  } 
  
  // Die Anzahl der Tore wird zurückgeliefert.
  public int gibTore() {
    return tore;
  }   
  
  public int gibBiere() {
	    return biere;
	  }  
  
  public String gibVerein() {
	  return verein;
  }
  
  public boolean gibCaptain() {
	  return captain;
  }
  
}