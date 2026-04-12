package basis;

import vektor.Zweivektor;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes basis.Main
*/

public class Main {
    static void beispieleins() {
	Zweivektor va = new Zweivektor(0,0);
	Zweivektor vb = new Zweivektor(0,1);
	
	Zweibasis b = new Zweibasis(va, vb);
    }

    static void beispielzwei() {
	Dreivektor va = new Dreivektor(0,0,1);
	Dreivektor vb = new Dreivektor(0,1,0);
	Dreivektor vc = new Dreivektor(1,0,0);
	
	Dreibasis b = new Dreibasis(va, vb, vc);
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
