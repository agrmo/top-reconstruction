package abbildung;

import java.util.HashMap;

// Die mathematische Abbildung.
public class Abbildung {

    // Gegeben eine Map<Integer,Integer>, geben eine int[][] ab.
    // z.B.: ein:
    // 0: 5
    // 1: 2
    // aus:
    // [[0,5],[1,2]]
    public static int[][] nehmeArrayArrayVonAbbildung(HashMap<Integer,Integer> m) {
	int[][] arrayarray = new int[m.size()][];

	int i = 0;
	for (Integer schluessel : m.keySet()) {
	    arrayarray[i] = new int[] {schluessel, m.get(schluessel)};
	    i++;
	}

	return arrayarray;
    }
}
