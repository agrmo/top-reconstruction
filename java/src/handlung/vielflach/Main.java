package handlung.vielflach;

import auge.Auge;
import handlung.auge.Augehandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import maler.Maler;
import orientierung.Orientierung;
import sicht.Sicht;
import sicht.vielflach.Vielflachsicht;
import stellung.Dreistellung;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.vielflach.Main;
*/

public class Main {
    static void beispieleins() {
	// Mache die Welt.
	Vielflach[] vl = new Vielflach[] {new Kubus(60)};
	Dreistellung[] sl = new Dreistellung[] {
	    new Dreistellung(new Dreivektor(-30,-30,-30),
			     new Orientierung(0,0,0))
	};
	Vielflachwelt vw = new Vielflachwelt(vl, sl);
	
	// Mache die Sicht.

	// Wir brauchen nicht, eine bestimmte Klasse für die Handlung
	// der Vielflache zu bauen, wie z.B. eine "Vielflachhandlung."
	// Sondern wir brauchen nur eine Augehandlung, weil wir nur
	// die Eigenschaften der Augen verändern wollen.
	Dreivektor entfernung = new Dreivektor(0,0,100);
	double brennweite = 500;
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	double winkeleins = 0;
	double winkelzwei = 0;
	double winkeldrei = 0;
	Auge auge = new Auge(entfernung, brennweite,
			     breite, hoehe,
			     winkeleins,
			     winkelzwei,
			     winkeldrei);
	Vielflachsicht vs = new Vielflachsicht(vw, auge);
	Maler m = new Maler(new Sicht[] {vs});
	
	// Mache die Handlung.
	Augehandlung handlung = new Augehandlung(m, auge);

	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(handlung);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
