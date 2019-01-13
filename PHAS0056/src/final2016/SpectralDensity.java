package final2016;

import java.util.HashMap;

/**
 * Finds spectral density of Audio objects
 * 
 * @author Duncan
 *
 */
public class SpectralDensity implements Classify {

	public String classify(Audio a) {
		HashMap<Integer, String> sd = new HashMap<Integer, String>();
		sd.put(100, "Low");
		sd.put(400, "Medium");
		sd.put(1000, "High");

		double max = Double.MIN_VALUE;
		String output = "";

		for (int f : sd.keySet()) {
			if (a.getSpectralDensity(f) > max) {
				max = a.getSpectralDensity(f);
				output = sd.get(f);
			}
		}
		return output;
	}
}
