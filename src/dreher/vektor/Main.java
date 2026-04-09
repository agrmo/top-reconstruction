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
	System.out.println(Vektordrucker.drucke(pb));
    }

    static void beispielZwei() {
	// Gegen den Uhrzeigersinn.
	Zweivektor pa = new Zweivektor(1,1);
	Zweivektor pb = Vektordreher.drehen(pa, Math.PI / 2.0);

	// Soll [-1,1] sein.
	System.out.println(Vektordrucker.drucke(pb));
    }

    static void beispielDrei() {
	Dreivektor pa = new Dreivektor(1,1,1);
	
	Dreivektor pb = Vektordreher.drehey(pa, Math.PI);

	// Soll [-1,1,-1] sein
	System.out.println(Vektordrucker.drucke(pb));	
    }

    static void beispielVier() {
	Dreivektor pa = new Dreivektor(1,1,1);
	
	Dreivektor pb = Vektordreher.drehey(pa, Math.PI);
	Dreivektor pc = Vektordreher.drehex(pb, Math.PI);

	// Soll [-1,-1,1] sein
	System.out.println(Vektordrucker.drucke(pc));
    }

    static void beispielFuenf() {
	// Man dreht den Vektor [1,0,0] zweimal: mit einem Gierwinkel
	// und nachdem mit einem Nickwinkel.
	Dreivektor va = new Dreivektor(1,0,0);
	Dreivektor vb = Vektordreher.drehez(va, Math.PI / 4.0);
	Dreivektor vc = Vektordreher.drehex(vb, Math.PI / 4.0);
	
	// Man dreht den Vektor [1,0,0] zweimal: mit einem Nickwinkel
	// und nachdem mit einem Gierwinkel.
	Dreivektor vd = new Dreivektor(1,0,0);
	Dreivektor ve = Vektordreher.drehex(vd, Math.PI / 4.0);
	Dreivektor vf = Vektordreher.drehez(ve, Math.PI / 4.0);

	// Ist die Drehung erst mit dem Gierwinkel gleich die Drehung
	// erst mit dem Nickwinkel?
	StringBuilder sb = new StringBuilder();
	sb.append(Vektordrucker.drucke(va));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucke(vb));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucke(vc));
	sb.append("\n");
	sb.append(Vektordrucker.drucke(vd));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucke(ve));
	sb.append(" -> ");
	sb.append(Vektordrucker.drucke(vf));
	
	System.out.println(sb.toString());
	// Nein.
    }

    static void beispielSechs() {
	/*
	  Versuche den endgültigen Vektor zurück zum Ursprung zu drehen.
	  Der Vektor vc wurde gemacht von
	  
	  Dreivektor va = new Dreivektor(1,0,0);
	  Dreivektor vb = Vektordreher.drehez(va, Math.PI / 4.0); Gier
	  Dreivektor vc = Vektordreher.drehex(vb, Math.PI / 4.0); Nick

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

	Dreivektor vd = Vektordreher.drehex(vc, -1 * thetayz);
	System.out.println(Vektordrucker.drucke(vd)); // [0.707,0.707,0]

	double thetaxy = Math.atan(vd.zwei / vd.eins);
	System.out.println(thetaxy); // 0.78 Rad = 45 Grad

	Dreivektor ve = Vektordreher.drehez(vd, -1 * thetaxy);
	System.out.println(Vektordrucker.drucke(ve)); // [1,0,0]
    }

    static void beispielSieben() {
	
	// Man versucht, zwei Winkel zu berechnen, die eine Drehung
	// der Basis bedeutet. Wir wollen eine neue Basis für den
	// Punkt (70,70,70) berechnen. Mithilfe dieser zwei
	// Drehungwinkel kann irgendein Punkt auf der Linie
	// (0,0,0)-(70,70,70) zu der x-Ache gedreht werden. Das
	// überprüfen wir.

	Dreivektor va = new Dreivektor(70,70,70);

	double thetaeins = Math.atan(va.drei / va.zwei);
	System.out.println(thetaeins); // 0.785 Rad

	Dreivektor vb = Vektordreher.drehex(va, -1 * thetaeins);
	System.out.println(Vektordrucker.drucke(vb));

	// Jetzt liegt der Punkt auf der z=0 Fläche.
	// Drehen den Vektor auf die x-Achse.

	double thetazwei = Math.atan(vb.zwei / vb.eins);
	System.out.println(thetazwei); // 0.955 Rad

	Dreivektor vc = Vektordreher.drehez(vb, -1 * thetazwei);
	System.out.println(Vektordrucker.drucke(vc));

	// Jetzt liegt der Vektor auf der x-Achse. Die y-Teil und
	// z-Teil sind 0, und der x-Teil ist der gesamte Betrag des
	// Vektors.

	// Jetzt prüfen, ob den Punkt (50,50,50) auch auf die x-Achse
	// gelegt werden kann.

	Dreivektor vd = new Dreivektor(50,50,50);
	Dreivektor ve = Vektordreher.drehex(vd, -1 * thetaeins);
	Dreivektor vf = Vektordreher.drehez(ve, -1 * thetazwei);
	System.out.println(Vektordrucker.drucke(vf)); // [86,0,0]

	// Ja. Richtig.
    }

    static void beispielAcht() {
	// Man steht auf dem Punkt [100,100,100].
	// Er versucht, den Vektor [50,50,50] zu sehen.
	// Er sieht solchen Vektor direkt an.
	// Solcher Vektor sieht von seinem Standpunkt wie ein Punkt aus.
	
	// Was sind die zwei wesentlichen Drehungen, um
    }
    
    public static void main(String[] args) {
	beispielSieben();
    }
}
