package punkt;

import druck.punkt.Punktdrucker;

/*
  javac -d classes $(find src -name '*.java') \
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
	Dreipunkt pb = new Dreipunkt(5,5,5);
	pa.addieren(pb);
	System.out.println(Punktdrucker.drucken(pa));	
    }

    static void beispielDrei() {
	Zweipunkt pa = new Zweipunkt(1,2);
	Zweipunkt pb = new Zweipunkt(1,1);
	pa.addieren(pb);
	System.out.println(Punktdrucker.drucken(pa));
	System.out.println(Punktdrucker.drucken(pb));
    }
    
    public static void main(String[] args) {
	beispielDrei();
    }
}
