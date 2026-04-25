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

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.vielflach.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache die dreidimensionale Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	Vielflach[] vl = new Vielflach[] {k};
	Dreivektor[] ol = new Dreivektor[] {p};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);

	// Verlegen die Welt.
	Zweistreckewelt zsw = Vielflachverleger.verlege(vw,
						   new Dreivektor(0,0,0), 500,
						   1200, 600,
						   0,0,0);
    }
}
