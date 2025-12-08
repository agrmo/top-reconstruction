package swing;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
	JFrame frame = new JFrame("Happy Coding");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JButton button = new JButton("Click me!");
	frame.add(button);
	frame.setSize(300, 300);	
	frame.setVisible(true);
    }
}

