package module9;

import java.awt.Color;

public abstract class StellarObject {

	protected String name;
	protected Position position;
	protected Position orbitCentre;
	protected double orbitPeriod;
	protected Color colour;
	protected int size;

	protected int size() {
		return this.size;
	}

	protected Color colour() {
		return this.colour;
	}

	abstract String name();

	abstract Position getPosition();
}
