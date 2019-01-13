package final2016;

/**
 * Class that implements Classify for classifying Audio objects as Long or Short
 * 
 * @author Duncan
 *
 */
public class FindLength implements Classify {

	/**
	 * Method for classifying audio object as Long (>1s) or Short (<=1s)
	 * 
	 * @return Long or Short as String
	 */
	public String classify(Audio a) {
		if (a.getT() > 1.0d) {
			return "Long";
		} else {
			return "Short";
		}
	}
}
