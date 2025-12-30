package druck.graph;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

// Ein Objekt, das einen Graph darstellen können. Die Art von
// Darstellung wird nur schriftlich aus Text angegeben.
public class GraphText {

    // Drucke eine Nachbarschaftsliste.
    public String drucke(Nachbarschaftsliste n) {
	StringBuilder ns = new StringBuilder();
	for (int i = 0; i < n.n.size(); i++) {
	    ns.append(i);
	    ns.append(": ");
	    ns.append(n.n.get(i));
	    ns.append("\n");
	}
	return ns.toString();
    }

    // Drucke eine Nachbarschaftsmatrix.
    public String drucke(Nachbarschaftsmatrix n) {
	StringBuilder ns = new StringBuilder();
	for (int i = 0; i < n.n.length; i++) {
	    for (int j = 0; j < n.n.length; j++) {
		if (n.n[i][j] == true) {
		    ns.append("1");
		} else {
		    ns.append("0");
		}
		ns.append(" ");
	    }
	    ns.append("\n");
	}
	return ns.toString();
    }
}
