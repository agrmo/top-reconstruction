package welt.punktkoerper;
    
import vektor.Vektor;
import java.util.ArrayList;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punktkoerper.Punktkoerper;

/*
  Eine Punktkoerperwelt ist eine Liste von Punktkörper.
  
  Die Punktkoerperwelt zeigt uns die Stellen verschiedener Körper.

  Die Punktkoerperwelt ist eine Verbindung zwischen Körpern und Orten eines
  Koordinatensystems.
  
  Wie sieht man die räumliche Sammlung einer Menge von Körpern, deren
  Inhalten nicht wichtig sind, sondern ihre Ecken und Orten?

  Man soll nur die Ecken und Verbindungen zwischen den Ecken
  darstellen, sodaß er den ganzen Körper gut kennen können, unabhängig
  von ihre Farbe oder Beschaffenheit.

  Ein gutes Gerät zur Sammlung von Ecken und Kanten sind
  Vektoren. Bestimmen wir den Ort eines Vektors, und der Vektor zeigt
  die Richtung und Ausbreitung einer Kanten. Es gibt keinen „Körper"
  dieser Welt. Eine Punktkoerperwelt besitzt nur eine Reihe von Vektoren,
  die sie darstellen können.

  Die Punktkoerperwelt zeigt uns nicht, wie sie aussieht!
*/
public class Punktkoerperwelt {
    ArrayList<Punktkoerper> euklidkoerperliste;

    // Wir sind mit eine Reihe von Körpern gegeben. Ein Körper kennt
    // nur seine Eigenschaften. Die Punktkoerperwelt versteht nicht nur
    // seine Eigenschaften, sondern auch wo er steht und in welche
    // Ausrichtung er zeigt.
    public Punktkoerperwelt(ArrayList<Punktkoerper> ekl) {
	this.punktkoerperliste = ekl;
    }
}
