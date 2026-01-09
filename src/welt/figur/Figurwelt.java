package welt.figur;
    
import java.util.ArrayList;
import figur.Figur;
import strecke.Zweistrecke;
import punkt.Zweipunkt;

/*
  Eine Figurwelt ist eine Liste von Figurn.
  
  Die Figurwelt zeigt uns die Stellen verschiedener Figur.

  Die Figurwelt ist eine Verbindung zwischen Figurn und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Figuren, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß man die ganze Figur gut kennen können.

  Die Figurwelt zeigt uns nicht, wie sie aussieht. Die Welt enthält
  die wesentliche Daten. Später stellen wir die Daten dar.
*/
public class Figurwelt {

    // Wir sind mit eine Reihe von Figurn gegeben. Ein Figur kennt nur
    // seine Eigenschaften. Die Figurwelt versteht nicht nur seine
    // Eigenschaften, sondern auch wo sie in der Welt steht.
    public ArrayList<Figur> figurliste;
    public ArrayList<Zweipunkt> ortliste;

    public Figurwelt(ArrayList<Figur> fl, ArrayList<Zweipunkt> ol) {
	this.figurliste = fl;
	this.ortliste = ol;
    }

    // aus: Liste von Zweistrecke
    //
    // Nehme alle Zweistrecken aller Figur dieser Welt in genau einer
    // großen Liste. Die Zweistreckeliste hat nur Tiefe 1. Also wir
    // kennen nachdem nicht, ob eine Strecke in einem Figur oder in
    // einem anderen Figur steht.
    public Zweistrecke[] nehmeStrecken() {

	int streckeanzahl = 0;

	// Nehme die gesamte Anzahl der Strecken der Figuren.
	for (int i = 0; i < this.figurliste.size(); i++) {
	    streckeanzahl += this.figurliste.get(i).nehmestreckenanzahl();
	}

	Zweistrecke[] strecken = new Zweistrecke[streckeanzahl];
	
	// Für alle Figur der Welt
	int streckenzeichen = 0;
	for (int i = 0; i < this.figurliste.size(); i++) {

	    // Nehme den Figur. Er kennt seinen Ort nicht.
	    Figur k = this.figurliste.get(i);

	    // Er gibt uns seine Strecken, dessen Ursprung aber auf ihm
	    // selbst liegt.
	    Zweistrecke[] kl = k.nehmeStrecken();

	    Zweipunkt figurpunkt = this.ortliste.get(i);

	    // Für alle seine Strecken
	    for (int j = 0; j < kl.length; j++) {
		// addiere ihren Ort zu ihren Strecken.
		kl[j].addieren(figurpunkt);

		// Nur dann fügen die Strecke in der Liste zu.
		strecken[streckenzeichen] = kl[j];
		streckenzeichen += 1;
	    }
	}

	return strecken;
    }
}
