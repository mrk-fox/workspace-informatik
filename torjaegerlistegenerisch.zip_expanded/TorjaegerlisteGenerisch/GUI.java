import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 15.02.2016
  * @author 
  */

public class GUI extends JFrame {
  // Anfang Attribute
  
  // Das Objekt meineVerwaltung wird von der Klasse Torjaegerverwaltung deklariert und initialisiert.
  private Torjaegerverwaltung meineVerwaltung = new Torjaegerverwaltung();
  
  
  private JButton bEinfuegen = new JButton();
  private JTextField tfName = new JTextField();
  private JTextArea taAusgabe = new JTextArea("");
  private JScrollPane taAusgabeScrollPane = new JScrollPane(taAusgabe);
  private JButton bLoeschen = new JButton();
  private JLabel lTorjaegerverwaltung = new JLabel();
  private JLabel lbName = new JLabel();
  private JLabel lbTore = new JLabel();
  private JTextField tfTore = new JTextField();
  // Ende Attribute
  
  public GUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 421; 
    int frameHeight = 367;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    bEinfuegen.setBounds(272, 40, 99, 25);
    bEinfuegen.setText("einfuegen");
    bEinfuegen.setMargin(new Insets(2, 2, 2, 2));
    bEinfuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEinfuegen_ActionPerformed(evt);
      }
    });
    cp.add(bEinfuegen);
    tfName.setBounds(80, 40, 150, 20);
    cp.add(tfName);
    taAusgabeScrollPane.setBounds(32, 120, 344, 196);
    cp.add(taAusgabeScrollPane);
    bLoeschen.setBounds(272, 72, 99, 25);
    bLoeschen.setText("loeschen");
    bLoeschen.setMargin(new Insets(2, 2, 2, 2));
    bLoeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLoeschen_ActionPerformed(evt);
      }
    });
    cp.add(bLoeschen);
    lTorjaegerverwaltung.setBounds(144, 8, 122, 20);
    lTorjaegerverwaltung.setText("Torjaegerverwaltung");
    cp.add(lTorjaegerverwaltung);
    lbName.setBounds(32, 40, 46, 20);
    lbName.setText("Name:");
    cp.add(lbName);
    lbTore.setBounds(32, 72, 62, 20);
    lbTore.setText("Tore:");
    cp.add(lbTore);
    tfTore.setBounds(80, 72, 54, 20);
    cp.add(tfTore);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GUI("GUI");
  } // end of main
  
  public void bEinfuegen_ActionPerformed(ActionEvent evt) {
    // Ein Fussball wird anhang der Parameter (Name, Tore) in die Torj�gerliste eingef�gt.
    int tore = Integer.parseInt(tfTore.getText());
    meineVerwaltung.hinzufuegen(tfName.getText(), tore, 3, "BVB");
    
    // Die Anzeige wird aktualisiert.
    taAusgabe.setText(meineVerwaltung.gibAusgabe());
  } // end of bEinfuegen_ActionPerformed
  
  public void bLoeschen_ActionPerformed(ActionEvent evt) {
    // Der Fussballer mit dem als Parameter �bergebenen Namen wird gel�scht.
    meineVerwaltung.loesche(tfName.getText());
    
    // Die Anzeige wird aktualisiert.
    taAusgabe.setText(meineVerwaltung.gibAusgabe());
  } // end of bLoeschen_ActionPerformed
  
  // Ende Methoden
} // end of class GUI
