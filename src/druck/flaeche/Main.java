package druck.flaeche;

import punkt.Dreipunkt;
import flaeche.Flaeche;
import java.util.ArrayList;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes druck.flaeche.Main
*/

public class Main {
    public static void main(String[] args) {
	ArrayList<Dreipunkt> pl = new ArrayList<Dreipunkt>();

	// Ein Quadrat auf der Ebene y=0.
	pl.add(new Dreipunkt(0,0,0));
	pl.add(new Dreipunkt(1,0,0));
	pl.add(new Dreipunkt(1,0,1));
	pl.add(new Dreipunkt(0,0,1));
	Flaeche f = new Flaeche(pl);

	System.out.println(Flaechedrucker.drucken(f));
    }
}
