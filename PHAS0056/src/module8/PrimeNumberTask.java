package module8;

import java.util.ArrayList;
import java.util.Collection;

public class PrimeNumberTask implements Runnable {

	private static Collection<Integer> primeList = new ArrayList<Integer>();
	private static int largestN;
	private static int largestPrime;

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

	}
}
