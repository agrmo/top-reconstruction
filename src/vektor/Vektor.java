package vektor;

//  Ein Vektor ist eine Liste von drei ganzen Zahlen.  
//  Am meistens steht ein Vektor im Euklidraum. Aber nicht immer.
public class Vektor {
    public int[] teile;

    public Vektor(int[] t) {
	this.teile = t;
    }

    // ein:
    // v: Vektor
    // Addiere den gegebenen Vektor zu diesem.  
    public void addiere(Vektor v) {
	for (int i = 0; i < teile.length; i++) {
	    teile[i] += v.teile[i];
	}
    }

    // ein:
    // v: Vektor
    // Subtrahiere den gegebenen Vektor zu diesem.  
    public void subtrahiere(Vektor v) {
	for (int i = 0; i < teile.length; i++) {
	    this.teile[i] -= v.teile[i];
	}	
    }

    // ein:
    // v: Vektor
    // Dividiere den gegebenen Vektor zu diesem.  
    public void dividiere(Vektor v) {
	for (int i = 0; i < teile.length; i++) {
	    this.teile[i] = this.teile[i] / v.teile[i];
	}	
    }

    // ein:
    // v: Vektor
    // Multipliziere ganz den gegebenen Vektor zu diesem.  
    public void multipliziere(Vektor v, int z) {
	for (int i = 0; i < teile.length; i++) {
	    this.teile[i] = this.teile[i] * z;
	}		
    }
    
    // v: Vektor
    // Multipliziere teilweise den gegebenen Vektor zu diesem.  
    public void punkt(Vektor v) {
	for (int i = 0; i < teile.length; i++) {
	    this.teile[i] = this.teile[i] * v.teile[i];
	}			
    }
}
