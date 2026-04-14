package welt.graph;

import graph.Nachbarschaftsliste;
import vektor.Dreivektor;
import graph.rechnen.kanteanzahl.Kanteanzahl;
import verdoppler.vektor.Vektorverdoppler;
import strecke.Dreistrecke;

/*
  Eine Dreigraphwelt ist ein Paar von:
  - Graph
  - Liste von Orten
  
  Am Anfang ist ein Graph nicht darstellbar. Er besitzt viele Strecken
  und Knoten, aber mit keinen Orten verbunden.

  Eine Graphwelt verbindet einen Graph mit Orten der Knoten, sodaß wir
  ihn anschauen können. Das tut man ohne Berechnungen, aber ein
  Computer ist kein Mensch.

  Wie stellte man die Orten eines Graphen? Die Knoten überliegen sich
  nicht. Die Strecken sind geradlinige. Die Strecken überliegen so wenig
  andere Strecken wie möglich. Und so weiter. Diese Grundlagen muss man
  rechnerich beitragen.

  Eine Graphwelt ist eine Welt des Graphen.
*/
public class Dreigraphwelt {

    // Der Graph.
    public Nachbarschaftsliste graph;

    // Die Orten jedes Knoten.
    public Dreivektor[] orten;

    public Dreigraphwelt(Nachbarschaftsliste n, Dreivektor[] o) {
	this.graph = n;
	this.orten = o;
    }

    /*
      Das Zentrum von drawCircle() von Java ist nicht genau auf dem
      gegebenen Ort dargestellt. Zum Beispiel
      
      Knoten (0,0,0) Durchmesser 3
      Kante (0,0,0) bis (10,10,10)
      
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
	     
      weil das Zentrum des Kreises nicht auf (0,0,0) steht. Wir sollen
      die Stellen des Knoten verbessern. In diesem Beispiel
      verschieben wir die Stellen des Kreises -3 in die x-,
      y- und z-Richtung.
    */
    void verbessernknoten(Dreivektor zp, int durchmesser) {
	Dreivektor unterschied = new Dreivektor(-(durchmesser / 2.0),
						-(durchmesser / 2.0),
						-(durchmesser / 2.0));
	zp.addiere(unterschied);
    }

    // ein: ganze Zahl
    // Sie gibt neue Vektore aus.
    // Diese Welt kennt wie groß ein Knoten ist.
    public Dreivektor[] nehmeKnoten(int durchmesser) {

	Dreivektor[] ausvektoren = new Dreivektor[this.orten.length];
	
	for (int i = 0; i < this.orten.length; i++) {
	    ausvektoren[i] = Vektorverdoppler.verdoppeln(this.orten[i]);
	    verbessernknoten(ausvektoren[i], durchmesser);
	}
	
	return ausvektoren;
    }

    // Nehme die Kanten dieses Graphen.
    public Dreistrecke[] nehmekanten() {

	// Zuerst berechne wie viele Kanten es gibt.
	int laenge = Kanteanzahl.kanteanzahl(this.graph);

	// Wir kennen wir viele Kanten dieser Graph gibt.
	Dreistrecke[] kanten = new Dreistrecke[laenge];

	// Es gibt laenge-mal Kanten dieses Graphen.
	// Die Summe aller i und j ist gleich laenge.
	// Also laufe über jede Kante durch, und addiere die Kanten.
	int kantenzeichen = 0;

	// Für jeden Knoten,
	for (int i = 0; i < this.graph.betrag; i++) {
	    // Nehme den Streckeanfang.
	    int vonx = (int) this.orten[i].eins;
	    int vony = (int) this.orten[i].zwei;
	    int vonz = (int) this.orten[i].drei;

	    for (int j = 0; j < this.graph.n.get(i).size(); j++) {

		// Nehme das Streckeende.
		int bisknoten = this.graph.n.get(i).get(j);
		    
		int bisx = (int) this.orten[bisknoten].eins;
		int bisy = (int) this.orten[bisknoten].zwei;
		int bisz = (int) this.orten[bisknoten].drei;

		kanten[kantenzeichen] = new Dreistrecke(new Dreivektor(vonx, vony, vonz),
							new Dreivektor(bisx, bisy, bisz));
		kantenzeichen += 1;
	    }
	}

	return kanten;
    }
}
