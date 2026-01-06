package sicht.dreipunkt;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import welt.koerper.Koerperwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.dreipunkt.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Daten.
	Kubus k = new Kubus(2);
	Dreipunkt[] dpl = k.nehmeEcken();

	// Mache die Sicht.
	int breite = 1200;
	int hoehe = 600;
	Dreipunkt ap = new Dreipunkt(0,0,10);
	Dreipunktsicht dps = new Dreipunktsicht(dpl, ap, 500, breite, hoehe, 0.0, 0.3, 0.0);
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(breite, hoehe);
	frame.add(dps);
	frame.setVisible(true);
    }
}
