package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulation extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final int delay = 1; // delay between steps

	private Timer animationTimer; // timer controlling frame rate

	ArrayList<Planetoid> planets;
	ArrayList<StellarObject> celestialBodies;

	private Position orbitCentre;
	private int earthOrbitRadius;
	private int earthOrbitPeriod;
	private int earthSize = 5;
	private int sunRadius; // radius of sun


	/**
	 * Create panel containing simulation
	 * @param width of panel
	 * @param height of panel
	 */
	Simulation(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		animationTimer = new Timer(delay,this);
		animationTimer.start();

		orbitCentre = new Position(590, 340);

		sunRadius = 20;

		/**
		 * create objects for simulation
		 */
		Planetoid earth = new Planetoid("Earth", orbitCentre, earthOrbitRadius, earthOrbitPeriod, Color.CYAN,
				earthSize);

		planets = new ArrayList<Planetoid>();
		planets.add(earth);

		celestialBodies = new ArrayList<StellarObject>();

		celestialBodies.addAll(planets);

	}


	/**
	 * Paint Solar System objects
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int height = getHeight();
		int width = getWidth();

		// Fill in background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, width, height);

		// Move origin to centre of panel
		g.translate(width / 2, height / 2);

		// Draw Sun
		g.setColor(Color.YELLOW);
		g.fillOval(orbitCentre.getX() - sunRadius, orbitCentre.getY() - sunRadius, 2 * sunRadius, 2 * sunRadius);

		// Draw Planets
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval((int) (Mercury.x / 2E10), (int) (Mercury.y / 2E10), (int) Mercury.radius, (int) Mercury.radius);

		g.setColor(Color.WHITE);
		g.fillOval((int) (Venus.x / 2E10), (int) (Venus.y / 2E10), (int) Venus.radius, (int) Venus.radius);

		g.setColor(Color.CYAN);
		g.fillOval((int) (Earth.x / 2E10), (int) (Earth.y / 2E10), (int) Earth.radius, (int) Earth.radius);


	}

	/**
	 * This is called by the animation Timer object at regular intervals to rotate
	 * the shape and update the display
	 */
	public void actionPerformed(ActionEvent event) {
		// Update position, velocity and acceleration for all bodies
		// Mercury.simulate(delta);
		// Venus.simulate(delta);
		// Earth.simulate(delta);


		repaint();
	}

	/**
	 * Start the animation
	 */
	public void start() {
		animationTimer.start();
	}

	/**
	 * Stop the animation
	 */
	public void stop() {
		animationTimer.stop();
	}
}
