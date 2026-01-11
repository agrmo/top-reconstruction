package vektor;

import druck.vektor.Vektordrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes vektor.Main
*/

public class Main {
    static void beispielEins() {
	Dreivektor va = new Dreivektor(1,2,3);
	Dreivektor vb = new Dreivektor(1,1,1);
	va.addiere(vb);

	System.out.println(Vektordrucker.drucken(va));
	System.out.println(Vektordrucker.drucken(vb));

	vb.vektor(new Dreivektor(0,5,0));
	
	System.out.println(Vektordrucker.drucken(vb));
    }
    
    static void beispielZwei() {
	Zweivektor va = new Zweivektor(1,2);
	Zweivektor vb = new Zweivektor(1,1);
	va.addiere(vb);
	System.out.println(Vektordrucker.drucken(va));
	System.out.println(Vektordrucker.drucken(vb));
	va.vektor(new Zweivektor(0,5));
	System.out.println(Vektordrucker.drucken(va));
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
