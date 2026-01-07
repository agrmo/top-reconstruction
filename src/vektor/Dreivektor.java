package vektor;

/*
  Ein Dreivektor ist eine Liste von drei ganzen Zahlen.
  
  Ein Dreivektor im Euklidraum.

  (Wie berechne ich Dreivektoren im Minkowskiraum?)
 */
public class Dreivektor {
    public int xteil;
    public int yteil;
    public int zteil;

    // ein: ganze Zahl, ganze Zahl, ganze Zahl
    public Dreivektor(int x, int y, int z) {
	this.xteil = x;
	this.yteil = y;
	this.zteil = z;
    }

    // ein:
    // v: Dreivektor
    // Addiere den gegebenen Dreivektor zu diesem.  
    public void addiere(Dreivektor v) {
	this.xteil += v.xteil;
	this.yteil += v.yteil;
	this.zteil += v.zteil;
    }

    // ein: Dreivektor
    // Subtrahiere den gegebenen Dreivektor zu diesem.  
    public void subtrahiere(Dreivektor v) {
	this.xteil -= v.xteil;
	this.yteil -= v.yteil;
	this.zteil -= v.zteil;
    }

    // ein: Dreivektor
    // Dividiere den gegebenen Dreivektor zu diesem.  
    public void dividiere(Dreivektor v) {
	this.xteil = this.xteil / v.xteil;
	this.yteil = this.yteil / v.yteil;
	this.zteil = this.zteil / v.zteil;
    }

    // ein: Dreivektor
    // Multipliziere ganz den gegebenen Dreivektor zu diesem.  
    public void multipliziere(Dreivektor v) {
	this.xteil = this.xteil * v.xteil;
	this.yteil = this.yteil * v.yteil;
	this.zteil = this.zteil * v.zteil;
    }
    
    // ein: Dreivektor
    // Multipliziere teilweise den gegebenen Dreivektor zu diesem.  
    public void punkt(Dreivektor v) {
	this.xteil = this.xteil * v.xteil;
	this.yteil = this.yteil * v.yteil;
	this.zteil = this.zteil * v.zteil;
    }
}
