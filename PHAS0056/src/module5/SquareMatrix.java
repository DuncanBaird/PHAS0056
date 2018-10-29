package module5;

import java.lang.reflect.Array;

public class SquareMatrix {

	private double[][] elements;
	private int size;
	
	public SquareMatrix(double[][] elements) {
		int m = elements.length;
		int n = elements[0].length;
		for (int i=0; i<m; i++) {
			if(elements[i].length != n) {
				throw new IllegalArgumentException();
			}
			else {
				this.elements = elements;
				this.size = elements.length;
			}
		}
	}
	public String toString() {
		String matrix = "";
		for (int i=0;i<this.size;i++) {
			for(int j=0; j<this.size;j++) {
				
			}
		}
		
		return "m is" +this.m+"n is" +this.n;
	}
}
