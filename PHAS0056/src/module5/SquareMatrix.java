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
		if(elements.length != 0) {
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
		else if(elements.length == 0) {
			throw new Exception("Square Matrix cannot have a zero size");
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
			values[i][i] = 1;
		}
		return new SquareMatrix(values);
	}

	//find hashcode of matrix
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(elements);
		result = prime * result + size;
		return result;
	}

	//returns true if two matrices are equal
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
	
	//// static matrix operations 
	
	//return addition of 2 square matrices
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.size != sm2.size) {
			throw new Exception("Square matrices are not the same size");
		}
		double[][] result = new double[sm1.elements.length][sm2.elements.length];
		
		for(int i=0;i<sm1.size;i++) {
			for(int j=0;j<sm1.size;j++) {
				result[i][j] = sm1.elements[i][j] + sm2.elements[i][j];
				
			}
			
		}
		return new SquareMatrix(result);	
	}
	
	//return difference of 2 square matrices
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.size != sm2.size) {
			throw new Exception("Square matrices are not the same size");
		}
		double[][] result = new double[sm1.elements.length][sm2.elements.length];
		
		for(int i=0;i<sm1.size;i++) {
			for(int j=0;j<sm1.size;j++) {
				result[i][j] = sm1.elements[i][j] - sm2.elements[i][j];
			}
		}
		return new SquareMatrix(result);
	}
	
	//return product of 2 square matrices
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.size != sm2.size) {
			throw new Exception("Square matrices are not the same size");
		}
		double[][] result = new double[sm1.elements.length][sm2.elements.length];
		
		for(int i=0;i<sm1.size;i++) {
			for(int j=0;j<sm1.size;j++) {
				for(int k=0; k< sm1.size;k++)
				result[i][j] += sm1.elements[i][k] * sm2.elements[k][j];
			}
		}
		return new SquareMatrix(result);
	}
	
	//// non static versions of above matrix operations
	
	//non static addition
	public SquareMatrix add(SquareMatrix sm) throws Exception {
		return add(this,sm);
	}
	//non static subtraction
	public SquareMatrix subtract(SquareMatrix sm) throws Exception{
		return subtract(this,sm);
	}
	//non static multiplication
	public SquareMatrix multiply(SquareMatrix sm) throws Exception{
		return multiply(this,sm);
	}
}
