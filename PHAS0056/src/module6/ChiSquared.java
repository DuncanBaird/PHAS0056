package module6;

import java.util.Collection;
import java.util.Iterator;

public class ChiSquared implements GoodnessOfFitCalculator {

	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		double chi2 = 0.0d;
		
		// loop over array list for all tokens
		Iterator<DataPoint> it = data.iterator();
		while (it.hasNext()) {
			DataPoint dp = it.next();
			chi2 += Math.pow(dp.gety() - theory.y(dp.getx()), 2) / Math.pow(dp.getey(), 2);
		}
		return chi2;
	}
}
