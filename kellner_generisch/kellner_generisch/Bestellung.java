public class Bestellung{
  // Die Attribute werden deklariert.
  private String person;
  private String artikel;
  private int anzahl;
  private double preis;
  private int tischnummer;
  
  public Bestellung(String pPerson, String pArtikel, int pAnzahl, double pPreis, int pTisch){ 
    // Die Attribute werden mit den im Parameter uebergebenen Informationen initialisiert.
    person = pPerson;
    artikel = pArtikel;
    anzahl = pAnzahl;
    preis = pPreis;
    tischnummer = pTisch;
  }
  
  // Es folgen die Getter-Methoden fuer die einzelnen Attribute.
  public String gibPerson(){
    return person;
  }
  
  public String gibArtikel(){
    return artikel;  
  }
  
  public int gibAnzahl(){
    return anzahl;
  }
  
  public double gibPreis(){
    return preis; 
  }
  
  public int gibTischnummer() {
	  return tischnummer;
  }
  
}