package welt.vieleck;
    
import java.util.ArrayList;
import vieleck.Vieleck;
import strecke.Zweistrecke;
import vektor.Zweivektor;

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
    public ArrayList<Zweivektor> ortliste;

    public Vieleckwelt(ArrayList<Vieleck> fl, ArrayList<Zweivektor> ol) {
	this.vieleckliste = fl;
	this.ortliste = ol;
    }

    // Nehme die Anzahl aller Strecken dieser Welt.
    int nehmekantenanzahl() {
	int kantenanzahl = 0;
	
	// Nehme die gesamte Anzahl der Strecken der Vielecken.
	for (int i = 0; i < this.vieleckliste.size(); i++) {
	    kantenanzahl += this.vieleckliste.get(i).nehmekantenanzahl();
	}

	return kantenanzahl;
    }

    // aus: Liste von Zweistrecke
    //
    // Nehme alle Zweistrecken aller Vieleck dieser Welt in genau einer
    // großen Liste. Die Zweistreckeliste hat nur Tiefe 1. Also wir
    // kennen nachdem nicht, ob eine Strecke in einem Vieleck oder in
    // einem anderen Vieleck steht.
    public Zweistrecke[] nehmekanten() {

	// Wir kennen nun, wie viele Kanten es in der Welt insgesamt gibt.
	// Wir kennen nicht, wie viele Kanten es in jeweiligem Körper gibt.
	// Also mache einen Index für die Strecken.
	int kantenanzahl = this.nehmekantenanzahl();

	Zweistrecke[] strecken = new Zweistrecke[kantenanzahl];
	
	// Für alle Vieleck der Welt, nehme den Vieleck, dann nehme
	// seine Kanten, dann verschiebe alle Kanten zum richtigen
	// Ort.
	int streckenzeichen = 0;
	for (int i = 0; i < this.vieleckliste.size(); i++) {

	    Vieleck k = this.vieleckliste.get(i);
	    Zweistrecke[] kl = k.nehmekanten();
	    Zweivektor vieleckvektor = this.ortliste.get(i);

	    for (int j = 0; j < kl.length; j++) {
		kl[j].addiere(vieleckvektor);
		strecken[streckenzeichen] = kl[j];
		streckenzeichen += 1;
	    }
	}

	return strecken;
    }
}
