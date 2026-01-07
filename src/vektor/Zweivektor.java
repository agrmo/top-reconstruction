package vektor;

/*
  Ein Zweivektor ist eine Liste von zwei Zahlen.
  
  Ein Zweivektor im Euklidraum.

  Was sind ähnlich mit dem Vektor und dem Punkt?

  Sie besitzen die gleiche Basisvektoren.

  Was ist der Unterschied zweischen der Zweivektor und der Zweipunkt?

  Der zweidimensionale Punkt und der zweidimensionale Vektor besitzen
  verschiedenen Ursprung.

  Zum Beispiel die Ecke enthält Dreivektoren, um ihre Strecke zu zeigen.
 */
public class Zweivektor {
    public int xteil;
    public int yteil;

    // ein: ganze Zahl, ganze Zahl
    public Zweivektor(int x, int y) {
	this.xteil = x;
	this.yteil = y;
    }

    // ein:
    // v: Zweivektor
    // Addiere den gegebenen Zweivektor zu diesem.  
    public void addiere(Zweivektor v) {
	this.xteil += v.xteil;
	this.yteil += v.yteil;
    }

    // ein: Zweivektor
    // Subtrahiere den gegebenen Zweivektor zu diesem.  
    public void subtrahiere(Zweivektor v) {
	this.xteil -= v.xteil;
	this.yteil -= v.yteil;
    }

    // ein: Zweivektor
    // Dividiere den gegebenen Zweivektor zu diesem.  
    public void dividiere(Zweivektor v) {
	this.xteil = this.xteil / v.xteil;
	this.yteil = this.yteil / v.yteil;
    }

    // ein: Zweivektor
    // Multipliziere ganz den gegebenen Zweivektor zu diesem.  
    public void multipliziere(Zweivektor v) {
	this.xteil = this.xteil * v.xteil;
	this.yteil = this.yteil * v.yteil;
    }
    
    // ein: Zweivektor
    // Multipliziere teilweise den gegebenen Zweivektor zu diesem.  
    public void punkt(Zweivektor v) {
	this.xteil = this.xteil * v.xteil;
	this.yteil = this.yteil * v.yteil;
    }
}
