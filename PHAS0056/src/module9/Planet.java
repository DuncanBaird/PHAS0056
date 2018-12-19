package module9;

// import statements
import java.awt.Color;

/**
 * Abstract class for creating celestial objects with circular orbits
 *
 * @author Duncan Baird
 * @version 1.0
 */
public class Planet extends CircularOrbitBody {

	/**
	 * Member variable for planetoid to count number of orbits undertaken
	 */
	private int numOrbits = 0;

	/**
	 * Constructs a planetoid from inputs parameters
	 *
	 * @param planetName    name of planet
	 * @param orbitCentre   centre of orbit
	 * @param orbitRadius   radius of orbit
	 * @param orbitTime     orbit period
	 * @param colour        colour of object in animation
	 * @param size          radius of object in animation
	 */
	Planet(String planetName, Position orbitCentre, int orbitRadius, double orbitTime, Color colour, int size) {
		// inherits from superclass
		super();
		this.name = planetName;
		this.colour = colour;
		this.size = size;
		this.orbitCentre = orbitCentre;
		this.orbitRadius = orbitRadius;
		this.orbitPeriod = orbitTime;
		// start at poisition relative to orbit centre
		this.position = new Position(orbitCentre.x(),orbitCentre.y()+this.orbitRadius);
		this.angularSpeed = 2*Math.PI/this.orbitPeriod;
		this.delta = 2*Math.PI*this.delay/(this.orbitPeriod*1000);
	}

	/**
	* Get methods
	* @return name name of planetoid
	* @return position position of planetoid
	*/
	@Override
	public String name() {
		return this.name;
	}
	@Override
	public Position getPosition() {
		updatePosition();
		return this.position;
	}
    /**
		* Calculates and updates object to new position in orbit
		*/
	private void updatePosition() {

		this.orbitAngle += delta;
		// Check if orbit is completed
		if(this.orbitAngle > Math.PI * 2) {
			this.orbitAngle %= Math.PI * 2;
			/**
			* Increment orbit number only every orbit
			*/
			updateOrbits();
		}
		/**
		* Set new (x,y) coordinates of position
		*/
		this.position.setX((int)((Math.cos(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.x()));
		this.position.setY((int)((Math.sin(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.y()));
	}

	/**
	* Get methods
	* @return orbitRadius radius of orbit
	* @return numOrbits number of orbits undertaken
	*/
	public int getOrbitRadius(){
		return this.orbitRadius;
	}

	public int getOrbits() {
		return this.numOrbits;
	}

	/**
	* Method to increment by done the number of orbits undertaken
	*/
	private void updateOrbits() {
		numOrbits++;
	}

}
