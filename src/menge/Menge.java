package menge;

import java.util.HashSet;

// Funktionen an Mengen
public class Menge {

    // Gegeben eine Menge von ganzen Zahlen, gib eine int[] Liste ab.
    // z.B.: ein:
    // {0,1,2,5,6}
    // aus:
    // [0,1,2,5,6]
    //
    // n.b. die ursprüngliche Menge hat keine Reihenfolge
    public static int[] nehmeArrayVonMenge(HashSet<Integer> s) {
	int[] array = new int[s.size()];

	int i = 0;
	for (Integer intInS : s) {
	    array[i] = intInS;
	    i++;
	}

	return array;
    }
}
