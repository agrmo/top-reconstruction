package vieleck.dreieck;

import strecke.Zweistrecke;
import druck.strecke.Streckedrucker;

/*
  javac -d classes $(find src -type f) && java -cp classes vieleck.dreieck.Main
*/

public class Main {
    public static void main(String[] args) {
	
	Dreieck de = new Dreieck(5);

	for (Zweistrecke zk : de.nehmekanten()) {
	    System.out.println(Streckedrucker.drucken(zk));
	}
    }
}
