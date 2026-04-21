package welt.graph.zufaellig;

import java.util.Random;
import vektor.Zweivektor;

public class Zufaelligzweigraphwelt {

    /*
      Mache die Orte der Knoten des Graphen, die zufällig gestellt
      wurden.

      Einfach gesagt ist dies eine Menge von zufälligen Zahlen,
      zwischen [xmin, xmax] und [ymin, ymax].
     */
    public static Zweivektor[] mache(int groesse,
				     int xmin, int xmax,
				     int ymin, int ymax) {
	
	Zweivektor[] orte = new Zweivektor[groesse];
	Random r = new Random();
	int breitex = xmax - xmin;
	int breitey = ymax - ymin;

	for (int i = 0; i < groesse; i++) {
	    double rnaechstex = r.nextDouble();
	    double rnaechstey = r.nextDouble();
	    double naechstex = (breitex * rnaechstex) + xmin;
	    double naechstey = (breitey * rnaechstey) + ymin;

	    orte[i] = new Zweivektor(naechstex, naechstey);
	}

	return orte;
    }
}
