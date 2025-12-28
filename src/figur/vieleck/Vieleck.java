package figur.vieleck;

import java.util.ArrayList;
import punkt.Zweipunkt;

// Ein Vieleck ist eine Figur, die aus mindestens drei durch Linien
// verbundenen, voneinander verschiedenen Zweipunkten besteht.
//
// Ein Vieleck ist eine Liste von Zweipunkten. Die Vieleck kann eine
// Fläche eines dreidimensionalen Körpers zeigen.
//
// Ein Vieleck ist in zwei Dimensionen bestimmt, während eine Fläche
// ist in drei Dimensionen bestimmt.
public class Vieleck {

    // Eine geordnete Reihe von Zweipunkten, die eine Fläche bildet.
    // Die Ordung der Zweipunkten ist hier sehr wichtig, sodaß wir die
    // Zweipunkten entweder gegen oder in den Uhrzeigersinn
    // durchlaufen können, um das Vieleck aufzubauen.
    ArrayList<Zweipunkt> punktliste;

    // ein: Liste von Zweipunkten
    public Vieleck(ArrayList<Zweipunkt> pl) {
	this.punktliste = pl;
    }

    // Mache ein String dieses Vielecks.
    public String drucken() {
	StringBuilder sb = new StringBuilder();	
	sb.append("Vieleck: ");
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
