package module9;

// import statements
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


 /**
 * Class for creating panel for solar system simulation
 * <p>
 * Containing;planets: Mercury, Venus, Earth, Mars, Jupiter; asteroids; comets:
 * Duncan's comet
 *
 * @author Duncan Baird
 * @version 1.1
 */
public class SolarSystemAnimationPanel extends JPanel implements ActionListener {

	/**
	 * Member variables for creating simulation panel
	 */
	private static final long serialVersionUID = 1L;
	public static final int delay = 15;
	// timer from frame rate control
	private Timer animationTimer;

	private Position orbitCentre;

	private int sunRadius;

	/**
	* Orbital radii of circular orbit objects
	*/
	private int earthOrbitRadius;
	private int mercuryOrbitRadius;
	private int venusOrbitRadius;
	private int marsOrbitRadius;
	private int jupiterOrbitRadius;
  private int asteroidOrbitRadius;

  /**
	* Orbital period of circular orbit objects
	*/
	private double earthOrbitPeriod;
	private double mercuryOrbitPeriod;
	private double venusOrbitPeriod;
	private double marsOrbitPeriod;
	private double jupiterOrbitPeriod;
	private double asteroidOrbitPeriod;

	/**
	* Planet object for earth
	*/
	private Planet earth;

	/**
	* ArrayList for containing objects in solar system
	*/
	ArrayList<Planet> planets;
	ArrayList<Asteroid> asteroids;
	ArrayList<Comet> comets;
	ArrayList<CelestialBody> celestialBodies;

	/**
	 * Construct an animation panel with specified dimensions
	 * @param width
	 * @param height
	 */
	public SolarSystemAnimationPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		animationTimer = new Timer(delay,this);
		animationTimer.start();
		/**
		* Initialise orbit centre
		*/
		orbitCentre = new Position(width / 2, (height / 2) - 90);
    /**
		* Initialise solar radius
		*/
		sunRadius = 16;
    /**
		* Initialise orbital radii
		*/
		earthOrbitRadius = 60;
		mercuryOrbitRadius = (int) (earthOrbitRadius * 0.39);
		venusOrbitRadius = (int) (earthOrbitRadius * 0.72);
		marsOrbitRadius = (int) (earthOrbitRadius * 1.52);
		jupiterOrbitRadius = (int) (earthOrbitRadius * 5.2);
		asteroidOrbitRadius = (int) (earthOrbitRadius * 3.5);
    /**
		* Initialise orbital periods
		*/
		earthOrbitPeriod = 100;
		mercuryOrbitPeriod = earthOrbitPeriod * 0.241;
		venusOrbitPeriod = earthOrbitPeriod * 0.616;
		marsOrbitPeriod = earthOrbitPeriod * 1.9;
		jupiterOrbitPeriod = earthOrbitPeriod * 11.8;
    asteroidOrbitPeriod = earthOrbitPeriod * 3.5;
    /**
		* Create planets
		*/
		earth = new Planet("Earth",orbitCentre,earthOrbitRadius,earthOrbitPeriod,Color.cyan,10);
		Planet mercury = new Planet("Mercury",orbitCentre,mercuryOrbitRadius,mercuryOrbitPeriod,Color.gray,5);
		Planet venus = new Planet("Venus",orbitCentre,venusOrbitRadius,venusOrbitPeriod,Color.orange,9);
		Planet mars = new Planet("Mars",orbitCentre,marsOrbitRadius,marsOrbitPeriod,Color.red,6);
		Planet jupiter = new Planet("Jupiter",orbitCentre,jupiterOrbitRadius,jupiterOrbitPeriod,Color.yellow,50);
		/**
		* Create comets
		*/
		Comet comet = new Comet("Duncan's Comet", orbitCentre, 400, 0.8, 80, Color.MAGENTA, 4);

		planets = new ArrayList<Planet>();
		asteroids = new ArrayList<Asteroid>();
		comets = new ArrayList<Comet>();

		/**
		* add objects to arraylists
		*/
		planets.add(earth);
		planets.add(mercury);
		planets.add(venus);
		planets.add(mars);
		planets.add(jupiter);
		comets.add(comet);

		/**
		* Construct asteroids then add to arraylist
		*/
		for(int i=0; i<1000; i++){
			asteroids.add(new Asteroid(asteroidOrbitRadius, asteroidOrbitPeriod, orbitCentre, Color.lightGray, 3));
		}

		/**
		* Add all objects to master arraylist
		*/
		celestialBodies = new ArrayList<CelestialBody>();
		celestialBodies.addAll(planets);
		celestialBodies.addAll(asteroids);
		celestialBodies.addAll(comets);
	}

	/**
	* Paint celestial objects
	* names for planets and comets
	* information for simulation time elapsed
	*/
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/**
		* Fill in background
		*/
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
    /**
		* Paint sun
		*/
		g.setColor(Color.RED);
		g.fillOval(orbitCentre.x()-sunRadius, orbitCentre.y()-sunRadius, 2*sunRadius, 2* sunRadius);

    /**
		* Paint planet orbit paths and names
		 */
		for(Planet planet:planets){
			g.setColor(Color.WHITE);
			g.drawOval(orbitCentre.x()-planet.getOrbitRadius(), orbitCentre.y()-planet.getOrbitRadius(),
					2*planet.getOrbitRadius(), 2*planet.getOrbitRadius());
			g.setColor(planet.colour());
     		if(planet.name() == "Jupiter"){
				g.drawChars(planet.name().toCharArray(), 0, planet.name().length(), planet.getPosition().x()+60, planet.getPosition().y()+30);
    		} else {
				g.drawChars(planet.name().toCharArray(), 0, planet.name().length(), planet.getPosition().x()+15, planet.getPosition().y()+15);
			}
		}
		/**
		* Paint remaining celestial bodies
		*/
		for(CelestialBody celestialBody:celestialBodies){
			g.setColor(celestialBody.colour());
			g.fillOval(celestialBody.getPosition().x(), celestialBody.getPosition().y(),
					celestialBody.size(), celestialBody.size());
		}
    /**
		* Paint comet names
		*/
		for(CelestialBody comet:comets){
			g.setColor(comet.colour());
			g.drawString(comet.name(), comet.getPosition().x() + 15, comet.getPosition().y()+20);
		}
		/**
		* Paint time elapsed in years
		*/
		g.setColor(Color.white);
		g.drawString("Time elapsed:", 1150, 185);
		g.drawString(Integer.toString(earth.getOrbits())+" Earth Years", 1150, 200);

	}

	/**
  * MEthod for updating the animation of the simulation
  */
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	/**
	* Starts simulation when started
	*/
	public void start() {animationTimer.start();}
	/**
	Stops animation when stopped
	*/
	public void stop() {animationTimer.stop();}
}
