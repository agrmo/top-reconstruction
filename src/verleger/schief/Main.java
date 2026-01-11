package verleger.schief;

import java.util.ArrayList;
import vektor.Dreivektor;
import strecke.Zweistrecke;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;
import welt.zweistrecke.Zweistreckewelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.schief.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine dreidimensionale Vielflachwelt.
	// Diese Welt enthält einen Kubus auf der Stelle (100,100,100).
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(k);
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(p);
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Der Verleger, der eine zweidimensionale Welt aufbauen wird.
	Schiefverleger sv = new Schiefverleger(-1.0);

	// Benutzen den Verleger.
	Zweistreckewelt zkw = sv.verlegenWelt(kw);
    }
}
