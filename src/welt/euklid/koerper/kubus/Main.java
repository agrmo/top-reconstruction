package welt.euklid.koerper.kubus;

import welt.euklid.koerper.Euklidkoerper;
import koerper.Koerper;
import koerper.kubus.Kubus;
import vektor.Vektor;

/*
javac -d classes $(find src -name '*.java') \
&& java -cp classes welt.euklid.koerper.kubus.Main
*/

public class Main {
    public static void main(String[] args) {

	Kubus k = new Kubus(50);

	Vektor ort = new Vektor(1,1,1);

	Euklidkubus ek = new Euklidkubus(k, ort);
    }    
}
