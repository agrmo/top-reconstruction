package sicht.zweipunkt;

import vieleck.quadrat.Quadrat;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import vielflach.kubus.Kubus;
import maler.Maler;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import sicht.Sicht;
import sicht.zweipunkt.Punktsicht;
import verleger.giernick.Giernickverleger;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.zweipunkt.Main
*/

public class Main {

    static void beispielEins() {
	// Mache die Punkte.
	Quadrat q = new Quadrat(50);
	Zweipunkt[] pl = q.nehmeecken();

	// Mache die Sicht.
	Punktsicht s = new Punktsicht(pl, 10);
	Maler m = new Maler(new Sicht[] {s});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    static void beispielZwei() {
	// Mache die dreidimensionalen Daten.
	Kubus k = new Kubus(2);
	Dreipunkt[] dpl = k.nehmeecken();

	// Verlegen die dreidimensionalen Daten.

	// Mache die Sicht.
	int breite = 1200;
	int hoehe = 600;
	Dreipunkt augepunkt = new Dreipunkt(0,0,10);
	int brennweite = 500;
	double gier = 0.0;
	double nick = 0.3;
	Zweipunkt[] zpl = Giernickverleger.verlegen(dpl, augepunkt, brennweite,
						breite, hoehe,
						gier, nick);
	int radius = 10;
	Punktsicht s = new Punktsicht(zpl, radius);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args){
	beispielZwei();
    }
}

