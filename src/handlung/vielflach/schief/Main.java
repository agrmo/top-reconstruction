package handlung.vielflach.schief;

import java.awt.Color;
import javax.swing.JFrame;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import sicht.vielflach.linearschief.Linearschiefsicht;
import welt.vielflach.Vielflachwelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.vielflach.schief.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	Vielflach[] vl = new Vielflach[] {k};
	Dreivektor[] ol = new Dreivektor[] {p};
	Vielflachwelt vw = new Vielflachwelt(vl, ol);

	// Mache die Sicht.
	double a = 0.3;
	double mx = 1.0;
	double bx = 0.0;
	double my = 1.0;
	double by = 0.0;
	Linearschiefsicht lss = new Linearschiefsicht(vw,
						      a,
						      mx, bx, my, by);
	Maler m = new Maler(new Sicht[] {lss});
	
	// Mache die Handlung.
	Schiefhandlung h = new Schiefhandlung(m, lss, vw);
	
	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.addKeyListener(h);
	frame.addMouseListener(h);
	frame.addMouseMotionListener(h);
	frame.setVisible(true);	
    }
}
