package verleger.auge;

import java.util.ArrayList;
import strecke.Zweistrecke;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import koerper.Koerper;
import welt.zweistrecke.Zweistreckewelt;
import welt.koerper.Koerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.auge.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache die dreidimensionale Welt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Verlegen die Welt.
	Zweistreckewelt zkw = Augeverleger.verlegen(kw, new Dreipunkt(0,0,0), 500, 1200, 600, 0, 0, 0);
    }
}
