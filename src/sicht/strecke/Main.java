package sicht.strecke;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import vektor.Zweivektor;
import strecke.Zweistrecke;
import verschieber.Verschieber;
import welt.zweistrecke.Zweistreckewelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.strecke.Main
*/

public class Main {

    static void beispielEins() {
	// Mache die zweidimensionale Streckenwelt.
	Zweistrecke zka = new Zweistrecke(new Zweivektor(30,30),
				      new Zweivektor(500,500));

	Zweistrecke zkb = new Zweistrecke(new Zweivektor(200,20),
				      new Zweivektor(500,100));

	Zweistrecke[] zsl = new Zweistrecke[] {zka, zkb};
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);
	
	// Mache eine Streckesicht.
	Streckesicht s = new Streckesicht(zkw);
	Maler m = new Maler(new Sicht[] {s});

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    static void beispielZwei() {
	// Mache die Welt.
	Zweistrecke zka = new Zweistrecke(new Zweivektor(0,0),
				      new Zweivektor(100,0));

	Zweistrecke zkb = new Zweistrecke(new Zweivektor(200,0),
				      new Zweivektor(300,0));

	Zweistrecke[] zsl = new Zweistrecke[] {zka, zkb};
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);

	// Die Sicht.
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int halbBreite = (int) (screenSize.getWidth() / 2.0);
	int halbHoehe = (int) (screenSize.getHeight() / 2.0);
	
	Zweistreckewelt zkwNeu = Verschieber.verschieben(zkw, halbBreite, halbHoehe);
	    
	Streckesicht s = new Streckesicht(zkwNeu);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args){
	beispielZwei();
    }
}

