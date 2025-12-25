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
	Punkt p = new Punkt(new int[] {1,1,1});

	Vektor va = new Vektor(new int[] {0,1,0});
	Vektor vb = new Vektor(new int[] {1,0,0});
	Vektor vc = new Vektor(new int[] {0,0,1});

	ArrayList<Vektor> vl = new ArrayList<Vektor>();
	vl.add(va);
	vl.add(vb);
	vl.add(vc);

	Ecke e = new Ecke(p, vl);

	System.out.println(Arrays.toString(vl.get(0).teile));
    }
}
