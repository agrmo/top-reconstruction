package matrix;

import vektor.Zweivektor;

// Eine 2x2 Matrix.
public class Zweimatrix {
    
    public double a;
    public double b;
    public double c;	
    public double d;

    public Zweimatrix(double a, double b, double c, double d) {
	this.a = a;
	this.b = b;
	this.c = c;	
	this.d = d;
    }

    public Zweivektor[] zeilen() {
	return new Zweivektor[] {
	    new Zweivektor(this.a, this.b),
	    new Zweivektor(this.c, this.d)
	};
    }
    

    public Zweivektor[] kolonnen() {
	return new Zweivektor[] {
	    new Zweivektor(this.a, this.c),
	    new Zweivektor(this.b, this.d)
	};
    }

    public void addiere(Zweimatrix m) {
	this.a += m.a;
	this.b += m.b;
	this.c += m.c;	
	this.d += m.d;
    }

    public void subtrahiere(Zweimatrix m) {
	this.a -= m.a;
	this.b -= m.b;
	this.c -= m.c;	
	this.d -= m.d;
    }

    /*
      Multipliziere diese 2x2 Matrix mit dem 2x1 Vektor v.

      |ab|   |e|  = ein Zweivektor   
      |cd| * |f|  

     */
    public Zweivektor punkt(Zweivektor v) {
	
	return new Zweivektor(this.a * v.eins + this.b * v.zwei,
			      this.c * v.eins + this.d * v.zwei);
    }

    /* Multipliziere diese 2x2 Matrix mit dem 2x2 Matrix m.

       |ab|   |ef| = eine 2x2 Matrix
       |cd| * |gh| 
       
     */
    public Zweimatrix punkt(Zweimatrix m) {

	return new Zweimatrix(this.a * m.a + this.b * m.c, this.a * m.b + this.b * m.d,
			      this.c * m.a + this.d * m.c, this.c * m.b + this.d * m.d);
    }
}
