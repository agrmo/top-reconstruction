package liste;

import java.util.ArrayList;

// Funktionen an Listen.
public class Liste {

    public Liste() {
	
    }

    // Gegeben eine ArrayList<int[]>, geben ein int[][] ab.
    public int[][] nehmeArrayListArrayInteger(ArrayList<int[]> l) {
	int[][] arrayarray = new int[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    int[] zeile = l.get(i);
	    arrayarray[i] = zeile;
	}

	return arrayarray;
    }

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
}
