package module8;

import java.util.ArrayList;
import java.util.Collection;

public class PrimeNumberTask implements Runnable {

	private static Collection<Integer> primeList = new ArrayList<Integer>();
	private static int largestN;
	private static int largestPrime;

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
	 * @param largestN the largestN to set
	 */
	public static void setLargestN(int largestN) {
		PrimeNumberTask.largestN = largestN;
	}

	// test if input is prime
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

	public void run() {
		primeList.clear();
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			setLargestN(i);
			if (isPrime(i) == true) {
				primeList.add(i);
			}
		}
	}
}
