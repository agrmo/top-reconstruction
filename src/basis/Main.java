package basis;

import vektor.Vektor;

/*
  javac -d classes $(find src -name '*.java')
  java -cp classes basis.Main
*/

public class Main {
    public static void main(String[] args) {
	Vektor va = new Vektor(0,0,1);
	Vektor vb = new Vektor(0,1,0);
	Vektor vc = new Vektor(1,0,0);
	
	Basis b = new Basis(va, vb, vc);

	System.out.println(b.drucken());
    }
}
