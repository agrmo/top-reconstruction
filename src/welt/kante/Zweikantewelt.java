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
}
