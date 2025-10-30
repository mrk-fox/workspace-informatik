import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 14.02.2016
  * @author 
  */

public class GUI extends JFrame {
  // Anfang Attribute
  private JTextField eingabePerson = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JTextField eingabeArtikel = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JTextField eingabePreis = new JTextField();
  private JLabel jLabel3 = new JLabel();
  private JTextField eingabeAnzahl = new JTextField();
  private JLabel jLabel4 = new JLabel();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JLabel jLabel5 = new JLabel();
  //private int tischnummmer = 5;
  // Ende Attribute
  
  // Ein Kellnerobjekt namens kellner1 wird deklariert.
  private Kellner kellner1;
  
  public GUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 440; 
    int frameHeight = 317;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    eingabePerson.setBounds(176, 48, 198, 20);
    cp.add(eingabePerson);
    jLabel1.setBounds(32, 48, 110, 20);
    jLabel1.setText("Name der Person:");
    cp.add(jLabel1);
    eingabeArtikel.setBounds(176, 80, 198, 20);
    cp.add(eingabeArtikel);
    jLabel2.setBounds(32, 80, 119, 20);
    jLabel2.setText("Bestellung (Gericht):");
    cp.add(jLabel2);
    eingabePreis.setBounds(176, 144, 75, 20);
    eingabePreis.setText("");
    cp.add(eingabePreis);
    jLabel3.setBounds(32, 144, 122, 20);
    jLabel3.setText("Preis der Bestellung:");
    cp.add(jLabel3);
    eingabeAnzahl.setBounds(176, 112, 75, 20);
    eingabeAnzahl.setText("");
    cp.add(eingabeAnzahl);
    jLabel4.setBounds(32, 112, 118, 20);
    jLabel4.setText("Anzahl der Gerichte:");
    cp.add(jLabel4);
    jButton1.setBounds(176, 184, 195, 25);
    jButton1.setText("Bestellung aufgeben");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(32, 240, 339, 25);
    jButton2.setText("vorderste Bestellung anzeigen und loeschen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jLabel5.setBounds(112, 8, 226, 20);
    jLabel5.setText("Projekt mit Bestellungen im Restaurant");
    cp.add(jLabel5);
    // Ende Komponenten
    
    setVisible(true);
    
    // Das Kellnerobjekt namens kellner1 wird initialisiert.
    kellner1 = new Kellner();
  } // end of public GUI
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // Ein Bestellungsobjekt namens neueBestellung wird anhand der Informationen aus den Eingabefeldern erstellt.
    // Die Zahlen werden in Strings konvertiert
    int anzahl = Integer.parseInt(eingabeAnzahl.getText());
    double preis = Double.parseDouble(eingabePreis.getText());
    Bestellung neueBestellung = new Bestellung(eingabePerson.getText(), eingabeArtikel.getText(), anzahl, preis, 4);
    
    // Die neueBestellung wird vom kellner1 aufgenommen.
    kellner1.bestellungAufnehmen(neueBestellung);
    
    // Die Eingabefelder werden zurueckgesetzt / geleert.
    eingabePerson.setText("");
    eingabeArtikel.setText("");
    eingabeAnzahl.setText("0");
    eingabePreis.setText("0");
  } // end of jButton1_ActionPerformed
  
  public void jButton2_ActionPerformed(ActionEvent evt) {
    // Ein Bestellungsobjekt mit der auszuliefernden Bestellung wird erzeugt.
    Bestellung auszulieferndeBestellung = kellner1.vordersteBestellungAnzeigenUndLoeschen();
    
    // Falls es eine auszulieferndeBestellung gibt, dann wird diese in den Eingabefeldern angezeigt.
    if (auszulieferndeBestellung != null) {
      eingabePerson.setText(auszulieferndeBestellung.gibPerson());
      eingabeArtikel.setText(auszulieferndeBestellung.gibArtikel());
      //Zahlen werden durch Verknüpfung mit "" in Texte umgewande
      eingabeAnzahl.setText(""+auszulieferndeBestellung.gibAnzahl());
      eingabePreis.setText(""+auszulieferndeBestellung.gibPreis());
    }else{
      // sonst: Ein Hinweis wird angezeigt und die restlichen Eingabefelder werden geleert.
      eingabePerson.setText("keine Bestellung mehr vorhanden");
      eingabeArtikel.setText("");
      eingabeAnzahl.setText("0");
      eingabePreis.setText("0");    
    }  
  } // end of jButton2_ActionPerformed
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new GUI("GUI");
  } // end of main
  
} // end of class GUI
