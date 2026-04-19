package handlung.vielflach.auge;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.vielflach.auge.Augesicht;
import sicht.vielflach.auge.Augetextsicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.vielflach.auge.Main;
*/

public class Main {
    static void beispieleins() {
	// Hier ist die Lösung des Problems, das wir im Giernickhandlung
	// gefunden hatten. Eine Drehung mit der Mouse nach einem
	// Kopfstehen des Kubus fällt uns unrichtig. Die Lösung ist
	// die Bearbeitung nicht nur einer Matrix, sondern zweier
	// Matrizen. Die erste Matrix is die vorherige Matrix. Die
	// zweite Matrix is die jetzige Matrix. Die Mouse dreht die
	// zweite Matrix. Nach die Lösung der Mouse multiplizieren wir
	// die zwei Matrizen, speichern diese Matrix als vorherige,
	// und erneuen die zweite Matrix.

	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(60));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(-30,-30,-30));
	Vielflachwelt vw = new Vielflachwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(0, 0, 100);
	Augesicht as = new Augesicht(vw, ap, 500, breite, hoehe);

	Maler m = new Maler(new Sicht[] {as});
	
	// Mache die Handlung.
	Vielflachaugehandlung h = new Vielflachaugehandlung(m, as, vw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(h);
	frame.setVisible(true);
    }

    static void beispielzwei() {
	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(30));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(-15,-15,-15));
	Vielflachwelt vw = new Vielflachwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(50,50,0);
	Augesicht as = new Augesicht(vw, ap, 500, breite, hoehe);
	Augetextsicht ats = new Augetextsicht(as);

	Maler m = new Maler(new Sicht[] {as, ats});
	
	// Mache die Handlung.
	Vielflachaugehandlung h = new Vielflachaugehandlung(m, as, vw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(h);
	frame.setVisible(true);
    }

    static void beispieldrei() {
	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(30));
	kl.add(new Kubus(30));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(-15,-15,-15));
	ol.add(new Dreivektor(-15,30,30));
	Vielflachwelt vw = new Vielflachwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	double breite = bildschirm.getWidth();
	double hoehe = bildschirm.getHeight();
	Dreivektor ap = new Dreivektor(50,50,0);
	Augesicht as = new Augesicht(vw, ap, 500, breite, hoehe);
	Augetextsicht ats = new Augetextsicht(as);

	Maler m = new Maler(new Sicht[] {as, ats});
	
	// Mache die Handlung.
	Vielflachaugehandlung h = new Vielflachaugehandlung(m, as, vw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addKeyListener(h);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	beispieldrei();
    }
}
