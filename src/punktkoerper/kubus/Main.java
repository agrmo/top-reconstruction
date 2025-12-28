package punktkoerper.kubus;

import punktkoerper.Punktkoerper;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import kante.Dreikante;

/*
javac -d classes $(find src -name '*.java') \
&& java -cp classes punktkoerper.kubus.Main
*/

public class Main {
    public static void main(String[] args) {

	// Ein Kubus und dessen Ort.
	Kubus k = new Kubus(50);

	Dreipunkt p = new Dreipunkt(100,100,100);

	Punktkubus pk = new Punktkubus(k, p);

	Dreikante[] kanten = pk.nehmeKanten();
	
	for (int i = 0; i < kanten.length; i++) {
	    System.out.println(kanten[i].drucken());
	}
    }    
}
