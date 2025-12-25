package kante;

import java.util.Arrays;
import punkt.Punkt;

/*
  javac -d classes $(find src -name '*.java')	\
  && java -cp classes kante.Main
*/

public class Main {
    public static void main(String[] args) {
	Punkt pa = new Punkt(1,1,1);
	Punkt pb = new Punkt(2,2,2);
	Kante ka = new Kante(pa, pb);

	System.out.println(ka.drucken());
    }
}
