package rechner.graph.kanteanzahl;

import graph.Nachbarschaftsliste;
    
// Berechne die Anzahl von Kanten des ganzen Graphen. Am besten ist
// die Antwort mit einem nicht verdoppelten Graphen berechnet.
public class Kanteanzahl {
    
    public static int kanteanzahl(Nachbarschaftsliste nl) {
	int kanteanzahl = 0;
	
	for (int i = 0; i < nl.n.size(); i++) {
	    kanteanzahl += nl.n.get(i).size();
	}

	return kanteanzahl;
    }
}
