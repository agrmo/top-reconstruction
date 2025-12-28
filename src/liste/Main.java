package liste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
javac -d classes $(find src -name '*.java') && java -cp classes liste.Main
*/

public class Main {

    public static void listeInteger() {
	Liste l = new Liste();
	
	// drucken eine Liste von Liste von ganzen Zahlen...
	ArrayList<int[]> a = new ArrayList<int[]>();
	a.add(new int[] {1,2});
	int[][] aArray = l.nehmeArrayListArrayInteger(a);
	for (int[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}

	// drucken eine Liste von Liste von ganzen Zahlen...
	ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> bZeile = new ArrayList<Integer>();
	bZeile.add(1);
	bZeile.add(2);
	b.add(bZeile);
	int[][] paarearray = l.nehmeArrayListArrayListInteger(b);
	for (int[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}	
    }

    public static void listeDouble() {
	Liste l = new Liste();
	
	// drucken eine Liste von Liste von Double...
	ArrayList<double[]> a = new ArrayList<double[]>();
	a.add(new double[] {1.53,2.371});
	double[][] aArray = l.nehmeArrayListArrayDouble(a);
	for (double[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}

	// drucken eine Liste von Liste von Double...
	ArrayList<ArrayList<Double>> b = new ArrayList<ArrayList<Double>>();
	ArrayList<Double> bZeile = new ArrayList<Double>();
	bZeile.add(1.9851);
	bZeile.add(2.27461);
	b.add(bZeile);
	double[][] paarearray = l.nehmeArrayListArrayListDouble(b);
	for (double[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}	
    }

    public static void arrayArrayAbbildung() {
	// Benutzen die Funktion nehmeArrayArrayVonAbbildung

	HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	m.put(1,6);
	m.put(5,2);

	Liste l = new Liste();
	int[][] arrayarray = l.nehmeArrayArrayVonAbbildung(m);
	String arrayarrayString = l.nehmeStringVonArrayArray(arrayarray);
	System.out.println(arrayarrayString);
    }

    public static void beispielEins() {
	HashSet<Integer> s = new HashSet<Integer>();
	s.add(1);
	s.add(2);
	s.add(5);
	s.add(6);

	Liste l = new Liste();
	int[] a = l.nehmeArrayVonMenge(s);
	System.out.println(Arrays.toString(a));
    }

    public static void beispielZwei() {
	Liste l = new Liste();
	double[][] doubleArrayArray = new double[2][];
	doubleArrayArray[0] = new double[] {0.01,0.25};
	doubleArrayArray[1] = new double[] {0.6,0.9};
	String doubleArrayArrayString = l.nehmeStringVonArrayArrayDouble(doubleArrayArray);
	System.out.println(doubleArrayArrayString);	
    }
    
    public static void main(String[] args) {

	// listeInteger();	
	// und noch mal für Double	
	// listeDouble();
	
	// arrayArrayAbbildung();

	beispielZwei();
    }
}
