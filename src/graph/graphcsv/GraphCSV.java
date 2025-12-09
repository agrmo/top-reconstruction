package graph.graphcsv;
 
import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

// Ein Object, die eine CSV-Datei erzeugen kann, die einen Graph
// verköpert. Deutlich nutzbar für das Programm Gephi.
public class GraphCSV {
    public GraphCSV() {
	
    }

    // Mache eine CSV-Datei des Graphen, gegeben eine
    // Nachbarschaftsliste.
    public String macheGepheiCSV(Nachbarschaftsliste n) {
	return "";
    }

    // Mache eine CSV-Datei des Graphen, gegeben eine
    // Nachbarschaftsmatrix.
    public String macheGepheiCSV(Nachbarschaftsmatrix n) {
	StringBuilder sb = new StringBuilder();

	// Am Anfang gibt es immer
	sb.append("Source,Target\n");

	for (int i = 0; i < n.n.length; i++) {
	    // String für einen Knoten
	    StringBuilder sbKnoten = new StringBuilder();
	    for (int j = 0; j < n.n.length; j++) {
		if (n.n[i][j] == true) {
		    sbKnoten.append(i);
		    sbKnoten.append(",");
		    sbKnoten.append(j);
		    sbKnoten.append("\n");
		}
	    }
	    
	    if (sbKnoten.length() > 0) {
		sb.append(sbKnoten.toString());
	    }
	}

	return sb.toString();
    }
}
