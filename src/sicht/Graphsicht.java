package sicht;

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;

import welt.graph.Graphwelt;

// import java.awt.Stroke;
// import java.awt.BasicStroke;
// import java.awt.Paint;
// import java.awt.Rectangle;
// import java.awt.Graphics2D;
// import java.awt.image.BufferedImage;
// import java.awt.Container;

/*
  Ein Zweibild ist eine zweidimensionale Darstellung von etwas.
  Wir können es unmittelbar zu Java eintragen, um zu darstellen.
*/

/*
  Unser Sicht stellt uns einen Graph dar.
*/
public class Graphsicht extends JComponent {
    public Graphwelt gw;

    public Graphsicht(Graphwelt g) {
	gw = g;
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	g.setColor(Color.BLACK);

	// Nehme an, wie groß ein Knoten ist.
	int groese = 20;
	
	// Stelle die Knoten dar.
	for (int i = 0; i < this.gw.nachbarschaftsliste.betrag; i++) {
	    g.fillOval(this.gw.orten[i][0], this.gw.orten[i][1], groese, groese);
	}

	// Stelle die Kanten dar.
	for (int i = 0; i < this.gw.nachbarschaftsliste.betrag; i++) {
	    // Wo dieser Knoten ist.
	    int vonX = this.gw.orten[i][0];
	    int vonY = this.gw.orten[i][1];

	    // Stelle die Kanten dieses Knoten dar.
	    // Wir brauchen nicht eine verdoppelte Nachbarschaftsliste.
	    for (int j = 0; j < this.gw.nachbarschaftsliste.n.get(i).size(); j++) {

		// Wer der Knoten ist, dem dieser Knoten verbunden ist.
		int bisKnoten = this.gw.nachbarschaftsliste.n.get(i).get(j);
		    
		int bisX = this.gw.orten[bisKnoten][0];
		int bisY = this.gw.orten[bisKnoten][1];
		
		g.drawLine(vonX, vonY, bisX, bisY);
	    }
	}
    }

    // g.setColor(Color.BLACK);
    // g.fillOval(90, 20, 50, 50);

    // public void darstelle() {
    // 	JFrame frame = new JFrame();
    // 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 	frame.setSize(300, 300);
    // 	frame.setVisible(true);
    // }

    // public void darstelleZwei() {
    // 	BufferedImage img = new BufferedImage(100, 10, BufferedImage.TYPE_INT_ARGB);
    // 	Graphics2D graphics = img.createGraphics();
    // 	Color color = new Color(50,50,50);
    // 	Stroke stroke = new BasicStroke(1f);
    // 	graphics.setPaint(color);
    // 	graphics.fill(new Rectangle(0,0,100,10));	
    // }
    
}
