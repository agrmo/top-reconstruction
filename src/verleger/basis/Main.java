package verleger.basis;

import java.util.ArrayList;
import strecke.Zweistrecke;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import vielflach.Vielflach;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import matrix.Dreimatrix;

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

	Dreimatrix basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);

	// Verlegen die Welt.
	Zweistreckewelt zkw = Basisverleger.verlegen(kw,
						     new Dreivektor(0,0,0), 500,
						     1200, 600,
						     basis);
    }
}
