package sicht.kante;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import vektor.Dreivektor;
import verleger.linear.Linearverleger;
import verleger.schief.Schiefverleger;
import welt.kante.Zweikantewelt;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -name '*.java')	\
  && java -cp classes sicht.kante.Main
*/

public class Main {

    static void beispielEins() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	// Mache die Punktkörperwelt.
	Kubus k = new Kubus(10);
	Dreipunkt p = new Dreipunkt(20,20,20);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Mache den Verleger.
	Dreivektor d = new Dreivektor(1,1,-1);
	Schiefverleger sv = new Schiefverleger(pkw, d);

	// Mache die zweidimensionale Kantenwelt.
	Zweikantewelt zkw = sv.verlegenWelt();
	
	// Mache eine Kantesicht.
	Kantesicht ks = new Kantesicht(zkw);

	// Geben wir die Sicht zu Java, um darzustellen.
	frame.add(ks);
	frame.setVisible(true);
    }

    static void beispielZwei() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	
	// Mache die Welt.
	Kubus k = new Kubus(10);
	Dreipunkt p = new Dreipunkt(20,20,20);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Mache den Verleger, der eine zweidimensionale Welt aufbauen
	// wird.
	Dreivektor d = new Dreivektor(1,1,-1);
	Schiefverleger sv = new Schiefverleger(pkw, d);
	
	// Benutzen den Verleger.
	Zweikantewelt zkw = sv.verlegenWelt();

	// Der Verleger wird die stellen der Kanten vergrößern. Nicht
	// nur wird den Abstand zwischen den Punkten vergrößert,
	// sondern auch den Abstand zum Ursprung. Zum Beispiel,
	//
	// (0,0) --- (10,0) --- (20,0)
	// werden nach
	// (0,0) ------ (20,0) ------ (40,0)
	// verschoben.
	//
	Linearverleger lv = new Linearverleger(zkw, 2.0, 300.0, 2.0, 300.0);
	lv.verlegenWelt();

	// Mache eine Kantesicht.
	Kantesicht ks = new Kantesicht(zkw);

	// Geben wir die Sicht zu Java, um darzustellen.
	frame.add(ks);
	frame.setVisible(true);
    }

    public static void main(String[] args){
 	beispielZwei();
    }
}

