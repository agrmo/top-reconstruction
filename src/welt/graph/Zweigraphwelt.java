package welt.graph;

import graph.Nachbarschaftsliste;
import vektor.Zweivektor;
import rechner.graph.kanteanzahl.Kanteanzahl;
import verdoppler.vektor.Vektorverdoppler;
import strecke.Zweistrecke;

/*
  Eine Zweigraphwelt ist ein Paar von:
  - Graph
  - Liste von Orten
  
  Am Anfang ist ein Graph nicht darstellbar. Er besitzt viele Strecken
  und Knoten, die keinen bestimmten Ort besitzen.

  Eine Graphwelt verbindet einen Graph mit Orten der Knoten, sodaß wir
  ihn vorstellen können. Das tut man ohne Berechnungen, aber ein
  Computer ist kein Mensch.

  Wie stellte man die Orten eines Graphen? Die Knoten überliegen sich
  nicht. Die Strecken sind geradlinige. Die Strecken überliegen so wenig
  andere Strecken wie möglich. Und so weiter. Diese Grundlagen muss man
  rechnerich beitragen.

  Eine Graphwelt ist eine Welt des Graphen.
*/
public class Zweigraphwelt {

    // Der Graph.
    public Nachbarschaftsliste graph;

    // Die Orten jedes Knoten.
    public Zweivektor[] orten;

    public Zweigraphwelt(Nachbarschaftsliste g, Zweivektor[] o) {
	this.graph = g;
	this.orten = o;
    }

    /*
      Das Zentrum von drawCircle() von Java ist nicht genau auf dem
      gegebenen Ort dargestellt. Zum Beispiel
      
      Knoten (0,0) Durchmesser 3
      Kante (0,0) bis (10,10)
      
      Gewünscht:
      
      |---|
      | \ |
      |--\|
          \
           \
            ...

      Aber Java wird die beiden wieso darstellen,

      \
      |---|
      |\  |
      |-\-|
         \
          \
           ...
	     
      weil das Zentrum des Kreises nicht auf (0,0) steht. Wir sollen
      die Stellen des Knoten verbessern. In diesem Beispiel
      verschieben wir die Stellen des Kreises -3 in die x- und
      y-Richtung.
    */
    void verbessernknoten(Zweivektor zp, int durchmesser) {
	Zweivektor unterschied = new Zweivektor(-(durchmesser / 2.0),
						-(durchmesser / 2.0));
	zp.addiere(unterschied);
    }

    // ein: ganze Zahl
    // Sie gibt neue Vektore aus.
    // Diese Welt kennt wie groß ein Knoten ist.
    public Zweivektor[] nehmeKnoten(int durchmesser) {

	Zweivektor[] ausvektoren = new Zweivektor[this.orten.length];
	
	for (int i = 0; i < this.orten.length; i++) {
	    ausvektoren[i] = Vektorverdoppler.verdoppeln(this.orten[i]);
	    verbessernknoten(ausvektoren[i], durchmesser);
	}
	
	return ausvektoren;
    }

    // Rechne alle Kanten dieses Graphen aus.
    public Zweistrecke[] nehmekanten() {

	// Zuerst berechne wie viele Kanten es gibt.
	int ka = Kanteanzahl.kanteanzahl(this.graph);

	// Wir kennen wir viele Kanten dieser Graph gibt.
	Zweistrecke[] kanten = new Zweistrecke[ka];

	// Es gibt ka-mal Kanten dieses Graphen.
	// Die Summe aller i und j ist gleich ka.
	// Also laufe über jede Kante durch, und addiere die Kante.

	int kantenzeichen = 0;
	for (int i = 0; i < this.graph.betrag; i++) {
	    // Wo dieser Knoten ist.
	    int vonx = (int) this.orten[i].eins;
	    int vony = (int) this.orten[i].zwei;

	    for (int j = 0; j < this.graph.n.get(i).size(); j++) {

		// Wer der Knoten ist, dem dieser Knoten verbunden ist.
		int bisknoten = this.graph.n.get(i).get(j);
		    
		int bisx = (int) this.orten[bisknoten].eins;
		int bisy = (int) this.orten[bisknoten].zwei;

		kanten[kantenzeichen] = new Zweistrecke(new Zweivektor(vonx, vony),
							new Zweivektor(bisx, bisy));
		kantenzeichen += 1;
	    }
	}

	return kanten;
    }
}
