package module2;

public class FallingParticle {

	// member variables
	private double m; // mass of particle
	private double d; // drag coefficient
	private double t = 0; // time since drop 
	private double z; // vertical position(measured upwards)
	private double h; // initial height of drop
	private double v; // velocity of particle(measured upwards)
	private static final double g = 9.80665 ; // acceleration due to gravity (PDG Physical Constants 2018)
	
	// constructors
	public FallingParticle() {
		m = 0.0;
		d = 0.0;
	}
	
	public FallingParticle(double m, double d) {
		this.m = m;
		this.d = d;
	}
	
	// set and get methods
	public void setH(double h) {
		this.h = h;
	}
	public double getZ() {
		return this.z;
	}
	public void setV(double v) {
		this.v = v;
	}
	public double getV() {
		return this.v; 
	}
	public double getT() {
		return this.t;
	}
	
	// other methods
	public void doTimeStep(double deltaT) {
		double a = (this.d*Math.pow(this.v, 2)/this.m)-this.g;
		this.v = a*deltaT;
		this.z = this.v*deltaT;
	}
	
	public void drop(double deltaT) {
		this.z = this.hashCode();
		
		while(this.z>0) {
			this.t += deltaT;
			doTimeStep(deltaT);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
