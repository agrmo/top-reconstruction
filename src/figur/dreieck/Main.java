package figur.dreieck;

import strecke.Zweistrecke;
import druck.strecke.Streckedrucker;

/*
  javac -d classes $(find src -type f) && java -cp classes figur.dreieck.Main
*/

public class Main {
    public static void main(String[] args) {
	
	Dreieck de = new Dreieck(5);

	for (Zweistrecke zk : de.nehmeStrecken()) {
	    System.out.println(Streckedrucker.drucken(zk));
	}
    }
}
