package verschieber;

import java.util.ArrayList;
import vielflach.kubus.Kubus;
import punkt.Dreipunkt;
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
	Dreipunkt o = new Dreipunkt(100,100,100);
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(o);
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Benutzen den Verleger.
	Dreipunkt vp = new Dreipunkt(100,100,100);
	Verschieber.verschieben(kw, vp);
    }
}
