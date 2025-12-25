package flaeche;

import java.util.ArrayList;
import punkt.Punkt;
import java.util.Arrays;

// Die Fläche eines Körpers.
//
// Eine Fläche ist eine Liste von Punkten.
public class Flaeche {

    // Eine geordnete Reihe von Punkten, die eine Fläche bildet.
    ArrayList<Punkt> punktliste;

    public Flaeche(ArrayList<Punkt> pl) {
	this.punktliste = pl;
    }

    // Mache ein String dieser Fläche.
    public String drucken() {
	StringBuilder sb = new StringBuilder();	
	sb.append("[");
	
	for (int i = 0; i < this.punktliste.size(); i++) {
	    sb.append(Arrays.toString(this.punktliste.get(i).teile));
	    sb.append(",");
	}
	
	sb.append("]");

	return sb.toString();
    }    
}
