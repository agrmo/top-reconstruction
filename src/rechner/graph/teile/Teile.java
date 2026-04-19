package rechner.graph.teile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import graph.Nachbarschaftsliste;
import graph.Doppelnachbarschaftsliste;
import rechner.graph.tiefensuche.Tiefensuche;
import liste.Liste;

public class Teile {

    // Wie viele Teile leben im Graph?
    // z.B.
    // Der Graph ist
    // 0: []
    // 1: []
    // 2: [3]
    // 3: [4]
    // 4: []
    // 5: [6]
    // 6: []
    // Es gibt 2 Knoten, die allein stehen. Also es gibt 2 1-Teile.
    // Es gibt 2 Knoten, die in einer Gruppe stehen. Es gibt 1 2-Teile.
    // Es gibt 3 Knoten, die in einer Gruppe stehen. Es gibt 1 3-Teile.    
    // aus:
    // [[1,2],[2,1],[3,1]]
    public static int[][] teile(Doppelnachbarschaftsliste dnl) {

	// Gedanke:
	// 1. Leere Abbildung t, die zeigt, wie viele Teile mit einem
	//    bestimmten Anzahl von Knoten leben.
	// 2. Nehme einen Knoten kn, der nicht schon gesehen ist.
	// 3. Finde alle die Knoten, die zu ihm verbunden sind. Diese
	//    Knoten bilden einen Teil.
	// 4. Zähle die Anzahl des Teils in t.
	// 5. Zurück zum 2, bis es keinen neuen Knoten gibt.
	// 6. Gib t ab.

	// Die Antwort.
	// Wie viele Teile mit einer bestimmten Anzahl von Knoten leben.
	// z.B.
	// 1: 3
	// 2: 5
	//
	// Es gibt 3 Knoten, die allein stehen. Es gibt 5 Knoten, die
	// in einem Paar stehen. Die Antwort wird in dieser Abbildung
	// aufgebaut.
	HashMap<Integer,Integer> teile = new HashMap<Integer,Integer>();

	// Knoten, die schon gesehen sind. Diese Knoten stehen schon
	// in einem Teil.
	HashSet<Integer> schonGesehen = new HashSet<Integer>();

	// Knoten, die nicht gesehen sind. Diese Knoten werden
	// zunächst ausgewählt. Es ist NICHT WICHTIG und UNBEKANNT, in
	// welcher Ordnung die Knoten ausgewählt werden.
	HashSet<Integer> nichtGesehen = new HashSet<Integer>();

	// Fangen wir mit dem Verfahren an.

	for (int i = 0; i < dnl.betrag; i++) {
	    nichtGesehen.add(i);
	}

	Tiefensuche t = new Tiefensuche();

	// Ein Tiefensuche-Verfahren nimmt an, daß der Graph
	// verdoppelt ist.

	while (nichtGesehen.size() > 0) {
	    // Nehme nur einen neuen Knoten, der nicht gesehen ist.
	    // Benutzen wir zwei Mengen von Knoten, weil es schneller
	    // ist.

	    Iterator<Integer> nichtGesehenListe = nichtGesehen.iterator();
	    int naechsterKnoten = nichtGesehenListe.next();
		
	    // Mit diesem Knoten fangen wir an, einen Teil
	    // aufzuzählen.  Dieser Knoten konnte ganz allein
	    // sein. Also er wird nur eine 1-Teil geben.  Dieser
	    // Knoten konnte mit 100 anderen Knoten verbunden sein,
	    // einschileßlich mit Schleifen. Das wäre ein 100-Teil,
	    // die wir einfach aufzählen werden. Tun wir das, bis wir
	    // keinen neuen Knoten finden kann.

	    int[] naechsterteil = t.tiefensuche(dnl, naechsterKnoten);

	    // Wir haben eine Menge von Knoten gefunden. Setzen die in
	    // der gesehenen Menge ein, sodaß wir nicht diesen Teil
	    // ein zweites Mal durchsuchen werden. (naechsterTeil
	    // enthält auch den Anfangsknoten.)

	    for (int teilknoten : naechsterteil) {
		schonGesehen.add(teilknoten);
		nichtGesehen.remove(teilknoten);
	    }

	    // Wir haben einen Teil gefunden, der eine bestimmte
	    // Anzahl von Knoten enthält. Zähle diese Zahl in "a"
	    // auf. Die Zahl heißt in dieser Weise
	    // Teilbetrag. z.B. dieser Teil konnte 10 Knoten
	    // enthalten, also die Zahl 10 in der Abbildung wird
	    // erhöht:
	    //
	    // 10: 8 -> 10: 9
	    //
	    // Er konnte der erste 10-Teil sein. Prüfen das auch.

	    int teilbetrag = naechsterteil.length;

	    if (!teile.containsKey(teilbetrag)) {

		// Dieser Teil ist der erste, der teilbetrag-Zahl von
		// Knoten enthält. Zähle eine Eins auf.
		teile.put(teilbetrag, 1);
		
	    } else {

		// Dieser teil ist nicht der erste, der
		// teilbetrag-Zahl von Knoten enthält. Nimm die Anzahl
		// zu.
		int vorherigerBetrag = teile.get(teilbetrag);
		teile.put(teilbetrag, vorherigerBetrag + 1);
		
	    }

	    // Fertig mit diesem Teil. Löschen die Liste, wir brauchen
	    // sie nicht mehr.
	}

	// Fertig mit dem Verfahren. Es gibt keinen neuen Knoten.

	Liste l = new Liste();
	int[][] teileArrayArray = l.nehmeArrayArrayVonAbbildung(teile);
	
	return teileArrayArray;
    }

    // Eine einfache Funktion, nur den höchsten Teil von der
    // Teileverteilung zu nehmen. Also das antwortet die Frage: wie
    // groß ist der größte Teil gieses Graphen? Nicht sehr
    // aufwandfrei, aber hilfreich.
    public static int groessterTeil(Doppelnachbarschaftsliste dnl) {
	int[][] t = teile(dnl);

	int groesste = 0;
	
	for (int[] tAufzaehlung : t) {
	    if (tAufzaehlung[0] > groesste) {
		groesste = tAufzaehlung[0];
	    }
	}

	return groesste;
    }
}
