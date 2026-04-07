package dreher.vektor;

import vektor.Zweivektor;
import vektor.Dreivektor;
import druck.vektor.Vektordrucker;
import dreher.vektor.Vektordreher;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes dreher.vektor.Main
*/

public class Main {
    static void beispielEins() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,0);
	Zweivektor pb = Vektordreher.drehen(pa, Math.PI / 2.0);

	// Soll [0,1] sein.
	System.out.println(Vektordrucker.drucken(pb));
    }

    static void beispielZwei() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,1);
	Zweivektor pb = Vektordreher.drehen(pa, Math.PI / 2.0);

	// Soll [-1,1] sein.
	System.out.println(Vektordrucker.drucken(pb));
    }

    static void beispielDrei() {
	Dreivektor pa = new Dreivektor(1,1,1);
	
	Dreivektor pb = Vektordreher.drehenY(pa, Math.PI);

	// Soll [-1,1,-1] sein
	System.out.println(Vektordrucker.drucken(pb));	
    }

    static void beispielVier() {
	Dreivektor pa = new Dreivektor(1,1,1);
	
	Dreivektor pb = Vektordreher.drehenY(pa, Math.PI);
	Dreivektor pc = Vektordreher.drehenX(pb, Math.PI);

	// Soll [-1,-1,1] sein
	System.out.println(Vektordrucker.drucken(pc));
    }

    static void beispielFuenf() {
	// Man dreht den Vektor [1,0,0] zweimal: mit einem Gierwinkel
	// und nachdem mit einem Nickwinkel.
	Dreivektor va = new Dreivektor(1,0,0);
	Dreivektor vb = Vektordreher.drehenZ(va, Math.PI / 4.0);
	Dreivektor vc = Vektordreher.drehenX(vb, Math.PI / 4.0);
	
	// Man dreht den Vektor [1,0,0] zweimal: mit einem Nickwinkel
	// und nachdem mit einem Gierwinkel.
	Dreivektor vd = new Dreivektor(1,0,0);
	Dreivektor ve = Vektordreher.drehenX(vd, Math.PI / 4.0);
	Dreivektor vf = Vektordreher.drehenZ(ve, Math.PI / 4.0);

	// Ist die Drehung erst mit dem Gierwinkel gleich die Drehung
	// erst mit dem Nickwinkel?
	StringBuilder sb = new StringBuilder();
	sb.append(Vektordrucker.drucken(va));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucken(vb));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucken(vc));
	sb.append("\n");
	sb.append(Vektordrucker.drucken(vd));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucken(ve));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucken(vf));
	
	System.out.println(sb.toString());
	// Nein.
    }

    static void beispielSechs() {
	/*
	  Versuche den endgültigen Vektor zurück zum Ursprung zu drehen.
	  Der Vektor vc wurde gemacht von
	  
	  Dreivektor va = new Dreivektor(1,0,0);
	  Dreivektor vb = Vektordreher.drehenZ(va, Math.PI / 4.0); Gier
	  Dreivektor vc = Vektordreher.drehenX(vb, Math.PI / 4.0); Nick

	  Also vc = [0.707,0.5,0.5].
	*/
	
	Dreivektor vc = new Dreivektor(0.707,0.5,0.5);

	// Der Winkel um die x-Achse.
	double thetax = Math.atan(vc.drei / vc.zwei);
	// Der Winkel um die y-Achse.
	double thetay = Math.atan(vc.drei / vc.eins);
	// Der Winkel um die z-Achse.
	double thetaz = Math.atan(vc.eins / vc.zwei);

	System.out.println("Um X: " + thetax); // 0.7853981633974483
	System.out.println("Um Y: " + thetay); // 0.6155509032954322
	System.out.println("Um Z: " + thetaz); // 0.9552454234994644
	
	// Die Winkel sind nicht die ursprünglichen Winkel, die den
	// Vektor zuerst gedreht haben.

	// Was sind die wesentlichen Drehungen, um den Vektor
	// [0.707,0.5,0.5] zurück zu [1,0,0] zu drehen?

	// Zuerst drehe den Winkel um die yz-Fläche zu der xy-Fläche.
	// Zuzweit drehe den Winkel um die xy-Fläche zu [1,0,0].

	double thetayz = Math.atan(vc.drei / vc.zwei);
	System.out.println(thetayz); // 0.78 Rad = 45 Grad

	Dreivektor vd = Vektordreher.drehenX(vc, -1 * thetayz);
	System.out.println(Vektordrucker.drucken(vd)); // [0.707,0.707,0]

	double thetaxy = Math.atan(vd.zwei / vd.eins);
	System.out.println(thetaxy); // 0.78 Rad = 45 Grad

	Dreivektor ve = Vektordreher.drehenZ(vd, -1 * thetaxy);
	System.out.println(Vektordrucker.drucken(ve)); // [1,0,0]
    }

    static void beispielSieben() {
	// Man versucht, den Vektor [0,1,1] zurück zum [1,0,0] zu drehen.
    }
    
    public static void main(String[] args) {
	beispielSechs();
    }
}
