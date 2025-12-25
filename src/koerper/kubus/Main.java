package koerper.kubus;

import punkt.Punkt;
import java.util.ArrayList;
import java.util.Arrays;
import kante.Kante;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes koerper.kubus.Main
*/

public class Main {
    public static void main(String[] args) {

	Kubus k = new Kubus(1);

	System.out.println("Ecken:");
	Punkt[] ecken = k.nehmeEcken();
	for (int i = 0; i < ecken.length; i++) {
	    System.out.println(ecken[i].drucken());
	}

	System.out.println("Kanten:");
	Kante[] kanten = k.nehmeKanten();
	for (int i = 0; i < kanten.length; i++) {
	    System.out.println(kanten[i].drucken());
	}	
    }
}
