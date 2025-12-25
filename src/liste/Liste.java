package liste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// Funktionen an Listen.
public class Liste {

    public Liste() {
	
    }

    // ein:
    // Arraylist<int[]>
    // aus:
    // int[][]
    //
    // Gegeben eine ArrayList<int[]>, geben ein int[][] ab.
    public int[][] nehmeArrayListArrayInteger(ArrayList<int[]> l) {
	int[][] arrayarray = new int[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    int[] zeile = l.get(i);
	    arrayarray[i] = zeile;
	}

	return arrayarray;
    }

    // ein:
    // ArrayList<ArrayList<Integer>>
    // aus:
    // int[][]
    //
    // Gegeben eine ArrayList<ArrayList<Integer>>, geben eine int[][] ab.
    public int[][] nehmeArrayListArrayListInteger(ArrayList<ArrayList<Integer>> l) {
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

    // und noch mal für double

    // ein:
    // ArrayList<double[]>
    // aus:
    // double[][]
    //
    // Gegeben eine ArrayList<double[]>, geben ein double[][] ab.
    public double[][] nehmeArrayListArrayDouble(ArrayList<double[]> l) {
	double[][] arrayarray = new double[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    double[] zeile = l.get(i);
	    arrayarray[i] = zeile;
	}

	return arrayarray;
    }

    // Gegeben eine ArrayList<ArrayList<Integer>>, geben eine double[][] ab.
    public double[][] nehmeArrayListArrayListDouble(ArrayList<ArrayList<Double>> l) {
	double[][] arrayarray = new double[l.size()][];	
	for (int i = 0; i < l.size(); i++) {
	    ArrayList<Double> zeile = l.get(i);
	    double[] zeileArray = new double[zeile.size()];
	    int j = 0;
		
	    for (Double n : zeile) {
		zeileArray[j++] = n;
	    }

	    arrayarray[i] = zeileArray;
	}

	return arrayarray;	
    }

    // Gegeben ein Array von Array von Integer, mache ein einfaches
    // String dafür. Weiß ich nicht, warum Java diese Funktion nicht
    // schon besitzt.
    public String nehmeStringVonArrayArray(int[][] arrayarray) {
	StringBuilder sb = new StringBuilder();

	sb.append("[");
	for (int i = 0; i < arrayarray.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Arrays.toString(arrayarray[i]));
	}
	sb.append("]");

	return sb.toString();
    }

    // und noch mal für Double

    public String nehmeStringVonArrayArrayDouble(double[][] arrayarray) {
	StringBuilder sb = new StringBuilder();

	sb.append("[");
	for (int i = 0; i < arrayarray.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Arrays.toString(arrayarray[i]));
	}
	sb.append("]");

	return sb.toString();	
    }

    // Gegeben eine Map<Integer,Integer>, geben eine int[][] ab.
    // z.B.: ein:
    // 0: 5
    // 1: 2
    // aus:
    // [[0,5],[1,2]]
    public int[][] nehmeArrayArrayVonAbbildung(HashMap<Integer,Integer> m) {
	int[][] arrayarray = new int[m.size()][];

	int i = 0;
	for (Integer schluessel : m.keySet()) {
	    arrayarray[i] = new int[] {schluessel, m.get(schluessel)};
	    i++;
	}

	return arrayarray;
    }

    // Gegeben eine Menge von ganzen Zahlen, gib eine int[] Liste ab.
    // z.B.: ein:
    // {0,1,2,5,6}
    // aus:
    // [0,1,2,5,6]
    public int[] nehmeArrayVonMenge(HashSet<Integer> s) {
	int[] array = new int[s.size()];

	int i = 0;
	for (Integer intInS : s) {
	    array[i] = intInS;
	    i++;
	}

	return array;
    }
}
