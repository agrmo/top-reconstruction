package flaeche;

import java.util.ArrayList;
import punkt.Dreipunkt;

// Eine Fläche ist eine Liste von Dreipunkten.
//
// Die Fläche zeigt eine Fläche eines Körpers.
//
// Es ist besser, nur "Fläche" statt "Dreifläche" zu nennen. Eine
// Vieleck ist schon eine "zweidimensionale Fläche."
public class Flaeche {

    // Eine geordnete Reihe von Dreipunkten, die eine Fläche bildet.
    // Die Ordung der Dreipunkten ist hier sehr wichtig, sodaß wir die
    // Dreipunkten durchlaufen können, um die Fläche aufzubauen.
    ArrayList<Dreipunkt> punktliste;

    // ein: Liste von Dreipunkten
    public Flaeche(ArrayList<Dreipunkt> pl) {
	this.punktliste = pl;
    }

    // Mache ein String dieser Fläche.
    public String drucken() {
	StringBuilder sb = new StringBuilder();	
	sb.append("Fläche: ");
	sb.append("[");
	
	for (int i = 0; i < this.punktliste.size(); i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(this.punktliste.get(i).drucken());
	}
	
	sb.append("]");

	return sb.toString();
    }    
}
