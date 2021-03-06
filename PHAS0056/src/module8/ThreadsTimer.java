package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Main class for implementing MonteCarloPiCalculatorTask for finding Pi in
 * single and multi-threaded methods.
 * 
 * @author Ben Waugh
 * @author Simon Jolly
 * @author Duncan Baird
 * @version 1.1.1
 *
 */
public class ThreadsTimer {

	/**
	 * Method for calculating Pi and measuring time taken for multi-threads.
	 * <p>
	 * Takes a long as input for number for Monte Carlo simulations to run and an
	 * integer for the number of threads to use. Times how long for all threads to
	 * complete.
	 * 
	 * @param nPoints
	 * @param nThreads
	 * @throws Exception
	 */
	public static void multiPi(long nPoints, int nThreads) throws Exception {
		double t2 = System.currentTimeMillis();
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints / nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();
		double pi = sum / nThreads;
		System.out.println("The " + nThreads + " thread value of pi is: " + pi);
		System.out.println("The time taken is: " + (System.currentTimeMillis() - t2) + "ms");
	}

	/**
	 * Main method for implementing singlePi and multiPi methods.
	 * <p>
	 * Also has print statement for outputting a conclusion to console.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Calling Pi calculators
		try {
			multiPi(10000000L, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			multiPi(10000000L, 4);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(
				"\nThe single thread value is more accurate."
						+ "\nAnd the time taken is not 4 times faster for the multi-threaded method."
						+ "\nTrialling for 4 times as many points for the multi-threaded method does not"
						+ "\nproduce as accurate a result as the single threaded method"
						+ "\nfor a normal number of points.");
	}

}
