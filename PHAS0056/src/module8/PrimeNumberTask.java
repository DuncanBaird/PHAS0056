package module8;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A class for checking what integers in the natural set are prime based on
 * their divisibility.
 * 
 * @author Duncan Baird
 * @version 1.0
 *
 */

public class PrimeNumberTask implements Runnable {

	/**
	 * Collection to store integers that have been found to be prime. Order does not
	 * matter.
	 */
	private static Collection<Integer> primeList = new ArrayList<Integer>();
	/**
	 * Integer to represent largest integer check loop reaches.
	 */
	private static int largestN;

	/**
	 * @return the primeList
	 */
	public static Collection<Integer> getPrimeList() {
		return primeList;
	}

	/**
	 * @return the largestN
	 */
	public static int getLargestN() {
		return largestN;
	}

	/**
	 * @param sets largestN value from input
	 */
	public static void setLargestN(int largestN) {
		PrimeNumberTask.largestN = largestN;
	}

	/**
	 * Checks to see if input is prime or not.
	 * 
	 * @param value of integer to be checked
	 * @return true or false; if prime
	 */
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Runs thread for finding prime numbers from 2 to max integer value.
	 * <p>
	 * If it finds a prime it adds to the collection of primes. Also checks for
	 * interruption of thread to stop checking if thread is interrupted.
	 */
	public void run() {
		primeList.clear();
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			if (Thread.currentThread().isInterrupted()) {
				return;
			}
			setLargestN(i);
			if (isPrime(i) == true) {
				primeList.add(i);
			}
		}
	}
}
