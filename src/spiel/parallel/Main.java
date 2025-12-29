package spiel.parallel;

import java.util.ArrayList;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.parallel.Main
*/

public class Main{
    public static void main(String[] args) {
	
	// Wir müssen aber nur die Welt eintragen. Das Spiel wird sich
	// selbst die Handlung und Sicht schaffen.
	
	// Mache eine Punktkörperwelt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Geben die Welt in das Spiel ein.
	Parallelspiel s = new Parallelspiel();
	s.spielen(pkw);
    }
}
