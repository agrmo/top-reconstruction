package handlung.vielflach.giernick;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import vektor.Dreivektor;
import sicht.vielflach.giernick.Giernicksicht;
import welt.vielflach.Vielflachwelt;
import handlung.Handlung;
import maler.Maler;

// Das Giernickhandlung benuzt zur Drehung nur zwei Winkel: einen in der
// Gier-Richtung und einen in der Nick-Richtung. Das funktioniert
// richtig gut am Anfang. Das Problem ist nach einer Drehung. Nach
// einer Drehung sind die Gier und Nick-Achsen anders als am
// Anfang. Deshalb sieht die Drehungen nachdem nicht richtig aus.
public class Giernickhandlung extends Handlung {

    Maler m;
    Giernicksicht gs;
    Vielflachwelt vw;
    int mouseanfangx;
    int mouseanfangy;
    double gieranfang;
    double nickanfang;

    public Giernickhandlung(Maler m,
			    Giernicksicht gs,
			    Vielflachwelt vw) {
	this.m = m;
	this.gs = gs;
	this.vw = vw;
    }
    
    public void mousePressed(MouseEvent me) {
	this.mouseanfangx = me.getX();
	this.mouseanfangy = me.getY();

	this.gieranfang = this.gs.gier;
	this.nickanfang = this.gs.nick;
    }
    
    public void mouseDragged(MouseEvent me) {
	int jetztx = me.getX();
	int jetzty = me.getY();
	int unterschiedx = jetztx - this.mouseanfangx;
	int unterschiedy = jetzty - this.mouseanfangy;
	double gierunterschied = ((double) unterschiedx) / this.gs.breite;
	double nickunterschied = ((double) unterschiedy) / this.gs.hoehe;

	this.gs.gier = this.gieranfang + gierunterschied;
	this.gs.nick = this.nickanfang + nickunterschied;
	
	this.m.repaint();
    }
}
