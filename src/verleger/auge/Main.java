package verleger.auge;

import java.util.ArrayList;
import strecke.Zweistrecke;
import vielflach.kubus.Kubus;
import punkt.Dreipunkt;
import vielflach.Vielflach;
import welt.zweistrecke.Zweistreckewelt;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.auge.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache die dreidimensionale Welt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Verlegen die Welt.
	Zweistreckewelt zkw = Augeverleger.verlegen(kw,
						    new Dreipunkt(0,0,0),
						    500, 1200, 600, 0, 0, 0);
    }
}
