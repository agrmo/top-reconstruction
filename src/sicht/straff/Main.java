package sicht.straff;

import java.util.ArrayList;
import javax.swing.JFrame;
import punkt.Zweipunkt;
import kante.Zweikante;
import welt.zweikante.Zweikantewelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.straff.Main
*/

public class Main {

    static void beispielEins() {
	// Mache die Welt.
	Zweikante zka = new Zweikante(new Zweipunkt(0,100),
				      new Zweipunkt(100,100));

	Zweikante zkb = new Zweikante(new Zweipunkt(100,200),
				      new Zweipunkt(200,200));
	
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	zkl.add(zka);
	zkl.add(zkb);
	Zweikantewelt zkw = new Zweikantewelt(zkl);

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
	// 2.0 1.0: Die Zahlen, die der straffe Verleger benutzt
	//   2.0: Multipliziere alle x Stellen mit 2.0
	//   1.0: Multipliziere alle y Stellen mit 1.0
	//
	Straffsicht ss = new Straffsicht(zkw, 2.0, 1.0);
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(ss);
	frame.setVisible(true);
    }

    static void beispielZwei() {
	// Mache die Welt.
	Zweikante zka = new Zweikante(new Zweipunkt(0,100),
				      new Zweipunkt(100,100));

	Zweikante zkb = new Zweikante(new Zweipunkt(100,200),
				      new Zweipunkt(200,200));
	
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	zkl.add(zka);
	zkl.add(zkb);
	Zweikantewelt zkw = new Zweikantewelt(zkl);

	Straffsicht ss = new Straffsicht(zkw, 1.0, 1.0);
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(ss);
	frame.setVisible(true);
    }
    
    public static void main(String[] args){
	beispielZwei();
    }
}

