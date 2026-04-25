package verschieber;

import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import vielflach.Vielflach;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verschieber.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine dreidimensionale Vielflachwelt.
	// Diese Welt enthält einen Kubus auf der Stelle (100,100,100).
	Kubus k = new Kubus(50);
	Dreivektor o = new Dreivektor(100,100,100);
	Vielflach[] vl = new Vielflach[] {k};
	Dreivektor[] ol = new Dreivektor[] {o};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);

	// Benutzen den Verleger.
	Dreivektor vp = new Dreivektor(100,100,100);
	Verschieber.verschieben(vw, vp);
    }
}
