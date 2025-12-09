package liste;

import java.util.ArrayList;

// Funktionen an Listen.
public class Liste {

    public Liste() {
	
    }

    // Gegeben eine ArrayList<int[]>, geben ein int[][] ab.
    public int[][] nehmeArrayListArray(ArrayList<int[]> l) {
	int[][] arrayarray = new int[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    int[] zeile = l.get(i);
	    arrayarray[i] = zeile;
	}

	return arrayarray;
    }

    // Gegeben eine ArrayList<ArrayList<Integer>>, geben eine int[][] ab.
    public int[][] nehmeArrayListArrayList(ArrayList<ArrayList<Integer>> l) {
	int[][] arrayarray = new int[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    ArrayList<Integer> zeile = l.get(i);
	    int[] zeileArray = new int[zeile.size()];
	    int j = 0;
		
	    for (Integer n : zeile) {
		zeileArray[j++] = n;
	    }

	    arrayarray[i] = zeileArray;
	}

	return arrayarray;	
    }
}
