package module5;

import java.util.Scanner;

public class DataPoint {
	
	//sets member variables for data measurements
	private double x;
	private double y;
	private double ey;
	
	
	//sets values to zero for default
	public DataPoint() {
		this.x =0.0d;
		this.y = 0.0d;
		this.ey = 0.0d;
		
	}
	
	//sets values
	public DataPoint(double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}
	
	////getter methods for each member variable
	
	public double getx() {
		return this.x;
	}
	
	public double gety() {
		return this.y;
	}
	
	public double getey() {
		return this.ey;
	}
	
	//Parser for input string
	public static DataPoint parseLine(String line) {
		Scanner s = new Scanner(line);
		double x = 0.0d;
		double y = 0.0d;
		double ey = 0.0d;
		//iterate over input tokens
		while(s.hasNext()) {
			//update values
			x = s.nextDouble();
			y = s.nextDouble();
			ey = s.nextDouble();
		}
		s.close();
		return new DataPoint(x,y,ey);
	}
}
