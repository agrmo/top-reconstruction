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
	double thetaroll = Math.atan(vc.drei / vc.eins);
	double thetanick = Math.atan(vc.drei / vc.zwei);
	double thetagier = Math.atan(vc.eins / vc.zwei);

	System.out.println("Roll: " + thetaroll); // 0.6155509032954322
	System.out.println("Nick: " + thetanick); // 0.7853981633974483
	System.out.println("Gier: " + thetagier); // 0.9552454234994644
	
	// Die Nick und Gierwinkel sind nicht die ursprünglichen
	// Winkel, die den Vektor zuerst gedreht haben.

	// Was sind die wesentlichen Drehungen, um den Vektor
	// [0.707,0.5,0.5] zurück zu [1,0,0] zu drehen?

	// 
    }

    static void beispielSieben() {
	// Man versucht, den Vektor [0,1,1] zurück zum [1,0,0] zu drehen.
    }
    
    public static void main(String[] args) {
	beispielSechs();
    }
}
