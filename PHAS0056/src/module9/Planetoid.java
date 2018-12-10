package module9;

import java.awt.Color;

public class Planetoid extends CircularOrbit {
	private int numOrbits = 0;

	Planetoid(String planetName, Position orbitCentre, int orbitRadius, double orbitTime, Color colour, int size) {
		super();
		this.name = planetName;
		this.colour = colour;
		this.size = size;
		this.orbitCentre = orbitCentre;
		this.orbitRadius = orbitRadius;
		this.orbitPeriod = orbitTime;
		this.position = new Position(orbitCentre.getX(), orbitCentre.getY() + this.orbitRadius);
		this.angularSpeed = 2 * Math.PI / this.orbitPeriod;
		this.delta = 2 * Math.PI * this.delay / (this.orbitPeriod * 1000);
	}

	public String name() {
		return this.name;
	}

	public Position getPosition() {
		updatePosition();
		return this.position;
	}

	private void updatePosition() {
		this.orbitAngle += delta;
		if(this.orbitAngle>Math.PI*2) {
			this.orbitAngle%=Math.PI*2;
			updateOrbits();
		}
		this.position.setX((int)((Math.cos(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.getX()));
		this.position.setY((int) ((Math.sin(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.getY()));
	}

	public int getOrbitRadius() {
		return this.orbitRadius;
	}

	public int getOrbits() {
		return this.numOrbits;
	}

	private void updateOrbits() {
		numOrbits++;
	}
}
