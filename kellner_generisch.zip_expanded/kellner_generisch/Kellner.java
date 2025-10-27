public class Kellner{
  // Die bestellschlange wird deklariert.
  // Als ContentType werden Objekte der Klasse Bestellung festgelegt.
  Queue<Bestellung> bestellschlange;
  Queue<Bestellung> summenschlange;
  Queue<Bestellung> hilfsschlange;
  Queue<Bestellung> nervschlange;
  public double sum = 0;
  
  public Kellner(){
    // Die bestellschlange wird initialisiert.
    // Die Spitzenklammern (mit Contentype Bestellung) muessen 
    // bei der Initialisierung der Queue wiederholt werden.
    bestellschlange = new Queue<Bestellung>();
  }
  
  public void bestellungAufnehmen(Bestellung pBestellung){
    // Eine als Parameter uebergebene Bestellung wird an die Schlange angeh�ngt.
    bestellschlange.enqueue(pBestellung);
    rechneSumme(pBestellung);
    System.out.println(rechneTischSumme(5));
    System.out.println(rechneTischSumme(5));
    nervigerGast("asd");
  }
  
  public Bestellung vordersteBestellungAnzeigenUndLoeschen(){
    // Eine Referenz auf die vorderste Bestellung in der bestellschlange wird erstellt.
    // Die Methode front() der Klasse Queue liefert den oben angegebenen Contenttype zur�ck.
    // Ein Typecast ist nicht notwendig.
    Bestellung vordersteBestellung = bestellschlange.front();
    
    // Das vorderste Element wird aus der Schlange entfernt.
    bestellschlange.dequeue(); 
    
    // Die vordersteBestellung wird zur�ckgegeben.
    return vordersteBestellung;
  }
  
  public void rechneSumme(Bestellung pBestellung) {
//	  double preis = pBestellung.gibPreis();
//	  int mul = pBestellung.gibAnzahl();
//	  double tmp = preis * mul;
//	  sum += tmp;
//	  System.out.println(sum);
  }
  
  public Queue<Bestellung> uebernehmeSchlange() {
	  hilfsschlange = new Queue<Bestellung>();
	  return hilfsschlange;
  }

  public double rechneTischSumme(int pTischnummer) {
	  double kosten = 0;
	  
	  Queue<Bestellung> hilfsschlange = uebernehmeSchlange();
	  
	  while(!hilfsschlange.isEmpty()) {
		  if(hilfsschlange.front().gibTischnummer() == pTischnummer) {	//Tischnummer
			  Bestellung tmpBestellung = hilfsschlange.front();
			  kosten += tmpBestellung.gibPreis() * tmpBestellung.gibAnzahl();
			  hilfsschlange.dequeue();
			  
		  }
		  else {
			  System.out.println("Keine Bestellungen für diesen Tisch gespeichert.");
			  break;
		  }
		
	  }
	  return kosten;
	  
  }
  
  public boolean existiertName(String pName) {
	  
	  Queue<Bestellung> hilfsschlange = new Queue<Bestellung>();
	  hilfsschlange = bestellschlange;
	  
	  while(!hilfsschlange.isEmpty()) {
		  if (hilfsschlange.front().gibPerson() == pName) {
			  return true;
			  
		  }
		  hilfsschlange.dequeue();
		  
		  }

	  return false;
	  }
  
  public double maxWert() {
	  double lmaxPreis = 0;
	  Queue<Bestellung> hilfsschlange = new Queue <Bestellung>();
	  hilfsschlange = bestellschlange;
	  while(!hilfsschlange.isEmpty()) {
		  if(hilfsschlange.front().gibPreis() > lmaxPreis) {
			  lmaxPreis = hilfsschlange.front().gibPreis();
		  }
		  hilfsschlange.dequeue();
	  }
	  return lmaxPreis;
  }
  
  
  public Queue<Bestellung> nervigerGast(String pName) {

	  Queue<Bestellung> hilfsschlange = new Queue<Bestellung>();
	  hilfsschlange = bestellschlange;
	  Queue<Bestellung> nervschlange= new Queue<Bestellung>();
	  while(!hilfsschlange.isEmpty()) {
		  if(hilfsschlange.front().gibPerson() == pName) {
			  nervschlange.enqueue(hilfsschlange.front());
			  hilfsschlange.dequeue();
		  }
		  else {
			  hilfsschlange.dequeue();
		  }
		  hilfsschlange = bestellschlange;
	  }
		  while (!hilfsschlange.isEmpty()) {
			  if(hilfsschlange.front().gibPerson() != pName) {
				  nervschlange.enqueue(hilfsschlange.front());
				  hilfsschlange.dequeue();
			  }
			  else {
				  hilfsschlange.dequeue();  
			  }
		  }
	  System.out.println("Yessss");
	  
	  return nervschlange;
	  
  }
  
  
  
}