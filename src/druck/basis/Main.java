package druck.basis;

import vektor.Zweivektor;
import vektor.Dreivektor;
import basis.Zweibasis;
import basis.Dreibasis;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes druck.basis.Main
*/

public class Main {
    static void beispielEins() {
	Zweivektor va = new Zweivektor(0,0);
	Zweivektor vb = new Zweivektor(0,1);
	
	Zweibasis b = new Zweibasis(va, vb);
	System.out.println(Basisdrucker.drucken(b));
	
    }

    static void beispielZwei() {
	Dreivektor va = new Dreivektor(0,0,1);
	Dreivektor vb = new Dreivektor(0,1,0);
	Dreivektor vc = new Dreivektor(1,0,0);
	
	Dreibasis b = new Dreibasis(va, vb, vc);
	System.out.println(Basisdrucker.drucken(b));
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
