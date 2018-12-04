package module8;

import java.util.Collections;

/**
 * Main class for using CountdownTask and PrimeNumberTask. Finds prime numbers
 * while countdown is running.
 * 
 * @author Duncan Baird
 * @version 1.0
 */
public class ThreadsMain {

	/**
	 * Main method for using CountdownTask and PrimeNumberTask
	 * <p>
	 * Starts countdown for given time input in seconds. Then runs the prime checker
	 * until the countdown stops.
	 * </p>
	 * Outputs the largest number checked for being prime, the largest prime number
	 * found and the total number of prime numbers found.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Implements CountdownTask and PrimeNumebrTask in separate threads
		Thread countdown = new Thread(new CountdownTask(3));
		countdown.start();

		Thread prime = new Thread(new PrimeNumberTask());
		prime.start();

		try {
			countdown.join();
			prime.interrupt();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Largest integer checked is: " + PrimeNumberTask.getLargestN());

		System.out.println("The largest prime found is: " + Collections.max(PrimeNumberTask.getPrimeList()));
		System.out.println("The total prime numbers is: " + PrimeNumberTask.getPrimeList().size());

	}

}
