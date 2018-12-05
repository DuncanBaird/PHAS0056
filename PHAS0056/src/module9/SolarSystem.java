package module9;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SolarSystem {

	public static void createAndDisplayGUI() {
		JFrame frame = new JFrame("Swing Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new SimulationGUI();
		frame.add(panel);
		frame.setSize(600, 600);
		frame.setVisible(true);


	}

	public static void main(String[] args) {
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGUI();
			}
		});
	}

}
