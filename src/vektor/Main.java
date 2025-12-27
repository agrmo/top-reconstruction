package vektor;

/*
  javac -d classes src/vektor/* && java -cp classes vektor.Main
*/

public class Main {
    static void beispielEins() {
	Dreivektor va = new Dreivektor(1,2,3);
	Dreivektor vb = new Dreivektor(1,1,1);
	va.addiere(vb);

	System.out.println(va.drucken());
	System.out.println(vb.drucken());

	vb.punkt(new Dreivektor(0,5,0));
	
	System.out.println(vb.drucken());
    }
    
    static void beispielZwei() {
	Zweivektor va = new Zweivektor(1,2);
	Zweivektor vb = new Zweivektor(1,1);
	va.addiere(vb);
	System.out.println(va.drucken());
	System.out.println(vb.drucken());
	va.punkt(new Zweivektor(0,5));
	System.out.println(va.drucken());
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
