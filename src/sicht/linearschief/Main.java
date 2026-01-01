package sicht.linearschief;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import welt.koerper.Koerperwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.linearschief.Main
*/

public class Main {
    
    public static void main(String[] args){

	// Mache die Welt.
	Kubus k = new Kubus(10);
	Dreipunkt p = new Dreipunkt(20,20,20);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Der Verleger vergrößert die stellen der Kanten. Nicht nur
	// wird den Abstand zwischen den Punkten vergrößert, sondern
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
	// 1.0: Die Zahl, die der schiefe Verleger benutzt
	// 2.0 0.0 1.0 0.0: Die Zahlen, die der lineare Verleger benutzt
	//   2.0: Multipliziere alle x Stellen mit 2.0
	//   0.0: Addiere 0.0 zu alle x Stellen
	//   1.0: Multipliziere alle y Stellen mit 1.0
	//   0.0: Addiere 0.0 zu alle y Stellen
	//
	Linearschiefsicht lss = new Linearschiefsicht(kw,
						      1.0,
						      2.0, 0.0, 1.0, 0.0);
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(lss);
	frame.setVisible(true);
    }
}

