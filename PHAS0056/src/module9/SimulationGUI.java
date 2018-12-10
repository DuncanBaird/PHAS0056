package module9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SimulationGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Simulation animPanel; // panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;

	/**
	 * Create JPanel containing animation panel and buttons
	 */
	public SimulationGUI() {
		super();
		setPreferredSize(new Dimension(600, 600));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		animPanel = new Simulation(600, 600);
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");

		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);

		add(animPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.LINE_END);

	}

	/**
	 * Start animation when applet is started
	 */
	public void start() {
		animPanel.start();
	}

	/**
	 * Stop animation when applet is stopped
	 */
	private void stop() {
		animPanel.stop();
	}

	/**
	 * Respond to button clicks
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton)
			start();
		else if (e.getSource() == stopButton)
			stop();
		else if (e.getSource() == exitButton)
			System.exit(0);
	}
}
