package module6;

public class LabelledDataPoint extends DataPoint {

	String labelDataPoint;

	// sets values
	public LabelledDataPoint(double x, double y, double ey, String label) {
		this.x = x;
		this.y = y;
		this.ey = ey;
		this.labelDataPoint = label;
	}

}
