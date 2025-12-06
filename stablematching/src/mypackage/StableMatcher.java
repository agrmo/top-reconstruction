package mypackage;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/*
  Ein Mann ist eine ganze Zahl
  Eine Frau ist eine ganze Zahl

  Eine Mann-Vorliebe ist eine Abbildung von
  Mann zu einer Liste von Frauen

  Eine Frau-Vorliebe ist eine Abbildung von
  Frau zu einer Liste von Männer

  Ein Paar ist ein Tupel von (Mann, Frau)
  Eine Verlobung ist eine Liste von Paare

 */

public class StableMatcher {
    private Map<Integer,List<Integer>> mannVorliebe;
    private Map<Integer,List<Integer>> frauVorliebe;
    private Map<Integer,Set<Integer>> vorschlaege;
    private List<List<Integer>> verlobung;
    
    public StableMatcher(Map<Integer,List<Integer>> m,
			 Map<Integer,List<Integer>> f) {
	mannVorliebe = m;
	frauVorliebe = f;
    }

    // Für jede Mann, nehme den Mann.
    // Laufen durch jede mögliche Frau.
    // Gibt es eine Frau, die er nicht ein Paar vorgeschlagen hat?
    private boolean nichtAlleVorgeschlagen() {
	
	for (int mann : mannVorliebe.keySet()) {
	    // Frauen, die er vorliebt.
	    List<Integer> frauen = mannVorliebe.get(mann);

	    if (vorschlaege.keySet().contains(mann)) {
		// Der Mann hat mindestens eine Frau schon
		// vorgeschlagen.  Frauen, die er vorgeschlagen hat.
		Set<Integer> mannVorschlaege = vorschlaege.get(mann);

		for (int frau : frauen) {
		    // Hat er nicht schon die Frau vorgeschlagen?
		    if (!mannVorschlaege.contains(frau)) {
			return true;
		    }
		}
	    } else {
		// Der Mann hat bereits keine Frau vorgeschlagen.
		vorschlaege.put(mann, new HashSet<Integer>());
		return true;
	    }
 	}
	
	return false;
    }

    // Nehme den Mann, der nicht alle Frauen vorgeschlagen hat.
    private int mannNichtAlleVorgeschlagen() {
	
	for (int mann : mannVorliebe.keySet()) {
	    // Frauen, die er vorliebt.
	    List<Integer> frauen = mannVorliebe.get(mann);
	    // Frauen, die er vorgeschlagen hat.
	    Set<Integer> mannVorschlaege = vorschlaege.get(mann);
	    
	    for (int frau : frauen) {
		// Hat er nicht schon die Frau vorgeschlagen?
		if (!mannVorschlaege.contains(frau)) {
		    return mann;
		}
	    }
	}

	System.out.println("Problem");
	return 0;
    }

    // Nehme die Frau, die er nicht vorgeschlagen hat, und steht für
    // ihn am liebsten. Wir nehmen an, dass der Mann nicht alle Frauen
    // vorgeschlagen hat.
    private int nehmeBeliebteste(int mann) {
	// Frauen, die er vorliebt.
	List<Integer> frauen = mannVorliebe.get(mann);
	// Frauen, die er vorgeschlagen hat.
	Set<Integer> mannVorschlaege = vorschlaege.get(mann);

	// Die Liste von Frauen steht schon in Ordnung von Liebe.
	for (int frau : frauen) {
	    // Hat er nicht schon die Frau vorgeschlagen?
	    if (!mannVorschlaege.contains(frau)) {
		return frau;
	    }
	}

	System.out.println("Problem");
	return 0;
    }

    // Ist die Frau frei?
    private boolean istFrei(int frau) {
	for (List<Integer> paar : verlobung) {
	    if (paar.get(1) == frau) {
		// Die Frau ist schon in einem Paar.
		return false;
	    }
	}

	// Die Frau ist frei.
	return true;
    }

    // Nehme an, dass die Frau schon in einem Paar steht.
    // Nehme den Mann, mit ihm die Frau steht.
    private int nehmeMannVonFrau(int frau) {
	for (List<Integer> paar : verlobung) {
	    if (paar.get(1) == frau) {
		// Gebe den Mann von der Frau.
		return paar.get(0);
	    }
	}

	System.out.println("Problem");
	return 0;
    }

    // Liebt die Frau den mann m1 mehr als m2 vor?
    public boolean stehtHoeher(int frau, int m1, int m2) {
	// Die Stelle, an der der Mann m1 steht.
	int m1Stelle = frauVorliebe.get(frau).indexOf(m1);
	// Die Stelle, an der der Mann m2 steht.
	int m2Stelle = frauVorliebe.get(frau).indexOf(m2);
	
	return m1Stelle < m2Stelle;    
    }

    // Nehmen das Paar mit der Frau weg, also der vorherige Mann wird
    // frei, und setzen ein neues Paar mit dem neuen Mann ein.
    private void tauschen(int frau, int neuerMann) {
	for (int i = 0; i < verlobung.size(); i++) {
	    List<Integer> paar = verlobung.get(i);
	    if (paar.get(1) == frau) {
		verlobung.set(i, Arrays.asList(neuerMann, frau));
	    }
	}
    }

    public List<List<Integer>> match() {
	verlobung = new ArrayList<List<Integer>>();
	vorschlaege = new HashMap<Integer,Set<Integer>>();

	while (nichtAlleVorgeschlagen()) {
	    int mann = mannNichtAlleVorgeschlagen();
	    int frau = nehmeBeliebteste(mann);
	    System.out.println("Vorschlagen Mann " + mann + " und Frau " + frau);

	    if (istFrei(frau)) {
		// Die Frau ist frei. Mache ein Paar.
		System.out.println("Die Frau " + frau + " ist frei.");
		verlobung.add(Arrays.asList(mann,frau));
		
	    } else {
		System.out.println("Die Frau " + frau + " ist nicht frei.");
		
		// Nehme den Mann, mit ihm sie in einem Paar schon steht.
		int mannInPaar = nehmeMannVonFrau(frau);
		System.out.println("Der Mann, mit ihm sie in einem Paar schon steht ist " + mannInPaar);

		// Steht der Mann höher als der Mann im Paar?
		// Falls ja, tauchen die Männer.
		if (stehtHoeher(frau, mann, mannInPaar)) {
		    System.out.println("Der Mann " + mann + " steht höher. Tauschen.");
		    tauschen(frau, mann);
		}
	    }

	    // Der Mann ist fertig, um einen Antrag mit dieser Frau vorzuschlagen.
	    // Addieren sie zu die Frauen, die er schon vorgeschlagen hat.
	    Set<Integer> frauVorschlaege = vorschlaege.get(mann);
	    frauVorschlaege.add(frau);
	    vorschlaege.put(mann, frauVorschlaege);

	    System.out.println("Verlobung ist " + verlobung);
	    System.out.println("Vorschlag fertig. Vorschlag ist " + vorschlaege);
	}
	
	return verlobung;
    }
}
