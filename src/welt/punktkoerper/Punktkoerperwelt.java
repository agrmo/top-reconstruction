package welt.punktkoerper;
    
import java.util.ArrayList;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punktkoerper.Punktkoerper;
import kante.Dreikante;
import welt.Welt;

/*
  Eine Punktkoerperwelt ist eine Liste von Punktkörper.
  
  Die Punktkoerperwelt zeigt uns die Stellen verschiedener Körper.

  Die Punktkoerperwelt ist eine Verbindung zwischen Körpern und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Körpern, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß er den ganzen Körper gut kennen können, unabhängig
  von ihre Farbe oder Beschaffenheit.

  Die Punktkoerperwelt zeigt uns nicht, wie sie aussieht!
*/
public class Punktkoerperwelt extends Welt {

    // Wir sind mit eine Reihe von Körpern gegeben. Ein Körper kennt
    // nur seine Eigenschaften. Die Punktkoerperwelt versteht nicht nur
    // seine Eigenschaften, sondern auch wo er steht.
    public ArrayList<Punktkoerper> punktkoerperliste;

    public Punktkoerperwelt(ArrayList<Punktkoerper> pkl) {
	this.punktkoerperliste = pkl;
    }

    // ein:
    // aus: Liste von Dreikante
    // Nehme alle Dreikanten der Körper dieser Welt.
    public ArrayList<Dreikante> nehmeKanten() {

	ArrayList<Dreikante> wk = new ArrayList<Dreikante>();

	for (int i = 0; i < this.punktkoerperliste.size(); i++) {
	    Punktkoerper k = this.punktkoerperliste.get(i);
	    Dreikante[] kl = k.nehmeKanten();

	    for (int j = 0; j < kl.length; j++) {
		wk.add(kl[j]);
	    }
	}

	return wk;
    }

    // ein:
    // aus: String
    // Drucken die Stellen und Körper dieser Welt.
    public String drucken() {
	StringBuilder sb = new StringBuilder();
	
	for (int i = 0; i < this.punktkoerperliste.size(); i++) {
	    sb.append(this.punktkoerperliste.get(i).drucken());
	}

	return sb.toString();
    }
}
