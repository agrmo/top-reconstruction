package verleger.giernick;

import java.util.ArrayList;
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
	ArrayList<Vielflach> vl = new ArrayList<Vielflach>();
	vl.add(k);
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(p);
	Vielflachwelt vw = new Vielflachwelt(vl, ol);

	// Verlegen die Welt.
	Zweistreckewelt zsw = Giernickverleger.verlegen(vw,
							new Dreivektor(0,0,0), 500,
							1200, 600,
							0, 0);
    }
}
