package sicht.vielflach.straff;

import javax.swing.JFrame;
import vektor.Zweivektor;
import strecke.Zweistrecke;
import welt.zweistrecke.Zweistreckewelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.straff.Main
*/

public class Main {

    static void beispielEins() {
	// Mache die Welt.
	Zweistrecke zka = new Zweistrecke(new Zweivektor(0,100),
				      new Zweivektor(100,100));

	Zweistrecke zkb = new Zweistrecke(new Zweivektor(100,200),
				      new Zweivektor(200,200));
	
	Zweistrecke[] zsl = new Zweistrecke[] {zka, zkb};
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	// Der Verleger vergrößert die stellen der Strecken. Nicht nur
	// wird den Abstand zwischen den Vektoren vergrößert, sondern
	// auch den Abstand zum Ursprung. Zum Beispiel,
	//
	// (0,0) --- (10,0) --- (20,0)
	// werden nach
	// (0,0) ------ (20,0) ------ (40,0)
	// verschoben.
	//
	// Die Zahlen sind die wesentliche Eigenschaften, die wir
	// brauchen, um die dreidimensionale Daten in einem
	// zweidimensionalen Bildschirm darzustellen.
	//
	// kw: Die ursprüngliche dreidimensionale Daten
	// 2.0 1.0: Die Zahlen, die der straffe Verleger benutzt
	//   2.0: Multipliziere alle x Stellen mit 2.0
	//   1.0: Multipliziere alle y Stellen mit 1.0
	//
	Straffsicht s = new Straffsicht(zkw, 2.0, 1.0);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
    
    public static void main(String[] args){
	beispielEins();
    }
}

