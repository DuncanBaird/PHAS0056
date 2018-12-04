package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void singlePi(long points) {
		double t1 = System.currentTimeMillis();
		MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(points);
		double pi = task.call();
		System.out.println("The single thread value of pi is: " + pi);
		System.out.println("The time taken is: " + (System.currentTimeMillis() - t1) + "ms");
	}

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
		System.out.println("The four thread value of pi is: " + pi);
		System.out.println("The time taken is: " + (System.currentTimeMillis() - t2) + "ms");
	}

	public static void main(String[] args) {
		// Calling Pi calculators
		try {
			singlePi(10000000L);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			multiPi(10000000L, 4);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(
				"The single thread value is more accurate but slower.\nAnd the time taken is not 4 times faster. ");
	}

}
