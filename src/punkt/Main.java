package punkt;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;

class ShapeDrawing extends JComponent {
    public void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	g2.fillOval(10, 10, 10, 10);
    }
}

public class Main {
    public static void main(String[] args){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 300);

	frame.getContentPane().add(new ShapeDrawing ());
	frame.setVisible(true);	
    }
}

