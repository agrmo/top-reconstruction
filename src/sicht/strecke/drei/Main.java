package sicht.strecke.drei;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import strecke.Dreistrecke;
import vektor.Dreivektor;
import welt.strecke.drei.Dreistreckewelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.strecke.drei.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	Dreistrecke[] dsl = new Dreistrecke[] {
	    new Dreistrecke(new Dreivektor(-20,20,0),
			    new Dreivektor(20,20,0)),
	    new Dreistrecke(new Dreivektor(20,20,0),
			    new Dreivektor(20,-20,0)),
	    new Dreistrecke(new Dreivektor(20,-20,0),
			    new Dreivektor(-20,-20,0)),
	    new Dreistrecke(new Dreivektor(-20,-20,0),
			    new Dreivektor(-20,20,0))
	};
	
	Dreistreckewelt dsw = new Dreistreckewelt(dsl);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	double brennweite = 500;
	Dreivektor entfernung = new Dreivektor(0,20,70);
	double winkeleins = 0;
	double winkelzwei = 0.5;
	double winkeldrei = 0.2;
	
	Dreistreckesicht s = new Dreistreckesicht(dsw, entfernung,
						  brennweite,
						  breite, hoehe,
						  winkeleins,
						  winkelzwei,
						  winkeldrei);

	// Mache den Maler.
	Maler m = new Maler(new Sicht[] {s});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args){
	beispieleins();
    }
}

