package spiel.vielflach.basis;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.vielflach.basis.Vielflachbasissicht;
import sicht.vielflach.basis.Vielflachbasistextsicht;
import vektor.Dreivektor;
import vektor.Zweivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.vielflach.basis.Main
*/

public class Main {
    static void beispielEins() {
	// Hier ist die Lösung des Problems, das wir im Giernickspiel
	// gefunden hatten. Eine Drehung mit der Mouse nach einem
	// Kopfstehen des Kubus fällt uns unrichtig. Die Lösung ist
	// die Bearbeitung zweier Matrizen. Die erste Matrix is die
	// vorherige Matrix. Die zweite Matrix is die jetzige
	// Matrix. Die Mouse dreht die zweite Matrix. Nach die Lösung
	// der Mouse multiplizieren wir die zwei Matrizen, speichern
	// diese Matrix als vorherige, und erneuen die zweite Matrix.
	
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
	Vielflachbasissicht vbs = new Vielflachbasissicht(vw, ap, 500, breite, hoehe);
	Vielflachbasistextsicht vbts = new Vielflachbasistextsicht(vbs);

	Maler m = new Maler(new Sicht[] {vbs, vbts});
	
	// Mache das Spiel.
	Vielflachbasisspiel s = new Vielflachbasisspiel(m, vbs, vw);

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

    static void beispielZwei() {
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
	Vielflachbasissicht vbs = new Vielflachbasissicht(vw, ap, 500, breite, hoehe);

	Maler m = new Maler(new Sicht[] {vbs});
	
	// Mache das Spiel.
	Vielflachbasisspiel s = new Vielflachbasisspiel(m, vbs, vw);

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
    
    public static void main(String[] args) {
	beispielEins();
    }
}
