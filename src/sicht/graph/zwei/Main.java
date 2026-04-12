package sicht.graph.zwei;

import java.awt.Color;
import javax.swing.JFrame;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;
import maler.Maler;
import sicht.Sicht;
import welt.graph.Zweigraphwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.graph.zwei.Main
*/

public class Main {

    static void beispieleins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);

	// Die Orten.
        Zweivektor[] orten = {
	    new Zweivektor(10,10),
	    new Zweivektor(50,50),
	    new Zweivektor(100,40)
	};

	Zweigraphwelt zgw = new Zweigraphwelt(nl, orten);
	Zweigraphsicht zgs = new Zweigraphsicht(zgw);
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
	beispieleins();
    }
}
