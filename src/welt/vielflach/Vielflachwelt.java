package welt.vielflach;
    
import java.util.ArrayList;
import vektor.Dreivektor;
import strecke.Dreistrecke;
import vielflach.Vielflach;

/*
  Eine Vielflachwelt ist eine Liste von Körpern.
  
  Die Vielflachwelt zeigt uns die Stellen verschiedener Körper.

  Die Vielflachwelt ist eine Verbindung zwischen Körpern und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Körpern, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß er den ganzen Körper gut kennen können, unabhängig
  von ihre Farbe oder Beschaffenheit.

  Die Vielflachwelt zeigt uns nicht, wie sie aussieht! Die Welt enthält
  die wesentliche Daten. Später stellen wir die Daten dar.
*/
public class Vielflachwelt {

    // Wir sind mit eine Reihe von Körpern gegeben. Ein Körper kennt
    // nur seine Eigenschaften. Die Vielflachwelt versteht nicht nur
    // seine Eigenschaften, sondern auch wo er steht.
    public ArrayList<Vielflach> vielflache;
    public ArrayList<Dreivektor> orte;

    public Vielflachwelt(ArrayList<Vielflach> kl, ArrayList<Dreivektor> ol) {
	this.vielflache = kl;
	this.orte = ol;
    }

    // Nehme die Anzahl aller Strecken dieser Welt.
    int nehmekantenanzahl() {
	int kantenanzahl = 0;

	for (int i = 0; i < this.vielflache.size(); i++) {
	    kantenanzahl += this.vielflache.get(i).nehmekantenanzahl();
	}

	return kantenanzahl;
    }

    // aus: Liste von Dreistrecke
    //
    // Nehme alle Dreistrecken aller Körper dieser Welt in genau einer
    // großen Liste. Die Dreistreckeliste hat nur Tiefe 1. Also wir
    // kennen nachdem nicht, ob eine Strecke in einem Körper oder in
    // einem anderen Körper steht.
    public Dreistrecke[] nehmekanten() {

	int kantenanzahl = this.nehmekantenanzahl();
	
	Dreistrecke[] strecken = new Dreistrecke[kantenanzahl];
	
	// Für alle Körper der Welt
	int streckezeichen = 0;
	for (int i = 0; i < this.vielflache.size(); i++) {

	    // Nehme den Körper. Er kennt seinen Ort nicht.
	    Vielflach k = this.vielflache.get(i);

	    // Er gibt uns seine Strecken, dessen Ursprung aber auf ihm
	    // selbst liegt.
	    Dreistrecke[] kl = k.nehmekanten();

	    Dreivektor ap = this.orte.get(i);

	    // Für alle seine Strecken
	    for (int j = 0; j < kl.length; j++) {
		// addiere seinen Ort zu den Strecken des Körpers.
		kl[j].addiere(ap);

		// Nur dann fügen die Strecke in der Liste zu.
		strecken[streckezeichen] = kl[j];
		streckezeichen += 1;
	    }
	}

	return strecken;
    }
}
