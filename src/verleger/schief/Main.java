package verleger.schief;

import java.util.ArrayList;
import kante.Zweikante;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import vektor.Dreivektor;
import welt.kante.Zweikantewelt;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes verleger.schief.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine dreidimensionale Punktkörperwelt.
	// Diese Welt enthält einen Kubus auf der Stelle (100,100,100).
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Der Verleger, der eine zweidimensionale Welt aufbauen wird.
	Dreivektor d = new Dreivektor(1,1,-1);
	Schiefverleger sv = new Schiefverleger(d);

	// Benutzen den Verleger.
	Zweikantewelt zkw = sv.verlegenWelt(pkw);

	// Drucken sie.
	System.out.println(zkw.drucken());
    }
}
