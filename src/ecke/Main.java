package ecke;

import java.util.ArrayList;
import punkt.Dreipunkt;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -name '*.java')	\
  && java -cp classes ecke.Main
*/

public class Main {
    public static void main(String[] args) {
	Dreipunkt p = new Dreipunkt(1,1,1);

	Dreivektor va = new Dreivektor(0,1,0);
	Dreivektor vb = new Dreivektor(1,0,0);
	Dreivektor vc = new Dreivektor(0,0,1);

	ArrayList<Dreivektor> vl = new ArrayList<Dreivektor>();
	vl.add(va);
	vl.add(vb);
	vl.add(vc);

	Dreiecke e = new Dreiecke(p, vl);

	System.out.println(e.kanten.get(0).drucken());
    }
}
