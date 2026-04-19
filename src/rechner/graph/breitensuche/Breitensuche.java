package rechner.graph.breitensuche;

import graph.Nachbarschaftsliste;
import graph.Doppelnachbarschaftsliste;
import java.util.ArrayList;
import java.util.Arrays;
import liste.Liste;

public class Breitensuche  {

    // Die Nachbarschaftsliste muss verdoppelt sein.
    public static int[] breitensuche(Doppelnachbarschaftsliste dnl, int anfangknoten) {

	ArrayList<Integer> gesucht = new ArrayList<Integer>();
	ArrayList<Integer> zusuchen = new ArrayList<Integer>();
	
	zusuchen.add(anfangknoten);

	while (zusuchen.size() > 0) {
	    int naechste = zusuchen.remove(0);
	    gesucht.add(naechste);
	    ArrayList<Integer> nachbarn = dnl.n.get(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesucht.contains(nachbar) && !zusuchen.contains(nachbar)) {
		    zusuchen.add(nachbar);
		}
	    }
	}

	return Liste.nehmeArrayInt(gesucht);
    }
}
