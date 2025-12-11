package graph;

public class Main {
    public static void main(String[] args) {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, betrag);	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
    }
}
