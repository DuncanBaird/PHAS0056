package module9;

// import statements
import java.awt.Color;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class for creating asteroids with circular orbits
 *
 * @author Duncan Baird
 * @version 1.0
 */
public class Asteroid extends CircularOrbitBody {

	/**
	* Random number used for varying object properties
	*/
	private static Random rand = new Random();

	/**
	 * Constructs asteroid
	 *
	 * @param orbitRadius radius of orbit
	 * @param orbitPeriod orbital period
	 * @param orbitCentre centre of orbit
	 * @param colour      colour of object in animation
	 * @param size        radius of object in animation
	 */
	public Asteroid(int orbitRadius, double orbitPeriod, Position orbitCentre, Color colour, int size) {
		// inherits from superclass
		super();
		this.orbitCentre = orbitCentre;
		this.orbitRadius = orbitRadius +
				(int) (rand.nextGaussian() *
						ThreadLocalRandom.current().nextInt(0, 50 + 1)); // Add Gaussian noise to orbit radius
		this.orbitPeriod = orbitPeriod * this.orbitRadius/orbitRadius;
		this.colour = colour;
		this.size = size;
		this.position = new Position(orbitCentre.x(),orbitCentre.y()+this.orbitRadius);
		this.angularSpeed = 2*Math.PI/this.orbitPeriod;
		this.delta = 2*Math.PI*50/(this.orbitPeriod*1000);
		this.orbitAngle = ThreadLocalRandom.current().nextInt(0, 360 + 1); // Random starting angle
	}

	/**
	 * Get methods
	 * 
	 * @return name name of asteroid
	 * @return position position of asteroid
	 */
	@Override
	public String name() {
		return "Asteroid";
	}
	@Override
	public Position getPosition() {
		updatePosition();
		return this.position;
	}
	
	/**
	 * Calculate and update asteroid with new position
	 * <p>
	 * See planet Javadoc for more specifics
	 */
	private void updatePosition() {

		this.orbitAngle += delta;
		if(this.orbitAngle > Math.PI * 2) {
			this.orbitAngle %= Math.PI * 2;
		}
		this.position.setX((int)((Math.cos(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.x()));
		this.position.setY((int)((Math.sin(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.y()));
	}


}
