package sicht.zweipunkt;

import java.util.ArrayList;
import javax.swing.JFrame;
import punkt.Zweipunkt;
import figur.quadrat.Quadrat;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.zweipunkt.Main
*/

public class Main {

    public static void main(String[] args){

	// Mache die Daten.
	Quadrat q = new Quadrat(50);
	Zweipunkt[] pl = q.nehmeEcken();

	// Mache die Sicht.
	Zweipunktsicht ps = new Zweipunktsicht(pl, 10);

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(ps);
	frame.setVisible(true);
    }
}

