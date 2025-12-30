package ecke;

import java.util.ArrayList;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import vektor.Dreivektor;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes ecke.Main
*/

public class Main {
    static void beispielEins() {
	Zweipunkt p = new Zweipunkt(1,1);

	Zweivektor va = new Zweivektor(0,1);
	Zweivektor vb = new Zweivektor(1,0);
	Zweivektor vc = new Zweivektor(0,0);

	ArrayList<Zweivektor> vl = new ArrayList<Zweivektor>();
	vl.add(va);
	vl.add(vb);

	Zweiecke e = new Zweiecke(p, vl);
    }

    static void beispielZwei() {
	Dreipunkt p = new Dreipunkt(1,1,1);

	Dreivektor va = new Dreivektor(0,1,0);
	Dreivektor vb = new Dreivektor(1,0,0);
	Dreivektor vc = new Dreivektor(0,0,1);

	ArrayList<Dreivektor> vl = new ArrayList<Dreivektor>();
	vl.add(va);
	vl.add(vb);
	vl.add(vc);

	Dreiecke e = new Dreiecke(p, vl);
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
