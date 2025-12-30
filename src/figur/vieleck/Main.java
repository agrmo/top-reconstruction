package figur.vieleck;

import java.util.ArrayList;
import punkt.Zweipunkt;
import druck.figur.vieleck.Vieleckdrucker;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes figur.vieleck.Main;
*/

public class Main {
    public static void main(String[] args) {
	ArrayList<Zweipunkt> pl = new ArrayList<Zweipunkt>();

	// Ein Quadrat ist eine Vieleck. Es ist hier gegen den
	// Uhrzeigersinn aufgebaut.
	
	pl.add(new Zweipunkt(0,0));
	pl.add(new Zweipunkt(1,0));
	pl.add(new Zweipunkt(1,1));
	pl.add(new Zweipunkt(0,1));
	Vieleck v = new Vieleck(pl);

	System.out.println(Vieleckdrucker.drucken(v));
    }
}
