package verschieber;

import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import vielflach.Vielflach;
import welt.vielflach.Vielflachwelt;
import stellung.Dreistellung;
import orientierung.Orientierung;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verschieber.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine dreidimensionale Vielflachwelt.
	// Diese Welt enthält einen Kubus auf der Stelle (100,100,100).
	Kubus k = new Kubus(50);
	Vielflach[] vl = new Vielflach[] {k};
	Dreistellung[] sl = new Dreistellung[] {
	    new Dreistellung(new Dreivektor(100,100,100),
			     new Orientierung(0,0,0))
	};
	Vielflachwelt vw = new Vielflachwelt(vl, sl);

	// Benutze den Verleger.
	Dreivektor vp = new Dreivektor(100,100,100);
	Verschieber.verschiebe(vw, vp);
    }
}
