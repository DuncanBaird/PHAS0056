package module9;

public class StellarObject {

	// cosntants
	private static final double pi = Math.PI;
	private static final double massSun = 1.98E30;
	private static final double gravitation = 6.67E-11;

	// member variables

	double acceleration_x;
	double acceleration_y;
	double velocity_x;
	double velocity_y;
	double x;
	double y;
	double radius;
	double azimuth;
	double zenith;

	// constructors

	public StellarObject(double radius, double velocity, double position) {
		this.radius = radius;
		this.velocity_x = velocity;
		this.y = position;
	}

	public static double magnitude(double x, double y) {
		return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
	}

	public void simulate(int time) {
		double a = gravitation * massSun / Math.pow(magnitude(x, y), 3);

		azimuth = Math.atan(x / y);

		acceleration_x = a * Math.sin(azimuth);
		acceleration_y = a * Math.sin(azimuth);

		x = x + (velocity_x * time);
		y = y + (velocity_y * time);

		velocity_x = velocity_x - (acceleration_x * time);
		velocity_y = velocity_y - (acceleration_y * time);

	}

}
