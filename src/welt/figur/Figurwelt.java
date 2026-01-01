package welt.figur;
    
import java.util.ArrayList;
import figur.Figur;
import kante.Zweikante;
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

    // aus: Liste von Zweikante
    //
    // Nehme alle Zweikanten aller Figur dieser Welt in genau einer
    // großen Liste. Die Zweikanteliste hat nur Tiefe 1. Also wir
    // kennen nachdem nicht, ob eine Kante in einem Figur oder in
    // einem anderen Figur steht.
    public ArrayList<Zweikante> nehmeKanten() {

	ArrayList<Zweikante> kanten = new ArrayList<Zweikante>();
	
	// Für alle Figur der Welt
	for (int i = 0; i < this.figurliste.size(); i++) {

	    // Nehme den Figur. Er kennt seinen Ort nicht.
	    Figur k = this.figurliste.get(i);

	    // Er gibt uns seine Kanten, dessen Ursprung aber auf ihm
	    // selbst liegt.
	    Zweikante[] kl = k.nehmeKanten();

	    Zweipunkt figurpunkt = this.ortliste.get(i);

	    // Für alle seine Kanten
	    for (int j = 0; j < kl.length; j++) {
		// addiere ihren Ort zu ihren Kanten.
		kl[j].addieren(figurpunkt);

		// Nur dann fügen die Kante in der Liste zu.
		kanten.add(kl[j]);
	    }
	}

	return kanten;
    }
}
