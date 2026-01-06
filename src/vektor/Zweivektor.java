package vektor;

/*
  Ein Zweivektor ist eine Liste von zwei ganzen Zahlen.
  
  Ein Zweivektor im Euklidraum.

  (Wie berechne ich Zweivektoren im Minkowskiraum?)

  Was ist der Unterschied zweischen der Zweivektor und der Zweipunkt?

  Der Zweipunkt steht immer im euklidischem Raum, dessen Basis gleich
  mit der Welt ist. Der Zweivektor kann eine andere Basis besitzen,
  sodaß seine Teile in anderen Richtungen zeigen können.

  Zum Beispiel die Ecke enthält Dreivektoren, um ihre Strecke zu zeigen.
 */
public class Zweivektor {
    public int eins;
    public int zwei;

    // ein: ganze Zahl, ganze Zahl
    public Zweivektor(int e, int z) {
	this.eins = e;
	this.zwei = z;
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
