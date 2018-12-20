package module9;

// import statements
import java.awt.Color;

/**
 * Abstract class for creating celestial objects in solar system
 * 
 * @author Duncan Baird
 * @version 1.1
 */
public abstract class CelestialBody {

	/**
	* Member variables for CelestialBody objects
	*/
	protected String name;
	// (x,y) coordinates in animation
	protected Position position;
	// (x,y) coordinates of celestial centre
	protected Position orbitCentre;
	protected double orbitPeriod;
	protected Color colour;
	protected int size;

	/**
	* Get methods for size and colour of objects
	*/
	protected int size(){return this.size;};
	protected Color colour(){return this.colour;};
	
	/**
	 * Abstract methods for implementation in subclasses
	 */
	abstract String name(); // name of object
	abstract Position getPosition(); // position of object
}
