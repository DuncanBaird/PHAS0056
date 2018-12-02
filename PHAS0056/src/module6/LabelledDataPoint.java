package module6;

import java.util.Scanner;

public class LabelledDataPoint extends DataPoint {

	String labelDataPoint;

	// sets values
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.labelDataPoint = label;
	}

	// to String for labelled data point
	@Override
	public String toString() {
		return "[Label of data point = " + labelDataPoint + ", toString()=" + super.toString() + "]";
	}

	// Parser for input string
	public static DataPoint parseLine(String line) {
		Scanner s = new Scanner(line);
		double x = 0.0d;
		double y = 0.0d;
		double ey = 0.0d;
		String label = "";
		// iterate over input tokens
		while (s.hasNext()) {
			// update values
			x = s.nextDouble();
			y = s.nextDouble();
			ey = s.nextDouble();
			if (s.hasNext()) {
				label = s.next();
			}
		}
		s.close();

		// update either with or without label
		if (label != "") {
			return new LabelledDataPoint(x, y, ey, label);
		} else {

			return new DataPoint(x, y, ey);
		}
	}

}
