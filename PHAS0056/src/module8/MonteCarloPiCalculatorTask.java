package module8;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Class for running a Monte Carlo simulation for determining a value of Pi.
 * 
 * @author Ben Waugh
 * @author Simon Jolly
 * @author Duncan Baird
 * @version 1.0
 */
public class MonteCarloPiCalculatorTask implements Callable<Double> {

	/**
	 * Member variable for number of Monte Carlo samples to compute
	 */
	private final long n_points;

	/**
	 * Constructor for building MonteCarloPiCalculatorTask. With a specified number
	 * of computation samples.
	 * 
	 * @param nPoints
	 */
	public MonteCarloPiCalculatorTask(long nPoints) {
		this.n_points = nPoints;
	}

	/**
	 * call method for computing Monte Carlo algorithm
	 */
	@Override
	public Double call() {
		Random rand = new Random();
		long n_in = 0;
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			double r2 = x * x + y * y;
			if (r2 < 1.0)
				++n_in;
		}
		return 4.0 * n_in / n_points;
	}

}
