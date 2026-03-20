package winkel;

import vektor.Dreivektor;

/* Zum Aufbau eines Winkels benutzen wir drei Vektoren.

   zB

   2----------1
    \ theta
     \
      \
       \
        \
	 3

   Daraus ergibt sich immer einen Winkel theta.
   
*/
public class Dreiwinkel {

    public Dreivektor eins;
    public Dreivektor zwei;
    public Dreivektor drei;

    public Dreiwinkel(Dreivektor e, Dreivektor z, Dreivektor d) {
	this.eins = e;
	this.zwei = z;
	this.drei = d;
    }

    // Berechne den Winkel. 
    public double nehmewinkel() {
	return 0.0;
    }
}
