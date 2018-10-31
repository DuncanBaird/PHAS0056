package module5;

public class Theory {

	private int n;
	
	//set n
	public Theory(int n) {
		this.n = n;
	}
	
	//calculates function y=x^n
	public double y(double x) {
		return Math.pow(x, this.n);
	}

}
