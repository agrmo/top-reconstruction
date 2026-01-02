package verschieber;

import java.util.ArrayList;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import koerper.Koerper;
import welt.koerper.Koerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verschieber.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine dreidimensionale Körperwelt.
	// Diese Welt enthält einen Kubus auf der Stelle (100,100,100).
	Kubus k = new Kubus(50);
	Dreipunkt o = new Dreipunkt(100,100,100);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(o);
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Benutzen den Verleger.
	Dreipunkt vp = new Dreipunkt(100,100,100);
	Verschieber.verschieben(kw, vp);
    }
}
