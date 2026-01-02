package sicht.kante;

import java.util.ArrayList;
import javax.swing.JFrame;
import welt.zweikante.Zweikantewelt;
import punkt.Zweipunkt;
import kante.Zweikante;
import java.awt.Toolkit;
import java.awt.Dimension;
import verschieber.Verschieber;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.kante.Main
*/

public class Main {

    static void beispielEins() {
	// Mache die zweidimensionale Kantenwelt.
	Zweikante zka = new Zweikante(new Zweipunkt(30,30),
				      new Zweipunkt(500,500));

	Zweikante zkb = new Zweikante(new Zweipunkt(200,20),
				      new Zweipunkt(500,100));
	
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	zkl.add(zka);
	zkl.add(zkb);
	Zweikantewelt zkw = new Zweikantewelt(zkl);
	
	// Mache eine Kantesicht.
	Kantesicht ks = new Kantesicht(zkw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(ks);
	frame.setVisible(true);
    }

    static void beispielZwei() {
	// Mache die Welt.
	Zweikante zka = new Zweikante(new Zweipunkt(0,0),
				      new Zweipunkt(100,0));

	Zweikante zkb = new Zweikante(new Zweipunkt(200,0),
				      new Zweipunkt(300,0));
	
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	zkl.add(zka);
	zkl.add(zkb);
	Zweikantewelt zkw = new Zweikantewelt(zkl);

	// Die Sicht.
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int halbBreite = (int) (screenSize.getWidth() / 2.0);
	int halbHoehe = (int) (screenSize.getHeight() / 2.0);
	
	Zweikantewelt zkwNeu = Verschieber.verschieben(zkw, halbBreite, halbHoehe);
	    
	Kantesicht ss = new Kantesicht(zkwNeu);
	
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

