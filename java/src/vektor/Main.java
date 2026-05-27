package vektor;

import druck.vektor.Vektordrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes vektor.Main
*/

public class Main {
    static void beispieleins() {
	Dreivektor va = new Dreivektor(1,2,3);
	Dreivektor vb = new Dreivektor(1,1,1);
	va.addiere(vb);

	System.out.println(Vektordrucker.drucke(va));
	System.out.println(Vektordrucker.drucke(vb));

	vb.punkt(new Dreivektor(0,5,0));
	
	System.out.println(Vektordrucker.drucke(vb));
    }
    
    static void beispielzwei() {
	Zweivektor va = new Zweivektor(1,2);
	Zweivektor vb = new Zweivektor(1,1);
	va.addiere(vb);
	System.out.println(Vektordrucker.drucke(va));
	System.out.println(Vektordrucker.drucke(vb));
	va.punkt(new Zweivektor(0,5));
	System.out.println(Vektordrucker.drucke(va));
    }
    
    public static void main(String[] args) {
	beispielzwei();
    }
}
