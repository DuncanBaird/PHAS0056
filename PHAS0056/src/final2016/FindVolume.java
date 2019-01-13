package final2016;

/**
 * Class that implements Classify for classifying Audio objects as Loud or Quiet
 * 
 * @author Duncan
 *
 */
public class FindVolume implements Classify {

	/**
	 * Method for classifying Audio object as Louder than -20dBFS or quieter
	 * 
	 * @return Loud or Quiet as String
	 */
	public String classify(Audio a) {
		if (a.getA() > -20.0d) {
			return "Loud";
		} else {
			return "Quiet";
		}
	}
}
