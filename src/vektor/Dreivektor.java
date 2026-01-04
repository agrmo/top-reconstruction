package vektor;

/*
  Ein Dreivektor ist eine Liste von drei ganzen Zahlen.
  
  Ein Dreivektor im Euklidraum.

  (Wie berechne ich Dreivektoren im Minkowskiraum?)

 */
public class Dreivektor {
    public int eins;
    public int zwei;
    public int drei;

    // ein: ganze Zahl, ganze Zahl, ganze Zahl
    public Dreivektor(int e, int z, int d) {
	this.eins = e;
	this.zwei = z;
	this.drei = d;
    }

    // ein:
    // v: Dreivektor
    // Addiere den gegebenen Dreivektor zu diesem.  
    public void addiere(Dreivektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
	this.drei += v.drei;
    }

    // ein: Dreivektor
    // Subtrahiere den gegebenen Dreivektor zu diesem.  
    public void subtrahiere(Dreivektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
	this.drei -= v.drei;
    }

    // ein: Dreivektor
    // Dividiere den gegebenen Dreivektor zu diesem.  
    public void dividiere(Dreivektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
	this.drei = this.drei / v.drei;
    }

    // ein: Dreivektor
    // Multipliziere ganz den gegebenen Dreivektor zu diesem.  
    public void multipliziere(Dreivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
	this.drei = this.drei * v.drei;
    }
    
    // ein: Dreivektor
    // Multipliziere teilweise den gegebenen Dreivektor zu diesem.  
    public void punkt(Dreivektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
	this.drei = this.drei * v.drei;
    }
}
