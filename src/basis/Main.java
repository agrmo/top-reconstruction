package basis;

import vektor.Dreivektor;

/*
  javac -d classes $(find src -name '*.java')
  java -cp classes basis.Main
*/

public class Main {
    public static void main(String[] args) {
	Dreivektor va = new Dreivektor(0,0,1);
	Dreivektor vb = new Dreivektor(0,1,0);
	Dreivektor vc = new Dreivektor(1,0,0);
	
	Dreibasis b = new Dreibasis(va, vb, vc);

	System.out.println(b.drucken());
    }
}
