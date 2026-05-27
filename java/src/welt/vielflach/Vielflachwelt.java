package welt.vielflach;
    
import vektor.Dreivektor;
import strecke.Dreistrecke;
import vielflach.Vielflach;
import stellung.vielflach.Vielflachstellung;
import stellung.Dreistellung;

/*
  Eine Vielflachwelt ist ein Triplett von
  - Liste von Körpern
  - Liste von Stellungen
  
  Die Vielflachwelt zeigt uns die Stellen verschiedener Körper.

  Die Vielflachwelt ist eine Verbindung zwischen Körpern und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Körpern, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß er den ganzen Körper gut kennen können.

  Die Vielflachwelt zeigt uns nicht, wie sie aussieht. Die Welt enthält
  die wesentliche Daten. Später stellen wir die Daten dar.
*/
public class Vielflachwelt {

    // Wir sind mit eine Reihe von Körpern gegeben. Ein Körper kennt
    // nur seine Eigenschaften. Die Vielflachwelt versteht nicht nur
    // seine Eigenschaften, sondern auch wo er steht.
    public Vielflach[] vielflache;
    public Dreistellung[] stellungen;

    public Vielflachwelt(Vielflach[] kl, Dreistellung[] sl) {
	this.vielflache = kl;
	this.stellungen = sl;
    }

    // Nehme die Anzahl aller Strecken dieser Welt.
    int nehmekantenanzahl() {
	int kantenanzahl = 0;

	for (int i = 0; i < this.vielflache.length; i++) {
	    kantenanzahl += this.vielflache[i].nehmekantenanzahl();
	}

	return kantenanzahl;
    }

    // aus: Liste von Dreistrecke
    //
    // Nehme alle Dreistrecken aller Körper dieser Welt in genau einer
    // großen Liste. Also wir kennen von dieser Liste nicht, ob eine
    // Strecke in einem Körper oder in einem anderen Körper
    // ursprünglich stand.
    public Dreistrecke[] nehmekanten() {

	int kantenanzahl = this.nehmekantenanzahl();
	
	// Die Kanten sind einfach Strecken.
	Dreistrecke[] strecken = new Dreistrecke[kantenanzahl];
	
	// Wir kennen nun, wie viele Kanten es in der Welt insgesamt gibt.
	// Wir kennen nicht, wie viele Kanten es in jeweiligem Körper gibt.
	// Also mache einen Index für die Strecken.
	int streckezeichen = 0;
	
	// Für alle Vielflache der Welt, nehme den Körper, dann nehme
	// seine Kanten, drehen die Kanten, dann stellen seine Kanten
	// zum richtigen Ort.

	for (int i = 0; i < this.vielflache.length; i++) {
	    Dreistrecke[] vstrecken = Vielflachstellung.stelle(this.vielflache[i],
							       this.stellungen[i]);
	
	    for (int j = 0; j < vstrecken.length; j++) {
		strecken[streckezeichen] = vstrecken[j];
		streckezeichen += 1;
	    }	    
	}

	return strecken;
    }
}
