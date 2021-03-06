package module9_depreciated;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SolarSystem {

	public static void createAndDisplayGUI() {
		JFrame frame = new JFrame("Swing Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new SimulationGUI();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);


	}

	public void actionPerformed(ActionEvent e) {

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
