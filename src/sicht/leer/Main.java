package sicht.leer;

import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import handlung.MouseHandlung;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes sicht.leer.Main
*/

public class Main {

    public static void main(String[] args){
 	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	MouseHandlung h = new MouseHandlung();
	frame.addMouseListener(h);

	frame.setVisible(true);
    }
}

