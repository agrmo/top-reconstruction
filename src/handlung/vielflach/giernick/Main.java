package handlung.vielflach.giernick;

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
  && java -cp classes handlung.vielflach.giernick.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Eine Handlung, in dem wir einen Kubus drehen
	// können. Eigenlich gibt es hier ein Problem. Sobald wir den
	// Kubus auf dem Kopf stehen, ist es nicht mehr möglich, die
	// Mouse richtig in der Gier-Achse zu drehen. Die Mouse geht
	// rechts, und der Kubus geht links. Das Problem ist, daß die
	// Drehung immer die gleiche Basis annimmt.
	//
	// Eine mögliche Lösung dafur ist, daß wir die Basisvektoren
	// wiederaufstehen sollen, sofort nach jeder Drehung des
	// Kubus. Diese Lösung ist in "Vielflachaugehandlung"
	// durchgeführt.
	
	// Mache die Welt.
	ArrayList<Vielflach> vl = new ArrayList<Vielflach>();
	vl.add(new Kubus(60));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(-30,-30,-30));
	Vielflachwelt vw = new Vielflachwelt(vl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0, 0, 100);
	Giernicksicht gs = new Giernicksicht(vw, ap, 500, breite, hoehe, 0.0, 0.0);
	Maler m = new Maler(new Sicht[] {gs});
	
	// Mache die Handlung.
	Giernickhandlung h = new Giernickhandlung(m, gs, vw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addMouseListener(h);
	frame.addMouseMotionListener(h);
	frame.setVisible(true);	
    }
}
