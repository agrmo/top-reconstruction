package verleger.schief;

import java.util.ArrayList;
import strecke.Zweistrecke;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import koerper.Koerper;
import welt.zweistrecke.Zweistreckewelt;
import welt.koerper.Koerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.schief.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine dreidimensionale Körperwelt.
	// Diese Welt enthält einen Kubus auf der Stelle (100,100,100).
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Der Verleger, der eine zweidimensionale Welt aufbauen wird.
	Schiefverleger sv = new Schiefverleger(-1.0);

	// Benutzen den Verleger.
	Zweistreckewelt zkw = sv.verlegenWelt(kw);
    }
}
