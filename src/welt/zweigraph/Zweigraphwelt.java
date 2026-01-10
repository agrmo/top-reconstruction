package welt.zweigraph;

import graph.Nachbarschaftsliste;
import punkt.Zweipunkt;
import graph.rechnen.kanteanzahl.Kanteanzahl;
import verdoppler.punkt.Punktverdoppler;
import strecke.Zweistrecke;

/*
  Eine Graphwelt ist ein Paar von:
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

    // Die Stellen jedes Knoten.
    public Zweipunkt[] orten;

    // Die Kanten jedes Knoten.
    public Nachbarschaftsliste graph;

    public Zweigraphwelt(Nachbarschaftsliste n, Zweipunkt[] o) {
	this.orten = o;
	this.graph = n;
    }

    /*
      Das Zentrum von drawCircle() jedes Knoten dieses Graphen sind
      nicht genau auf dem punkt dargestellt. Zum Beispiel
      
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
	     
      weil das Zentrum des Kreises nicht auf (0,0) steht. Wir müssen
      die Stellen des Knoten verbessern. In diesem Beispiel
      verschieben wir die Stellen des Kreises -3 in die x- und
      y-Richtung.
    */
    void verbessernKnoten(Zweipunkt zp, int durchmesser) {
	Zweipunkt unterschied = new Zweipunkt(-(durchmesser / 2.0),
					      -(durchmesser / 2.0));
	zp.addieren(unterschied);
    }

    // ein: ganze Zahl
    // Sie gibt neue Punkte aus.
    // Diese Welt kennt wie groß ein Knoten ist.
    public Zweipunkt[] nehmeKnoten(int durchmesser) {

	Zweipunkt[] auspunkte = new Zweipunkt[this.orten.length];
	
	for (int i = 0; i < this.orten.length; i++) {
	    auspunkte[i] = Punktverdoppler.verdoppeln(this.orten[i]);
	    verbessernKnoten(auspunkte[i], durchmesser);
	}
	
	return auspunkte;
    }

    // Rechne alle Kanten dieses Graphen aus.
    public Zweistrecke[] nehmekanten() {

	// Zuerst berechne wie viele Kanten es gibt.
	int ka = Kanteanzahl.berechnen(this.graph);

	// Wir kennen wir viele Kanten dieser Graph gibt.
	Zweistrecke[] kanten = new Zweistrecke[ka];

	// Es gibt ka-mal Kanten dieses Graphen.
	// Die Summe aller i und j ist gleich ka.
	// Also laufe über jede Kante durch, und addiere die Kante.

	int kantenzeichen = 0;
	for (int i = 0; i < this.graph.betrag; i++) {
	    // Wo dieser Knoten ist.
	    int vonx = (int) this.orten[i].xteil;
	    int vony = (int) this.orten[i].yteil;

	    for (int j = 0; j < this.graph.n.get(i).size(); j++) {

		// Wer der Knoten ist, dem dieser Knoten verbunden ist.
		int bisknoten = this.graph.n.get(i).get(j);
		    
		int bisx = (int) this.orten[bisknoten].xteil;
		int bisy = (int) this.orten[bisknoten].yteil;

		kanten[kantenzeichen] = new Zweistrecke(new Zweipunkt(vonx, vony),
							new Zweipunkt(bisx, bisy));
		kantenzeichen += 1;
	    }
	}

	return kanten;
    }
}
