package verleger.linear;

import java.util.ArrayList;
import kante.Zweikante;
import punkt.Zweipunkt;
import welt.kante.Zweikantewelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes verleger.linear.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine einfache Welt mit zwei Kanten.
	Zweikante zka = new Zweikante(new Zweipunkt(30,30),
				      new Zweipunkt(500,500));

	Zweikante zkb = new Zweikante(new Zweipunkt(200,20),
				      new Zweipunkt(500,100));
	
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	zkl.add(zka);
	zkl.add(zkb);

	// Mache die zweidimensionale Kantenwelt.
	Zweikantewelt zkw = new Zweikantewelt(zkl);

	// Der Verleger, der die Welt linear umwandelt.
	Linearverleger lv = new Linearverleger(1.0, 1.0, 1.0, 1.0);
	
	// Wir brauchen nicht, eine ganze neue Zweikantewelt zu
	// machen. Die ursprüngliche ist inhaltlich verarbeitet.
	lv.verlegenWelt(zkw);
    }
}
