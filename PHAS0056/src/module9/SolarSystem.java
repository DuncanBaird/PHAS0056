package module9;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SolarSystem {

	public static void createAndDisplayGUI() {
		JFrame frame = new JFrame("Swing Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello");
		frame.add(label);
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGUI();
			}
		});
	}

}
