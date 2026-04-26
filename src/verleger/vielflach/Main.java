package verleger.vielflach;

import matrix.Dreimatrix;
import strecke.Zweistrecke;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import verleger.punkt.Punktverleger;
import verleger.strecke.Streckeverleger;
import stellung.Dreistellung;
import orientierung.Orientierung;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.vielflach.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache die dreidimensionale Welt.
	Kubus k = new Kubus(50);
	Vielflach[] vl = new Vielflach[] {k};
	Dreistellung[] sl = new Dreistellung[] {
	    new Dreistellung(new Dreivektor(100,100,100),
			     new Orientierung(0,0,0))
	};
	Vielflachwelt vw = new Vielflachwelt(vl, sl);

	// Verlegen die Welt.
	Zweistreckewelt zsw = Vielflachverleger.verlege(vw,
						   new Dreivektor(0,0,0), 500,
						   1200, 600,
						   0,0,0);
    }
}
