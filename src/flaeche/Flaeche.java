package flaeche;

import java.util.ArrayList;
import punkt.Punkt;
import java.util.Arrays;

// Die Fläche eines Körpers.
//
// Eine Fläche ist eine Liste von Punkten.
public class Flaeche {

    // Eine geordnete Reihe von Punkten, die eine Fläche bildet.  Die
    // Ordung der Punkten ist hier sehr wichtig, sodaß wir die Punkten
    // durchlaufen können, um die Fläche aufzubauen.
    ArrayList<Punkt> punktliste;

    // ein: Liste von Punkten
    public Flaeche(ArrayList<Punkt> pl) {
	this.punktliste = pl;
    }

    // Mache ein String dieser Fläche.
    public String drucken() {
	StringBuilder sb = new StringBuilder();	
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
