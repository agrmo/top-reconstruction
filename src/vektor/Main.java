package vektor;

public class Main {
    public static void main(String[] args) {
	Dreivektor va = new Dreivektor(1,2,3);
	Dreivektor vb = new Dreivektor(1,1,1);
	va.addiere(vb);

	System.out.println(va.x);
	System.out.println(va.y);
	System.out.println(va.z);

	vb.punkt(new Dreivektor(0,1,0));
	
	System.out.println(vb.x);
	System.out.println(vb.y);
	System.out.println(vb.z);
    }
}
