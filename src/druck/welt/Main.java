package druck.welt;

import java.util.ArrayList;
import kante.Zweikante;
import koerper.kubus.Kubus;
import punkt.Zweipunkt;
import welt.kante.Zweikantewelt;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes druck.welt.Main
*/

public class Main {
    public static void main(String[] args) {
	Zweikante zka = new Zweikante(new Zweipunkt(30,30),
				      new Zweipunkt(500,500));

	Zweikante zkb = new Zweikante(new Zweipunkt(200,20),
				      new Zweipunkt(500,100));
	
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	zkl.add(zka);
	zkl.add(zkb);

	// Mache die zweidimensionale Kantenwelt.
	Zweikantewelt zkw = new Zweikantewelt(zkl);

	System.out.println(Weltdrucker.drucken(zkw));
    }
}
