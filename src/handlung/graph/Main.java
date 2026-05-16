package handlung.graph;

import auge.Auge;
import graph.Nachbarschaftsliste;
import graph.zufalls.Zufallsgraph;
import handlung.auge.Augehandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.graph.drei.Dreigraphsicht;
import vektor.Dreivektor;
import welt.graph.Dreigraphwelt;
import welt.graph.zufalls.Zufallsdreigraphwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.graph.Main
*/

public class Main {
    static void beispieleins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	// Die Orten.
        Dreivektor[] orten = {
	    new Dreivektor(-10,20,10),
	    new Dreivektor(-20,-20,-10),
	    new Dreivektor(20,-10,10)
	};

	// Mache die Welt.
	Dreigraphwelt dgw = new Dreigraphwelt(nl, orten);

	// Mache die Sicht.
	
	// Wir brauchen nicht, eine bestimmte Klasse für die Handlung
	// des Graphen zu bauen, wie z.B. eine "Graphhandlung."
	// Sondern wir brauchen nur eine Augehandlung, weil wir nur
	// die Eigenschaften der Augen verändern wollen.
	double durchmesser = 20;
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor entfernung = new Dreivektor(0,0,100);
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	Dreigraphsicht ds = new Dreigraphsicht(dgw, durchmesser, auge);
	Maler m = new Maler(new Sicht[] {ds});
	
	// Mache die Handlung.
	Augehandlung handlung = new Augehandlung(m, auge);

	// Fangen die Handlung an.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(handlung);
	frame.setVisible(true);
    }

    static void beispielzwei() {
	// Mache die Welt.
        int groesse = 200;
	double p = 0.005;
        Nachbarschaftsliste nl = Zufallsgraph.mache(groesse, p);
	int xmin = -100;
	int xmax = 100;
	int ymin = -100;
	int ymax = 100;
	int zmin = -100;
	int zmax = 100;
        Dreivektor[] orte = Zufallsdreigraphwelt.mache(groesse,
						       xmin, xmax,
						       ymin, ymax,
						       zmin, zmax);
	Dreigraphwelt dgw = new Dreigraphwelt(nl, orte);

	// Mache die Sicht.
	double durchmesser = 20;
	Dreivektor entfernung = new Dreivektor(0,0,300);
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	double brennweite = 500;
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	Dreigraphsicht ds = new Dreigraphsicht(dgw, durchmesser, auge);
	Maler m = new Maler(new Sicht[] {ds});
	
	// Mache die Handlung.
	Augehandlung handlung = new Augehandlung(m, auge);

	// Fangen die Handlung an.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(handlung);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	beispielzwei();
    }
}
