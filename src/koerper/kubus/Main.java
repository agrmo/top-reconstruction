package koerper.kubus;

import punkt.Dreipunkt;
import kante.Dreikante;

/*
  javac -d classes $(find src -name '*.java')
  java -cp classes koerper.kubus.Main
*/

public class Main {
    public static void main(String[] args) {

	Kubus k = new Kubus(1);

	System.out.println("Ecken:");
	Dreipunkt[] ecken = k.nehmeEcken();
	for (int i = 0; i < ecken.length; i++) {
	    System.out.println(ecken[i].drucken());
	}

	System.out.println("Dreikanten:");
	Dreikante[] kanten = k.nehmeKanten();
	for (int i = 0; i < kanten.length; i++) {
	    System.out.println(kanten[i].drucken());
	}
	
    }
}
