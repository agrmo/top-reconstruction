package swing;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Main {
    public static void main(String[] args){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JButton button = new JButton("Drucken Sie mir!");
	frame.add(button);
	frame.setSize(300, 300);	
	frame.setVisible(true);
    }
}

