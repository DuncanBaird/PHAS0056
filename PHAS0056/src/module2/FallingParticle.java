package module2;

public class FallingParticle {

	// simulation variables
	private double m; // mass of particle
	private double d; // drag coefficient
	private double t = 0; // time since drop 
	private double z; // vertical position(measured upwards)
	private double h; // initial height of drop
	private double v; // velocity of particle(measured upwards)
	private static final double g = 9.80665 ; // acceleration due to gravity (PDG Physical Constants 2018)
	
	public FallingParticle() {
		m = 0.0;
		d = 0.0;
	}
	
	public FallingParticle(double m, double d) {
		this.m = m;
		this.d = d;
	}
	
	//// set and get methods
	
	// set initial height of particle
	public void setH(double h) {
		this.h = h;
	}
	
	// return current position of particle
	public double getZ() {
		return this.z;
	}
	
	// set velocity of particle
	public void setV(double v) {
		this.v = v;
	}
	
	// return velocity of particle
	public double getV() {
		return this.v; 
	}
	
	// return time elapsed since drop of particle
	public double getT() {
		return this.t;
	}
	
	//// other methods
	
	// progress simulation through a time step
	public void doTimeStep(double deltaT) {
		// compute acceleration
		double a = (this.d*Math.pow(this.v, 2)/this.m)-this.g;
		// update particle velocity
		this.v = this.v + a*deltaT;
		// update particle position
		this.z = this.z + this.v*deltaT;
	}
	
	// start drop of particle in simulation with time increment deltaT
	public void drop(double deltaT) {
		this.z = this.h; // initialise particle position
		this.t = 0; // initialise time frame
		// loop to run simulation till particle reaches bottom of vessel
		while(this.z>0) {
			this.t += deltaT; // increment time by time increment
			doTimeStep(deltaT);
		}
	}
	public static void main(String[] args) {
	}
}
