package verleger.verschieben;

import java.util.ArrayList;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import welt.kante.Zweikantewelt;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.verschieben.Main
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
	Verschiebenverleger vv = new Verschiebenverleger();
	Dreipunkt vp = new Dreipunkt(100,100,100);

	// Benutzen den Verleger.
	vv.verlegenWelt(pkw, vp);
    }
}
