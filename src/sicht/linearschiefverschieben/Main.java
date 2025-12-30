package sicht.linearschiefverschieben;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import welt.kante.Zweikantewelt;
import punkt.Dreipunkt;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.linearschiefverschieben.Main
*/

public class Main {
    
    public static void main(String[] args){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	
	// Mache die Welt.
	Kubus k = new Kubus(10);
	Dreipunkt p = new Dreipunkt(0,0,0);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);


	// Der Verschiebenpunkt.
	Dreipunkt verschiebenpunkt = new Dreipunkt(10,10,0);
	
	Linearschiefverschiebensicht zs = new Linearschiefverschiebensicht(pkw,
									   1.0,
									   1.0, 0.0, 1.0, 0.0,
									   verschiebenpunkt);
	
	// Stellen die Daten dar.
	frame.add(zs);
	frame.setVisible(true);
    }
}

