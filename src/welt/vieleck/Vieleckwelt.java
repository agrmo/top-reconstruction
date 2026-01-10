package welt.vieleck;
    
import java.util.ArrayList;
import vieleck.Vieleck;
import strecke.Zweistrecke;
import punkt.Zweipunkt;

/*
  Eine Vieleckwelt ist eine Liste von Vieleckn.
  
  Die Vieleckwelt zeigt uns die Stellen verschiedener Vieleck.

  Die Vieleckwelt ist eine Verbindung zwischen Vieleckn und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Vielecken, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß man die ganze Vieleck gut kennen können.

  Die Vieleckwelt zeigt uns nicht, wie sie aussieht. Die Welt enthält
  die wesentliche Daten. Später stellen wir die Daten dar.
*/
public class Vieleckwelt {

    // Wir sind mit eine Reihe von Vielecken gegeben. Ein Vieleck
    // kennt nur seine Eigenschaften. Die Welt versteht nicht nur seine
    // Eigenschaften, sondern auch wo sie in der Welt steht.
    public ArrayList<Vieleck> vieleckliste;
    public ArrayList<Zweipunkt> ortliste;

    public Vieleckwelt(ArrayList<Vieleck> fl, ArrayList<Zweipunkt> ol) {
	this.vieleckliste = fl;
	this.ortliste = ol;
    }

    // aus: Liste von Zweistrecke
    //
    // Nehme alle Zweistrecken aller Vieleck dieser Welt in genau einer
    // großen Liste. Die Zweistreckeliste hat nur Tiefe 1. Also wir
    // kennen nachdem nicht, ob eine Strecke in einem Vieleck oder in
    // einem anderen Vieleck steht.
    public Zweistrecke[] nehmekanten() {

	int streckeanzahl = 0;

	// Nehme die gesamte Anzahl der Strecken der Vielecken.
	for (int i = 0; i < this.vieleckliste.size(); i++) {
	    streckeanzahl += this.vieleckliste.get(i).nehmekantenanzahl();
	}

	Zweistrecke[] strecken = new Zweistrecke[streckeanzahl];
	
	// Für alle Vieleck der Welt
	int streckenzeichen = 0;
	for (int i = 0; i < this.vieleckliste.size(); i++) {

	    // Nehme den Vieleck. Er kennt seinen Ort nicht.
	    Vieleck k = this.vieleckliste.get(i);

	    // Er gibt uns seine Strecken, dessen Ursprung aber auf ihm
	    // selbst liegt.
	    Zweistrecke[] kl = k.nehmekanten();

	    Zweipunkt vieleckpunkt = this.ortliste.get(i);

	    // Für alle seine Strecken
	    for (int j = 0; j < kl.length; j++) {
		// addiere ihren Ort zu ihren Strecken.
		kl[j].addieren(vieleckpunkt);

		// Nur dann fügen die Strecke in der Liste zu.
		strecken[streckenzeichen] = kl[j];
		streckenzeichen += 1;
	    }
	}

	return strecken;
    }
}
