package basis;

import vektor.Zweivektor;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes basis.Main
*/

public class Main {
    static void beispielEins() {
	Zweivektor va = new Zweivektor(0,0);
	Zweivektor vb = new Zweivektor(0,1);
	
	Zweibasis b = new Zweibasis(va, vb);

	System.out.println(b.drucken());
    }

    static void beispielZwei() {
	Dreivektor va = new Dreivektor(0,0,1);
	Dreivektor vb = new Dreivektor(0,1,0);
	Dreivektor vc = new Dreivektor(1,0,0);
	
	Dreibasis b = new Dreibasis(va, vb, vc);

	System.out.println(b.drucken());
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
