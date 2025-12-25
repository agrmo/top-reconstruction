package flaeche;

import java.util.Arrays;
import java.util.ArrayList;
import punkt.Punkt;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes flaeche.Main
*/

public class Main {
    public static void main(String[] args) {
	ArrayList<Punkt> pl = new ArrayList<Punkt>();

	// Ein Quadrat als Fläche.
	pl.add(new Punkt(0,0,0));
	pl.add(new Punkt(1,0,0));
	pl.add(new Punkt(1,0,1));
	pl.add(new Punkt(0,0,1));
	Flaeche f = new Flaeche(pl);

	System.out.println(f.drucken());
    }
}
