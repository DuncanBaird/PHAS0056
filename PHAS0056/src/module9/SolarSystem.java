package module9;

// import statements
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Class for running a simulation of our solar System
 * 
 * @author Duncan Baird
 * @version 1.1
 */

public class SolarSystem {

	/**
	 * Method for creating the GUI for the solar system simulation
	 * <p>
	 * Uses the Swing toolkit for running graphics. Sets simulation to end when
	 * window is closed and starts GUI in maximised window state.
	 */
	private static void createAndDisplayGui() {
		JFrame frame = new JFrame("Simulation of our Solar System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		SolarSystemGuiPanel panel = new SolarSystemGuiPanel();

		// Add panel to frame
		frame.add(panel);
		// Fits components and layout sizes
		frame.pack();
		// Displays frame
		frame.setVisible(true);
	}
	/**
	* Responds to button clicks in GUI
	* @param arbitrary action even that toolkit can handle
	*/
	public void actionPerformed(ActionEvent e) {

	}
	/**
	* Main method to run the GUI of the simulation
	* <p>
	* Runs simulation in Runnable from toolkit.
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		});
	}
}
