package figur.dreieck;

import kante.Zweikante;
import druck.kante.Kantedrucker;

/*
  javac -d classes $(find src -type f) && java -cp classes figur.dreieck.Main
*/

public class Main {
    public static void main(String[] args) {
	
	Dreieck de = new Dreieck(5);

	for (Zweikante zk : de.nehmeKanten()) {
	    System.out.println(Kantedrucker.drucken(zk));
	}
    }
}
