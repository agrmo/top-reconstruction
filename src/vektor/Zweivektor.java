package vektor;

/*
  Ein Zweivektor ist eine Liste von zwei ganzen Zahlen.
  
  Ein Zweivektor im Euklidraum.

  (Wie berechne ich Zweivektoren im Minkowskiraum?)
 */
public class Zweivektor {
    public int eins;
    public int zwei;

    // ein: ganze Zahl, ganze Zahl
    public Zweivektor(int eins, int zwei) {
	this.eins = eins;
	this.zwei = zwei;
    }

    // ein:
    // v: Zweivektor
    // Addiere den gegebenen Zweivektor zu diesem.  
    public void addiere(Zweivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
    }

    // ein: Zweivektor
    // Subtrahiere den gegebenen Zweivektor zu diesem.  
    public void subtrahiere(Zweivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
    }

    // ein: Zweivektor
    // Dividiere den gegebenen Zweivektor zu diesem.  
    public void dividiere(Zweivektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
    }

    // ein: Zweivektor
    // Multipliziere ganz den gegebenen Zweivektor zu diesem.  
    public void multipliziere(Zweivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
    }
    
    // ein: Zweivektor
    // Multipliziere teilweise den gegebenen Zweivektor zu diesem.  
    public void punkt(Zweivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
    }
}
