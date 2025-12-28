package flaeche;

import java.util.ArrayList;
import punkt.Dreipunkt;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes flaeche.Main
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

	System.out.println(f.drucken());
    }
}
