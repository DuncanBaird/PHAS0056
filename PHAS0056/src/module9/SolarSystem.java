package module9;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SolarSystem {

	public static void createAndDisplayGUI() {
		JFrame frame = new JFrame("Swing Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello");
		frame.add(label);
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
