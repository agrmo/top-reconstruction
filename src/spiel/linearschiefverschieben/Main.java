package spiel.linearschiefverschieben;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punkt.Dreipunkt;
import koerper.Koerper;
import sicht.linearschief.Linearschiefsicht;
import welt.koerper.Koerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.linearschiefverschieben.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Mache die Sicht.
	double a = 1.0;
	double mx = 1.0;
	double bx = 0.0;
	double my = 1.0;
	double by = 0.0;
	Linearschiefsicht lss = new Linearschiefsicht(kw,
						      a,
						      mx, bx, my, by);
	
	// Mache das Spiel.
	Linearschiefverschiebenspiel s = new Linearschiefverschiebenspiel(lss,
									  kw);

	// Mache die Handlungen.
	SpielHandlung sh = new SpielHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize(1200, 600);
	frame.add(lss);
	frame.addKeyListener(sh);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.setVisible(true);	
    }
}
