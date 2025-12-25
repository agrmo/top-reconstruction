package vektor;

/*
  Ein Vektor ist eine Liste von drei ganzen Zahlen.
  
  Ein Vektor im Euklidraum.

  (Wie berechne ich Vektoren im Minkowskiraum?)
 */
public class Vektor {
    public int eins;
    public int zwei;
    public int drei;

    // ein:
    // eins: ganze Zahl
    // zwei: ganze Zahl
    // drei: ganze Zahl
    public Vektor(int eins, int zwei, int drei) {
	this.eins = eins;
	this.zwei = zwei;
	this.drei = drei;
    }

    // ein:
    // v: Vektor
    // Addiere den gegebenen Vektor zu diesem.  
    public void addiere(Vektor v) {
	this.eins += v.eins;
	this.zwei += v.zwei;
	this.drei += v.drei;
    }

    // ein:
    // v: Vektor
    // Subtrahiere den gegebenen Vektor zu diesem.  
    public void subtrahiere(Vektor v) {
	this.eins -= v.eins;
	this.zwei -= v.zwei;
	this.drei -= v.drei;
    }

    // ein:
    // v: Vektor
    // Dividiere den gegebenen Vektor zu diesem.  
    public void dividiere(Vektor v) {
	this.eins = this.eins / v.eins;
	this.zwei = this.zwei / v.zwei;
	this.drei = this.drei / v.drei;
    }

    // v: Vektor
    // Multipliziere ganz den gegebenen Vektor zu diesem.  
    public void multipliziere(Vektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
	this.drei = this.drei * v.drei;
    }
    
    // v: Vektor
    // Multipliziere teilweise den gegebenen Vektor zu diesem.  
    public void punkt(Vektor v) {
	this.eins = this.eins * v.eins;
	this.zwei = this.zwei * v.zwei;
	this.drei = this.drei * v.drei;
    }

    public String drucken() {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(this.eins);
	sb.append(",");
	sb.append(this.zwei);
	sb.append(",");
	sb.append(this.drei);
	sb.append("]");
	return sb.toString();
    }
}
