package graph;

/*
  javac src/graph/*.java -d classes && java -cp classes graph.Main
*/

public class Main {
    static void beispieleins() {
	// Mache eine Nachbarschaftsmatrix.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, betrag);	
    }

    static void beispielzwei() {
	// Mache eine Nachbarschaftsliste.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
