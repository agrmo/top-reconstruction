package sicht.leer;

import javax.swing.JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes sicht.leer.Main
*/

public class Main {

    public static void main(String[] args){
 	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	frame.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
		    System.out.println("Press");
		}
	    });

	frame.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("Drag");
            }
        });
	
	frame.setVisible(true);
    }
}

