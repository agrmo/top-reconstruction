package ecke;

import java.util.Arrays;
import java.util.ArrayList;
import punkt.Punkt;
import vektor.Vektor;

/*
  javac -d classes $(find src -name '*.java')	\
  && java -cp classes ecke.Main
*/

public class Main {
    public static void main(String[] args) {
	Punkt p = new Punkt(1,1,1);

	Vektor va = new Vektor(0,1,0);
	Vektor vb = new Vektor(1,0,0);
	Vektor vc = new Vektor(0,0,1);

	ArrayList<Vektor> vl = new ArrayList<Vektor>();
	vl.add(va);
	vl.add(vb);
	vl.add(vc);

	Ecke e = new Ecke(p, vl);

	System.out.println(e.kanten.get(0).drucken());
    }
}
