package spiel.linearschiefverschieben;

import java.util.ArrayList;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import welt.punktkoerper.Punktkoerperwelt;
import punkt.Dreipunkt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.linearschiefverschieben.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache eine Punktkörperwelt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	double a = 1.0;
	double mx = 1.0;
	double bx = 0.0;
	double my = 1.0;
	double by = 0.0;
	Dreipunkt vp = new Dreipunkt(0,0,0);
	
	Linearschiefverschiebenspiel s = new Linearschiefverschiebenspiel();
	s.spielen(pkw, a, mx, bx, my, by, vp);
    }
}
