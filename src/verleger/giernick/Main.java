package verleger.giernick;

import java.util.ArrayList;
import strecke.Zweistrecke;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import vielflach.Vielflach;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.giernick.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache die dreidimensionale Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(k);
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(p);
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Verlegen die Welt.
	Zweistreckewelt zkw = Giernickverleger.verlegen(kw,
							new Dreivektor(0,0,0), 500,
							1200, 600,
							0, 0);
    }
}
