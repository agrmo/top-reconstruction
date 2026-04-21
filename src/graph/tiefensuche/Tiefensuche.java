package graph.tiefensuche;

import graph.Nachbarschaftsliste;
import graph.Doppelnachbarschaftsliste;
import java.util.ArrayList;
import liste.Liste;

public class Tiefensuche  {

    // Die Nachbarschaftsliste muss verdoppelt sein.
    public static int[] tiefensuche(Doppelnachbarschaftsliste dnl, int anfangknoten) {

	ArrayList<Integer> gesucht = new ArrayList<Integer>();
	ArrayList<Integer> zusuchen = new ArrayList<Integer>();

	// Anfang
	zusuchen.add(anfangknoten);

	while (zusuchen.size() > 0) {
	    int naechste = zusuchen.remove(0);
	    gesucht.add(naechste);
	    ArrayList<Integer> nachbarn = dnl.n.get(naechste);
	    System.out.println(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesucht.contains(nachbar) && !zusuchen.contains(nachbar)) {
		    zusuchen.add(0, nachbar);
		}
	    }
	}

	return Liste.nehmeArrayInt(gesucht);
    }
}
