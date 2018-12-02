package module6;

import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	// method for finding best Theory object for a data
	private static Theory bestTheory(Collection<DataPoint> data, Collection<Theory> theories,
			GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) {
		// Create collections for data and theories
		Collection<DataPoint> datapoints = new ArrayList<DataPoint>();
		Collection<Theory> theories = new ArrayList<Theory>();

		GoodnessOfFitCalculator gof = new ChiSquared();

		// objects for theories to test
		Theory x_2 = new PowerLawTheory(2);
		Theory x_205 = new PowerLawTheory(2.05);
		Theory quadratic_1 = new QuadraticTheory(1, 10, 0);

		// add theories to collection
		theories.add(x_2);
		theories.add(x_205);
		theories.add(quadratic_1);

		// try pull data from URL and find theory to best fit
		try {
			datapoints = TestDataPoints
					.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");

			Theory bestTheory = bestTheory(datapoints, theories, gof);

			System.out.println("The best theory is: " + bestTheory);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
