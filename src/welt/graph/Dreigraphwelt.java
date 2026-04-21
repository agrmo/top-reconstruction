package welt.graph;

import graph.Nachbarschaftsliste;
import vektor.Dreivektor;
import rechner.graph.kanteanzahl.Kanteanzahl;
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

  Eine Graphwelt ist eine Welt des Graphen. Es könne verschiedene
  Welte eines Graphen geben.

  Wie stellt man die Orten eines Graphen dar? Die Knoten überliegen sich
  nicht. Die Strecken sind geradlinige. Die Strecken überliegen so wenig
  andere Strecken wie möglich. Und so weiter. Diese Grundlagen muss man
  rechnerich beitragen.
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

    // ein: ganze Zahl
    // Sie gibt neue Vektore aus.
    public Dreivektor[] nehmeknoten() {

	Dreivektor[] ausvektoren = new Dreivektor[this.orten.length];
	
	for (int i = 0; i < this.orten.length; i++) {
	    ausvektoren[i] = Vektorverdoppler.verdoppeln(this.orten[i]);
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
