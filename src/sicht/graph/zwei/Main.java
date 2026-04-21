package sicht.graph.zwei;

import java.awt.Color;
import javax.swing.JFrame;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;
import maler.Maler;
import sicht.Sicht;
import welt.graph.Zweigraphwelt;
import welt.graph.zufaellig.Zufaelligzweigraphwelt;
import graph.zufalls.Zufallsgraph;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.graph.zwei.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	int[][] paare = {{1,2},{2,0}};
        int groesse = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, groesse);
	
        Zweivektor[] orte = {
	    new Zweivektor(10,10),
	    new Zweivektor(50,50),
	    new Zweivektor(100,40)
	};
	Zweigraphwelt zgw = new Zweigraphwelt(nl, orte);

	// Mache die Sicht.
	double durchmesser = 20;
	Zweigraphsicht zgs = new Zweigraphsicht(zgw, durchmesser);
	Maler m = new Maler(new Sicht[] {zgs});
  
        // Stellen die Daten dar.
        JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.add(m);
        frame.setVisible(true);
    }

    static void beispielzwei() {
	// Mache die Welt.
        int groesse = 100;
	double p = 0.01;
        Nachbarschaftsliste nl = Zufallsgraph.mache(groesse, p);
	int xmin = 10;
	int xmax = 500;
	int ymin = 10;
	int ymax = 500;
        Zweivektor[] orte = Zufaelligzweigraphwelt.mache(groesse,
							 xmin, xmax,
							 ymin, ymax);
	Zweigraphwelt zgw = new Zweigraphwelt(nl, orte);

	// Mache die Sicht.
	double durchmesser = 20;
	Zweigraphsicht zgs = new Zweigraphsicht(zgw, durchmesser);
	Maler m = new Maler(new Sicht[] {zgs});
  
        // Stellen die Daten dar.
        JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.add(m);
        frame.setVisible(true);
    }

    public static void main(String[] args){
	beispielzwei();
    }
}
