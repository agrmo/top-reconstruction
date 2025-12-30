package spiel.linearschief;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import sicht.linearschief.Linearschiefsicht;
import welt.punktkoerper.Punktkoerperwelt;
import handlung.spiel.SpielMouseHandlung;
import handlung.spiel.SpielTastaturHandlung;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.linearschief.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Mache die Sicht.
	double a = 1.0;
	double mx = 1.0;
	double bx = 0.0;
	double my = 1.0;
	double by = 0.0;
	Linearschiefsicht lss = new Linearschiefsicht(pkw,
						     a,
						     mx, bx, my, by);
	

	// Mache das Spiel.
	Linearschiefspiel s = new Linearschiefspiel(lss);

	// Mache die Handlungen.
	SpielMouseHandlung mh = new SpielMouseHandlung(s);
	SpielTastaturHandlung th = new SpielTastaturHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.add(lss);
	frame.addKeyListener(th);
	frame.addMouseListener(mh);
	frame.setVisible(true);	
    }
}
