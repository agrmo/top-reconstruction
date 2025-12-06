package mypackage;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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
    
    public StableMatcher(Map<Integer,List<Integer>> m, Map<Integer,List<Integer>> f) {
	mannVorliebe = m;
	frauVorliebe = f;
    }

    public List<List<Integer>> match() {
	List<List<Integer>> verlobung = new ArrayList<List<Integer>>();
	return verlobung;
    }
}
