package basis;

import punkt.Zweipunkt;
import punkt.Dreipunkt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes basis.Main
*/

public class Main {
    static void beispielEins() {
	Zweipunkt va = new Zweipunkt(0,0);
	Zweipunkt vb = new Zweipunkt(0,1);
	
	Zweibasis b = new Zweibasis(va, vb);
    }

    static void beispielZwei() {
	Dreipunkt va = new Dreipunkt(0,0,1);
	Dreipunkt vb = new Dreipunkt(0,1,0);
	Dreipunkt vc = new Dreipunkt(1,0,0);
	
	Dreibasis b = new Dreibasis(va, vb, vc);
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
