package welt.vektor;
    
import vektor.Dreivektor;
import java.util.ArrayList;
import koerper.Koerper;

/*
  Wie sieht man die räumliche Sammlung einer Menge von Körpern, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß er den ganzen Körper gut kennen können, unabhängig
  von ihre Farbe und Beschaffenheit.

  Ein gutes Gerät zur Sammlung von Ecken und Kanten sind
  Vektoren. Bestimmen wir den Ort eines Vektors, und der Vektor zeigt
  die Richtung und Ausbreitung einer Kanten. Es gibt keinen „Körper"
  dieser Welt. Eine Vektorwelt besitzt nur eine Reihe von Vektoren,
  die sie darstellen können.

  Die Vektorwelt zeigt uns NICHT, WIE SIE AUSSIEHT!
*/
public class Vektorwelt {
    ArrayList<Koerper> koerperliste;
    ArrayList<Dreivektor> dreivektorliste;

    public Vektorwelt(ArrayList<Koerper> kl,
		      ArrayList<Dreivektor> dl) {
	this.koerperliste = kl;
	this.dreivektorliste = dl;
    }
}
