package druck.graph;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

// Ein Objekt, das einen Graph darstellen können. Die Art von
// Darstellung wird nur schriftlich aus Text angegeben.
public class Graphtext {

    // Drucke eine Nachbarschaftsliste.
    public String drucke(Nachbarschaftsliste n) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < n.n.size(); i++) {
	    sb.append(i);
	    sb.append(": ");
	    sb.append(n.n.get(i));
	    sb.append("\n");
	}
	return sb.toString();
    }

    // Drucke eine Nachbarschaftsmatrix.
    public String drucke(Nachbarschaftsmatrix n) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < n.n.length; i++) {
	    for (int j = 0; j < n.n.length; j++) {
		if (n.n[i][j] == true) {
		    sb.append("1");
		} else {
		    sb.append("0");
		}
		sb.append(" ");
	    }
	    sb.append("\n");
	}
	return sb.toString();
    }
}
