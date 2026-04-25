package sicht.vielflach.linearschief;

import javax.swing.JFrame;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import welt.vielflach.Vielflachwelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.linearschief.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100, 100, 100);
	Vielflach[] vl = new Vielflach[] {k};
	Dreivektor[] ol = new Dreivektor[] {p};
	Vielflachwelt welt = new Vielflachwelt(vl, ol);

	// Der Verleger vergrößert die stellen der Kanten. Nicht nur
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
	// welt: Die ursprüngliche dreidimensionale Daten
	// 1.0: Die Zahl, die der schiefe Verleger benutzt
	// 2.0 0.0 1.0 0.0: Die Zahlen, die der lineare Verleger benutzt
	//   2.0: Multipliziere alle x Stellen mit 2.0
	//   0.0: Addiere 0.0 zu alle x Stellen
	//   1.0: Multipliziere alle y Stellen mit 1.0
	//   0.0: Addiere 0.0 zu alle y Stellen
	//
	Linearschiefsicht s = new Linearschiefsicht(welt,
						    0.1,
						    2.0, 0.0, 1.0, 0.0);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Welt dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args){
	beispieleins();
    }
}

