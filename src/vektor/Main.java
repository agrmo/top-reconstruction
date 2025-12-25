package vektor;

import java.util.Arrays;

/*
  javac -d classes src/vektor/* && java -cp classes vektor.Main
*/

public class Main {
    public static void main(String[] args) {
	Vektor va = new Vektor(1,2,3);
	Vektor vb = new Vektor(1,1,1);
	va.addiere(vb);

	System.out.println(va.drucken());
	System.out.println(vb.drucken());

	vb.punkt(new Vektor(0,5,0));
	
	System.out.println(vb.drucken());
    }
}
