package spiel.vielflach.augemouse;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import maler.Maler;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import sicht.Sicht;
import sicht.auge.Augesicht;
import sicht.text.Textsicht;
import sicht.text.augetext.Augetextsicht;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.vielflach.augemouse.Main
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
	// Kubus. Hier gibt es keine Lösung.
	
	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(60));
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(new Dreipunkt(-30,-30,-30));
	Vielflachwelt kw = new Vielflachwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	int breite = (int) bildschirm.getWidth();
	int hoehe = (int) bildschirm.getHeight();
	Dreipunkt ap = new Dreipunkt(0, 0, 100);
	Augesicht as = new Augesicht(kw, ap, 500, breite, hoehe, 0.0, 0.0, 0.0);

	Augetextsicht ats = new Augetextsicht(as);
	Maler m = new Maler(new Sicht[] {as, ats});
	
	// Mache das Spiel.
	Augemousespiel s = new Augemousespiel(m, as, kw);

	// Mache die Handlung.
	SpielHandlung sh = new SpielHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.setVisible(true);	
    }
}
