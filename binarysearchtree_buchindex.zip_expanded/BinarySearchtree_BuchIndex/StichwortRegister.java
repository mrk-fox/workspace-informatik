/**
 * Klasse zur Erstellung eines Stichwortregisters
 *
 * @version 30.07.2018
 * @authot Klaus Dingemann
 */
public class StichwortRegister {
  private BinarySearchTree<Stichwort> suchbaum;

  public StichwortRegister() {
    suchbaum = new BinarySearchTree<Stichwort>();
  }

  public void erzeugeTestdaten() {
    fuegeEin("FIFO",10);
    fuegeEin("Liste",14);
    fuegeEin("Schlange",17);
    fuegeEin("Schlange",19);
    fuegeEin("Liste",20);
    fuegeEin("LIFO",20);
    fuegeEin("Baum",34);
    fuegeEin("Automat",5);
    fuegeEin("Automat",63);
    fuegeEin("Liste",65);
    fuegeEin("Baum",78);
    fuegeEin("Baum",83);
    fuegeEin("Liste",89);
    fuegeEin("Liste",95);
  }

  public void fuegeEin(String pWort, int pSeite)     {
    Stichwort myItem = new Stichwort(pWort,pSeite);
    // lokale Variable 
    if (suchbaum.search(myItem) != null)
      ((Stichwort) suchbaum.search(myItem)).fuegeSeitenzahlEin(pSeite);
    else 
      suchbaum.insert(myItem);      
  }

  public List<Stichwort> listeAusBaum(BinarySearchTree<Stichwort> baum) {
    if (baum.isEmpty()) {
      return new List<Stichwort>();
    } else {
      List<Stichwort> links = listeAusBaum(baum.getLeftTree());
      links.append(baum.getContent());
      List<Stichwort> rechts = listeAusBaum(baum.getRightTree());
      links.concat(rechts);
      return links ;
    }
  }

  public String stichwortListe() {
    List<Stichwort> liste = listeAusBaum(suchbaum);
    String ausgabe="";
    liste.toFirst();
    while (liste.hasAccess()) {
      ausgabe = ausgabe+( liste.getContent()).toString()+"\n";
      liste.next();
    }
    return ausgabe;
  }

}
