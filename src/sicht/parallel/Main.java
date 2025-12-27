package sicht.parallel;

import javax.swing.JFrame;
import graph.Nachbarschaftsliste;
import welt.graph.Graphwelt;
import welt.graph.macher.gitter.Gitter;
import vektor.Vektor;
import welt.punktkoerper.Punktkoerperwelt;
import punktkoerper.Punktkoerper;
import koerper.kubus.Kubus;
import punkt.Punkt;
import java.util.ArrayList;
import punktkoerper.kubus.Punktkubus;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes sicht.parallel.Main
*/

public class Main {

    public static void main(String[] args){
 	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	Vektor d = new Vektor(0,0,-1);
	int mu = 1;

	// Mache eine Punktkörperwelt.
	Kubus k = new Kubus(50);
	Punkt p = new Punkt(100,100,100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);
	
	// Mache eine Parallelsicht.
	Parallelsicht ps = new Parallelsicht(d, mu, pkw);

	// Geben wir die Sicht zu Java, um darzustellen.
	frame.add(ps);
	frame.setVisible(true);
    }
}

