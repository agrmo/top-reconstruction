package vektor;

/*
  Ein Dreivektor ist eine Liste von drei ganzen Zahlen.
  
  Ein Vektor im Euklidraum.

  (Wie berechne ich Vektoren im Minkowskiraum?)
 */
public class Dreivektor {
    public int x;
    public int y;
    public int z;

    // ein:
    // x: ganze Zahl
    // y: ganze Zahl
    // z: ganze Zahl
    public Dreivektor(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    // ein:
    // v: Vektor
    // Addiere den gegebenen Vektor zu diesem.  
    public void addiere(Dreivektor v) {
	this.x += v.x;
	this.y += v.y;
	this.z += v.z;
    }

    // ein:
    // v: Vektor
    // Subtrahiere den gegebenen Vektor zu diesem.  
    public void subtrahiere(Dreivektor v) {
	this.x -= v.x;
	this.y -= v.y;
	this.z -= v.z;
    }

    // ein:
    // v: Vektor
    // Dividiere den gegebenen Vektor zu diesem.  
    public void dividiere(Dreivektor v) {
	this.x = this.x / v.x;
	this.y = this.y / v.y;
	this.z = this.z / v.z;
    }

    // v: Vektor
    // Multipliziere den gegebenen Vektor zu diesem.  
    public void multipliziere(Dreivektor v) {
	this.x = this.x * v.x;
	this.y = this.y * v.y;
	this.z = this.z * v.z;
    }

}
