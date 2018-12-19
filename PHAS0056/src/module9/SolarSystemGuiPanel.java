package module9;

// import statements
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class for creating GUI panel for simulation
 * @author Duncan Baird
 * @version 1.0
 */
public class SolarSystemGuiPanel extends JPanel implements ActionListener {
	/**
	 * Member variables for creating GUI panel
	 */
	private static final long serialVersionUID = 1L;
	private static SolarSystemAnimationPanel solarPanel;

	/**
	* Member variables for objects such as buttons for adding to GUI
	*/
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	private JLabel title;
	/**
	* Constructor for GUI Panel containing simulation panel and buttons
	*/
	public SolarSystemGuiPanel() {
		// inherits from superclass
		super();
		// GUI dimension
		setPreferredSize(new Dimension(1300, 800));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		// GUI presentation name
		title = new JLabel("Solar System");
		// Animation dimensions
		solarPanel = new SolarSystemAnimationPanel(1300, 800);
		// stop, start and exit buttons
		startButton = new JButton("Start");
		stopButton  = new JButton("Stop");
		exitButton = new JButton("Exit");
		/**
		* Actions performed when buttons are depressed
		*/
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		/**
		* Add buttons to panel
		*/
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		/**
		* Add remaining components to panel
		*/
		add(title, BorderLayout.PAGE_START);
		add(solarPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.LINE_END);
	}

	/**
	* Method for responding to buttons
	*/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}
	/**
	* Starts simulation when started
	*/
	public void start() {solarPanel.start();}
	/**
	Stops animation when stopped
	*/
	public void stop() {solarPanel.stop();}

}
