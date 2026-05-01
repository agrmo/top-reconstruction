package sicht.vektor.drei;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Dreivektor;
import welt.vektor.Dreivektorwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vektor.drei.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	Dreivektor[] v = new Dreivektor[] {
	    new Dreivektor(30,50,20)
	};
	Dreivektor[] o = new Dreivektor[] {
	    new Dreivektor(20, 20, 20)
	};
	Dreivektorwelt dvw = new Dreivektorwelt(v, o);

	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	double brennweite = 500;
	Dreivektor entfernung = new Dreivektor(0,0,200);
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Dreivektorsicht s = new Dreivektorsicht(dvw,
						entfernung,
						brennweite,
						breite, hoehe,
						winkeleins,
						winkelzwei,
						winkeldrei);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);	
    }

    public static void main(String[] args){
	beispieleins();
    }
}
