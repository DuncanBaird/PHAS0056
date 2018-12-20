package module9;

/**
 * Abstract class for creating celestial objects with circular orbits
 *
 * @author Duncan Baird
 * @version 1.1
 */
public abstract class CircularOrbitBody extends CelestialBody {
	/**
	* Member variables for objects with circular orbits
	*/
	protected int orbitRadius;
	// angular speed or orbit not rotation
	protected double angularSpeed;
	// initialisation value
	protected double orbitAngle = 0;
	// simulation increment of orbit
	protected double delta;
	// increment time, ms
	protected double delay = 50;

}
