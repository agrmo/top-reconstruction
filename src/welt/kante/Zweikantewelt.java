package welt.kante;
    
import java.util.ArrayList;
import welt.Welt;
import kante.Zweikante;

/*
  Eine Zweikantewelt ist eine Liste von zweidimensionalen Kanten.

  Die Kanten können vielleicht klare Figuren darstellen. Vielleicht
  eine Dreiecke oder ein Quadrat. Aber diese Kantewelt konnte von
  einer dreidimensionalen Welt gebildet sein. Ein Kubus verlegt auf
  einer zweidimensionale Ebene stellt keine schöne Figur dar, weil er
  wahrscheinlich enthält verschiedene Strecken innerhalb der Figur.
*/
public class Zweikantewelt extends Welt {
    public ArrayList<Zweikante> kantenliste;

    public Zweikantewelt(ArrayList<Zweikante> zkl) {
	this.kantenliste = zkl;
    }

    public String drucken() {
	StringBuilder sb = new StringBuilder();
	sb.append("Kanten dieser Welt:\n");
	
	for (int i = 0; i < this.kantenliste.size(); i++) {

	    // Das String dieser Kante.
	    String ks = this.kantenliste.get(i).drucken();

	    sb.append(ks);

	    sb.append("\n");
	}

	return sb.toString();
    }
}
