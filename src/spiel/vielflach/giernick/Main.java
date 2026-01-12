package spiel.vielflach.giernick;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.vielflach.giernick.Giernicksicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.vielflach.giernick.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Ein Spiel, in dem wir einen Kubus drehen können. Eigenlich
	// gibt es hier ein Problem. Sobald wir den Kubus auf dem Kopf
	// stehen, ist es nicht mehr möglich, die Mouse richtig in der
	// Gier-Achse zu drehen. Die Mouse geht rechts, und der Kubus
	// geht links. Problem!
	//
	// Eine mögliche Lösung dafur ist, daß wir die Basisvektoren
	// wiederaufstehen sollen, sofort nach jeder Drehung des
	// Kubus. Hier gibt es keine Lösung. Die Lösung ist das
	// "Basismousespiel."
	
	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(60));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(-30,-30,-30));
	Vielflachwelt kw = new Vielflachwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0, 0, 100);
	Giernicksicht gs = new Giernicksicht(kw, ap, 500, breite, hoehe, 0.0, 0.0);
	Maler m = new Maler(new Sicht[] {gs});
	
	// Mache das Spiel.
	Giernickspiel s = new Giernickspiel(m, gs, kw);

	// Mache die Handlung.
	SpielHandlung sh = new SpielHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.setVisible(true);	
    }
}
