package module6;

public class LabelledDataPoint extends DataPoint {

	String labelDataPoint;

	// sets values
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.labelDataPoint = label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LabelledDataPoint [labelDataPoint=" + labelDataPoint + ", toString()=" + super.toString() + "]";
	}

}
