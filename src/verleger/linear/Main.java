package verleger.linear;

import java.util.ArrayList;
import kante.Zweikante;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import vektor.Dreivektor;
import welt.kante.Zweikantewelt;
import welt.punktkoerper.Punktkoerperwelt;
import verleger.schief.Schiefverleger;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes verleger.linear.Main
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

	// Mache den Verleger, der eine zweidimensionale Welt aufbauen
	// wird.
	Dreivektor d = new Dreivektor(1,1,-1);
	Schiefverleger sv = new Schiefverleger(pkw, d);
	
	// Benutzen den Verleger.
	Zweikantewelt zkw = sv.verlegenWelt();

	// Mache den Verleger, der eine zweidimensionale Welt aufbauen
	// wird.
	Linearverleger lv = new Linearverleger(zkw, 1.0, 1.0, 1.0, 1.0);
	lv.verlegenWelt();

	// Drucken sie.
	System.out.println(zkw.drucken());
    }
}
