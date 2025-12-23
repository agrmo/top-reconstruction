package vektor;

public class Main {
    public static void main(String[] args) {
	Dreivektor va = new Dreivektor(1,2,3);
	Dreivektor vb = new Dreivektor(1,1,1);
	va.addiere(vb);

	System.out.println(va.x);
	System.out.println(va.y);
	System.out.println(va.z);
    }
}
