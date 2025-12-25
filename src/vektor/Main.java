package vektor;

import java.util.Arrays;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes vektor.Main
*/

public class Main {
    public static void main(String[] args) {
	Vektor va = new Vektor(new int[] {1,2,3});
	Vektor vb = new Vektor(new int[] {1,1,1});
	va.addiere(vb);

	System.out.println(Arrays.toString(va.teile));
	System.out.println(Arrays.toString(vb.teile));

	vb.punkt(new Vektor(new int[] {0,5,0}));
	
	System.out.println(Arrays.toString(vb.teile));
    }
}
