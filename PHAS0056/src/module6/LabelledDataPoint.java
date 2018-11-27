package module6;

public class LabelledDataPoint extends DataPoint {

	String labelDataPoint;

	// sets values
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.labelDataPoint = label;
	}

}
