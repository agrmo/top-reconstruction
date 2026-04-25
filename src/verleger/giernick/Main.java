package verleger.giernick;

import strecke.Zweistrecke;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import vielflach.Vielflach;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.giernick.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	Vielflach[] vl = new Vielflach[] {k};
	Dreivektor[] ol = new Dreivektor[] {p};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);

	// Verlegen die Welt.
	Zweistreckewelt zsw = Giernickverleger.verlege(vw,
						       new Dreivektor(0,0,0), 500,
						       1200, 600,
						       0, 0);
    }
}
