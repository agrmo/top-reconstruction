package orientierung;

// Eine Orientierung ist ein Triplett von drei Zahlen.
// Sie ist mit der eulerschen Winkel "ZXZ" bestimmt.
public class Orientierung {
    public double winkeleins;
    public double winkelzwei;
    public double winkeldrei;

    public Orientierung(double winkeleins,
			double winkelzwei,
			double winkeldrei) {
	
	this.winkeleins = winkeleins;
	this.winkelzwei = winkelzwei;
	this.winkeldrei = winkeldrei;
    }
}
