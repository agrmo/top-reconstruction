package verleger.auge;

import java.util.ArrayList;
import strecke.Zweistrecke;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import vielflach.Vielflach;
import welt.strecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;
import matrix.Dreimatrix;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.basis.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache die dreidimensionale Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	ArrayList<Vielflach> vl = new ArrayList<Vielflach>();
	vl.add(k);
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(p);
	Vielflachwelt vw = new Vielflachwelt(vl, ol);

	Dreimatrix vorbasis = new Dreimatrix(1,0,0,0,1,0,0,0,1);
	Dreimatrix basis = new Dreimatrix(1,0,0,0,1,0,0,0,1);

	// Verlegen die Welt.
	Zweistreckewelt zsw = Augeverleger.verlegen(vw,
						    new Dreivektor(0,0,0), 500,
						    1200, 600,
						    vorbasis, basis);
    }
}
