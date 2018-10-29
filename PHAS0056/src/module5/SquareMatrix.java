package module5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {

	private double[][] elements;
	private int size;
	
	public SquareMatrix() {
		
	}
	
	public SquareMatrix(double[][] elements) throws Exception {
		int m = elements.length;
		int n = elements[0].length;
		for (int i=0; i<m; i++) {
			if(elements[i].length != n) {
				throw new Exception("m must equal n for a square matrix");
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
			matrix += " | ";
			for(int j=0; j<this.size;j++) {
				matrix += elements[i][j] + " | ";
				
			}
			matrix += "\n";
		}
		
		return matrix;
	}
	
	public static SquareMatrix unitMatrix(int size) throws Exception {
		double[][]values = new double[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				values[i][i] = 1;
			}
		}
		return new SquareMatrix(values);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(elements);
		result = prime * result + size;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(elements, other.elements))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	
	
}
