package module9;

/**
 * Class for position of celestial bodies
 *
 * @author Duncan Baird
 * @version 1.1
 */
public class Position {
	/**
	 * (x,y) coordinates
	 */
	private int x;
	private int y;

	/**
	 * Constructor for object'ss position
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	Position(int x, int y) {
		this.x=x;
		this.y=y;
	}

	/**
	 * Set methods
	 */
	void setX(int x) {
		this.x = x;
	}
	void setY(int y){this.y = y;}

	/**
	 * Get methods
	 */
	int x() {
		return this.x;
	}

	int y() {
		return this.y;
	}
}
