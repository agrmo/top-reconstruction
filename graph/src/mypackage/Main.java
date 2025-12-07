package mypackage;

public class Main {
    public static void main(String[] args) {
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsmatrix n = new Nachbarschaftsmatrix(paare, groese);
	System.out.println(n.drucken());
    }
}
