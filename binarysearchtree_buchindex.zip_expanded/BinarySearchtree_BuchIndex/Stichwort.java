/**
 * Stichwort mit Seitenzahlen
 * @version 30.07.2018
 * @author Klaus Dingemann
 */
public class Stichwort implements ComparableContent<Stichwort> {   
  private List<Integer> seiten;
  private String wort;

  public Stichwort(String pWort, int pSeite) {
    wort = pWort;
    seiten = new List<Integer>();
    seiten.append(new Integer(pSeite));
  }

  public void fuegeSeitenzahlEin(int pSeite) {
    if (!istEnthalten(pSeite)) {
      Integer seite = new Integer(pSeite);
      seiten.toFirst();
      while (seiten.hasAccess() 
      && pSeite>seiten.getContent().intValue() )
        seiten.next();
      if (seiten.hasAccess())
        seiten.insert(seite);
      else
        seiten.append(seite);

    }
  }

  public String gibWort() {
    return wort;
  }

  public boolean isEqual(Stichwort pContent) {
    if (this.gibWort().equals( pContent.gibWort()) )
      return true;
    else return false;
  }

  public boolean isGreater(Stichwort pContent) {
    if (this.gibWort().compareTo( pContent.gibWort())>0 )
      return true;
    else 
      return false;
  }

  public boolean isLess(Stichwort pContent) {
    if (this.gibWort().compareTo(pContent.gibWort())<0 )
      return true;
    else 
      return false;
  }

  public String toString() {
    String ausgabe = wort + " ";
    seiten.toFirst();
    while (seiten.hasAccess()) {
      ausgabe = ausgabe+" "+(seiten.getContent()).intValue();
      seiten.next();
    }
    return ausgabe;  
  }

  private boolean istEnthalten(int pSeitenzahl) {
    boolean enthalten=false;
    seiten.toFirst();
    while (seiten.hasAccess() 
    && !enthalten ) {
      enthalten = (seiten.getContent()).intValue() == pSeitenzahl;
      seiten.next();  
    }            
    return enthalten;
  }

}
