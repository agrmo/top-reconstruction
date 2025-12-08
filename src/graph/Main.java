package graph;

public class Main {
    public static void main(String[] args) {
	Graphdrucker gd = new Graphdrucker();
	
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, groese);
	System.out.println(gd.drucke(nm));
	System.out.println(nm.hatKante(1,2));
	System.out.println(nm.hatKante(2,1));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
	System.out.println(gd.drucke(nl));
	System.out.println(nl.hatKante(1,2));
	System.out.println(nl.hatKante(2,1));
    }
}
