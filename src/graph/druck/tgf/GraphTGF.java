package graph.druck.tgf;
 
import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

// Ein Object, die eine TGF-Datei erzeugen kann, die einen Graph
// verköpert. Deutlich nutzbar für das Programm Gephi.
// Beispiel:
// Knoten: 0,1,2
// Kanten: [0,1],[0,2]
// Ergibt die TGF-Datei:
// 1
// 2
// #
// 0 1
// 0 2
public class GraphTGF {
    public GraphTGF() {
	
    }

    // Mache eine TGF-Datei des Graphen, gegeben eine
    // Nachbarschaftsliste.
    public String macheGepheiTGF(Nachbarschaftsliste nl) {
	StringBuilder sb = new StringBuilder();

	// Zuerst drucken wir alle die Knoten.
	
	for (int i = 0; i < nl.n.size(); i++) {
	    sb.append(i);
	    sb.append("\n");
	}

 	// Zunächst drucken wir die Grenze zwischen Knoten und Kanten.
	sb.append("#\n");

	// Zunächst drucken wir alle die Kanten.
	
	for (int i = 0; i < nl.n.size(); i++) {
	    // sbKnoten: Die Kanten eines einzelnen Knoten
	    StringBuilder sbKnoten = new StringBuilder();
	    for (int j = 0; j < nl.n.get(i).size(); j++) {
		sbKnoten.append(i);
		sbKnoten.append(" ");
		sbKnoten.append(nl.n.get(i).get(j));
		sbKnoten.append("\n");
	    }

	    if (sbKnoten.length() > 0) {
		sb.append(sbKnoten.toString());
	    }
	}

	return sb.toString();
    }

    // Mache eine CSV-Datei des Graphen, gegeben eine
    // Nachbarschaftsmatrix.
    public String macheGepheiTGF(Nachbarschaftsmatrix n) {
	StringBuilder sb = new StringBuilder();

	// Zuerst drucken wir alle die Knoten.
	for (int i = 0; i < n.n.length; i++) {
	    sb.append(i);
	    sb.append("\n");
	}
	
	// Zunächst drucken wir die Grenze zwischen Knoten und Kanten.
	sb.append("#\n");

	// Zunächst drucken wir alle die Kanten.

	for (int i = 0; i < n.n.length; i++) {
	    // String für einen Knoten
	    StringBuilder sbKnoten = new StringBuilder();
	    for (int j = 0; j < n.n.length; j++) {
		if (n.n[i][j] == true) {
		    sbKnoten.append(i);
		    sbKnoten.append(" ");
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
