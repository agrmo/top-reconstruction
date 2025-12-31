package punkt;

import druck.punkt.Punktdrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes punkt.Main
*/

public class Main {
    static void beispielEins() {
	Dreipunkt p = new Dreipunkt(1,2,3);
	System.out.println(Punktdrucker.drucken(p));
    }

    static void beispielZwei() {
	Dreipunkt pa = new Dreipunkt(1,2,3);
	System.out.println(Punktdrucker.drucken(pa));
	
	Dreipunkt pb = new Dreipunkt(10,10,10);
	pa.addieren(pb);
	pa.addieren(pb);
	System.out.println(Punktdrucker.drucken(pa));	
    }

    static void beispielDrei() {
	Zweipunkt pa = new Zweipunkt(1,2);
	System.out.println(Punktdrucker.drucken(pa));
	
	Zweipunkt pb = new Zweipunkt(1,1);
	pa.addieren(pb);
	pa.addieren(pb);
	System.out.println(Punktdrucker.drucken(pa));
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
