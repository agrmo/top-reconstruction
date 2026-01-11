package dreher.giernick;

import punkt.Zweipunkt;
import punkt.Dreipunkt;
import druck.punkt.Punktdrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.giernick.Main
*/

public class Main {

    static void beispielEins() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	
	// Soll [-1,1,-1] sein
	Dreipunkt pb = Giernickdreher.drehen(pa, Math.PI, 0);

	System.out.println(Punktdrucker.drucken(pa));
	System.out.println(Punktdrucker.drucken(pb));	
    }

    static void beispielZwei() {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	
	// Soll [-1,-1,1] sein
	Dreipunkt pb = Giernickdreher.drehen(pa, Math.PI, Math.PI);

	System.out.println(Punktdrucker.drucken(pa));
	System.out.println(Punktdrucker.drucken(pb));
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
