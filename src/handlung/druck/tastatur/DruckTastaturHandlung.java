package handlung.druck.tastatur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Nur zu drucken.
public class DruckTastaturHandlung implements KeyListener {

    public void keyTyped(KeyEvent e) {
        drucke("Getastet: ", e);
    }
     
    public void keyPressed(KeyEvent e) {
        drucke("Tastendruck: ", e);
    }
     
    public void keyReleased(KeyEvent e) {
        drucke("Tastenfreisetzung: ", e);
    }

    void drucke(String keyStatus, KeyEvent e) {
	
        int id = e.getID();
        String keyString;
	
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
		+ " (" + KeyEvent.getKeyText(keyCode) + ")";
	        }
         
        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
	
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }
         
        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }
         
        String locationString = "key location: ";
        int location = e.getKeyLocation();
	
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else {
            locationString += "unknown";
        }
         
        System.out.println(keyStatus + "\n"
			   + "    " + keyString + "\n"
			   + "    " + modString + "\n"
			   + "    " + actionString + "\n"
			   + "    " + locationString + "\n");	
    }
}
