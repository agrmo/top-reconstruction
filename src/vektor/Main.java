package vektor;

import java.util.Arrays;

/*
  javac -d classes src/vektor/* && java -cp classes vektor.Main
*/

public class Main {
    public static void main(String[] args) {
	Dreivektor va = new Dreivektor(1,2,3);
	Dreivektor vb = new Dreivektor(1,1,1);
	va.addiere(vb);

	System.out.println(va.drucken());
	System.out.println(vb.drucken());

	vb.punkt(new Dreivektor(0,5,0));
	
	System.out.println(vb.drucken());
    }
}
