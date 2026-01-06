package strecke;

import punkt.Dreipunkt;

// Eine Dreistrecke ist ein Paar von zwei Dreipunkten.
//
// Eine Dreistrecke ist eine dreidimensionale Strecke.
//
// Eine Strecke hat verschiedene Anwendungen.
//
// Häufig benutzt ist eine Strecke als Strecke eines Körpers.
public class Dreistrecke {
    public Dreipunkt von;
    public Dreipunkt bis;
    
    public Dreistrecke(Dreipunkt v, Dreipunkt b) {
	this.von = v;
	this.bis = b;
    }

    public void addieren(Dreipunkt p) {
	this.von.addieren(p);
	this.bis.addieren(p);
    }
}
