package welt.graph.zufalls;

import java.util.Random;
import vektor.Dreivektor;

public class Zufallsdreigraphwelt {

    /*
      Mache die Orte der Knoten des Graphen, die zufällig gestellt
      wurden.

      Einfach gesagt ist dies eine Menge von zufälligen Zahlen,
      zwischen [xmin, xmax], [ymin, ymax] und [zmin, zmax].
     */
    public static Dreivektor[] mache(int groesse,
				     int xmin, int xmax,
				     int ymin, int ymax,
				     int zmin, int zmax) {
	
	Dreivektor[] orte = new Dreivektor[groesse];
	Random r = new Random();
	int breitex = xmax - xmin;
	int breitey = ymax - ymin;
	int breitez = zmax - zmin;

	for (int i = 0; i < groesse; i++) {
	    double rnaechstex = r.nextDouble();
	    double rnaechstey = r.nextDouble();
	    double rnaechstez = r.nextDouble();
	    double naechstex = (breitex * rnaechstex) + xmin;
	    double naechstey = (breitey * rnaechstey) + ymin;
	    double naechstez = (breitez * rnaechstez) + ymin;

	    orte[i] = new Dreivektor(naechstex, naechstey, naechstez);
	}

	return orte;
    }
}
