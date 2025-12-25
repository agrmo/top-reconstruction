package welt.euklid;
    
import vektor.Vektor;
import java.util.ArrayList;
import koerper.Koerper;
import koerper.kubus.Kubus;
import welt.euklid.koerper.Euklidkoerper;

/*
  Eine Euklidwelt ist eine Liste von Euklidkörper.
  
  Die Euklidwelt zeigt uns die Stellen verschiedener Körper.

  Die Euklidwelt zeigt uns, wo Sachen stehen.

  Sie ist eine Sammlung verschiedener, nicht ganz gewohnten Sachen,
  aber Sachen, die wir sofort verorten können. Mit unseren Augen.

  Die Euklidwelt ist eine Verbindung zwischen Körpern und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Körpern, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß er den ganzen Körper gut kennen können, unabhängig
  von ihre Farbe und Beschaffenheit.

  Ein gutes Gerät zur Sammlung von Ecken und Kanten sind
  Vektoren. Bestimmen wir den Ort eines Vektors, und der Vektor zeigt
  die Richtung und Ausbreitung einer Kanten. Es gibt keinen „Körper"
  dieser Welt. Eine Euklidwelt besitzt nur eine Reihe von Vektoren,
  die sie darstellen können.

  Die Euklidwelt zeigt uns nicht, wie sie aussieht!
*/
public class Euklidwelt {
    ArrayList<Euklidkoerper> euklidkoerperliste;

    // Wir sind mit eine Reihe von Körpern gegeben. Ein Körper kennt
    // nur seine Eigenschaften. Die Euklidwelt versteht nicht nur
    // seine Eigenschaften, sondern auch wo er steht und in welche
    // Ausrichtung er zeigt.
    public Euklidwelt(ArrayList<Euklidkoerper> ekl) {
	this.euklidkoerperliste = ekl;
    }
}
