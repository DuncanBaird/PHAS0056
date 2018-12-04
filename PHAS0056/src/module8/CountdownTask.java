package module8;

/**
 * A class for counting down, every second, for a given input time. Outputs to
 * console remaining time every second. Implements runnable for thread usage.
 * 
 * @author Duncan Baird
 * @version 1.0
 */

public class CountdownTask implements Runnable {

	/**
	 * Member variable for time of countdown.
	 */
	int time;

	/**
	 * Constructs CountdownTask object with a given time to start at.
	 * 
	 * @param time
	 */
	public CountdownTask(int time) {
		this.time = time;
	}

	/**
	 * Runs CountdownTask object.
	 * <p>
	 * Runs the CountdownTask object to countdown from a specified time, every
	 * second, and output to console the time left.
	 */
	public void run() {
		try {
			for (int i = this.time; i > -1; i--) {
				Thread.sleep(1000);
				System.out.println("Seconds left is: " + i);
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
