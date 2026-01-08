package welt.koerper;
    
import java.util.ArrayList;
import koerper.Koerper;
import koerper.kubus.Kubus;
import koerper.Koerper;
import strecke.Dreistrecke;
import punkt.Dreipunkt;

/*
  Eine Koerperwelt ist eine Liste von Körpern.
  
  Die Koerperwelt zeigt uns die Stellen verschiedener Körper.

  Die Koerperwelt ist eine Verbindung zwischen Körpern und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Körpern, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß er den ganzen Körper gut kennen können, unabhängig
  von ihre Farbe oder Beschaffenheit.

  Die Koerperwelt zeigt uns nicht, wie sie aussieht! Die Welt enthält
  die wesentliche Daten. Später stellen wir die Daten dar.
*/
public class Koerperwelt {

    // Wir sind mit eine Reihe von Körpern gegeben. Ein Körper kennt
    // nur seine Eigenschaften. Die Koerperwelt versteht nicht nur
    // seine Eigenschaften, sondern auch wo er steht.
    public ArrayList<Koerper> koerperliste;
    public ArrayList<Dreipunkt> ortliste;

    public Koerperwelt(ArrayList<Koerper> kl, ArrayList<Dreipunkt> ol) {
	this.koerperliste = kl;
	this.ortliste = ol;
    }

    // Nehme die Anzahl aller Strecken dieser Welt.
    int nehmestreckenanzahl() {
	int streckenanzahl = 0;
	
	for (int i = 0; i < this.koerperliste.size(); i++) {
	    i += this.koerperliste.get(i).nehmestreckenanzahl();
	}

	return streckenanzahl;
    }

    // aus: Liste von Dreistrecke
    //
    // Nehme alle Dreistrecken aller Körper dieser Welt in genau einer
    // großen Liste. Die Dreistreckeliste hat nur Tiefe 1. Also wir
    // kennen nachdem nicht, ob eine Strecke in einem Körper oder in
    // einem anderen Körper steht.
    public Dreistrecke[] nehmeStrecken() {

	int streckenanzahl = this.nehmestreckenanzahl();
	
	Dreistrecke[] strecken = new Dreistrecke[streckenanzahl];
	
	// Für alle Körper der Welt
	int streckezeichen = 0;
	for (int i = 0; i < this.koerperliste.size(); i++) {

	    // Nehme den Körper. Er kennt seinen Ort nicht.
	    Koerper k = this.koerperliste.get(i);

	    // Er gibt uns seine Strecken, dessen Ursprung aber auf ihm
	    // selbst liegt.
	    Dreistrecke[] kl = k.nehmeStrecken();

	    Dreipunkt ap = this.ortliste.get(i);

	    // Für alle seine Strecken
	    for (int j = 0; j < kl.length; j++) {
		// addiere seinen Ort zu den Strecken des Körpers.
		kl[j].addieren(ap);

		// Nur dann fügen die Strecke in der Liste zu.
		strecken[streckezeichen] = kl[j];
		streckezeichen += 1;
	    }
	}

	return strecken;
    }
}
