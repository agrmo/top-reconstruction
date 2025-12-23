package welt.vektor;

import vektor.Dreivektor;
import koerper.kubus.Kubus;
import java.util.ArrayList;
import koerper.Koerper;

public class Main {
    public static void main(String[] args) {

	// Insgesamt was wir tun ist nur, einen Ort einem Kubus zu
	// zeigen. Solches Beispiel ist nicht so einwandfrei. Wir
	// kennen unsere Raum und Zeit, ohne nachzudenken, wie sie so
	// klar geschehen werden.
	
	Kubus k = new Kubus(50);

	// Der Ort dieses Kubus ist ein Dreivektor.
	Dreivektor d = new Dreivektor(10,10,10);

	// Liste von Koerpern.
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);

	// Liste von Orten.
	ArrayList<Dreivektor> dl = new ArrayList<Dreivektor>();
	dl.add(d);

	// Mache die Welt.
	Vektorwelt vw = new Vektorwelt(kl, dl);
    }
}
