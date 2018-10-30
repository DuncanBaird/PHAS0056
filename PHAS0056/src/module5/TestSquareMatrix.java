package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		//Defining matrices
		SquareMatrix A = new SquareMatrix();
		double[][] A_values = {{2,1,0},{0,1,0},{-1,0,2}};
		try {
			A = new SquareMatrix(A_values);
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println(A);
		
		
		
		
		
		
		/*
		// Testing
		SquareMatrix A = new SquareMatrix();
		double[][] A_values = {{2,1,0},{0,1,0},{-1,0,2}};
		try {
			A = new SquareMatrix(A_values);
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println(A);
		
		try {
			System.out.println(SquareMatrix.unitMatrix(3));
		}
		catch(Exception e) {
			
		}
		
		try{
			System.out.println(A.equals(SquareMatrix.unitMatrix(3)));
		}
		catch(Exception e) {
			
		}
		try {
			System.out.println(SquareMatrix.add(A,SquareMatrix.unitMatrix(3)));
		}
		catch(Exception e){
			
		}
		try {
			System.out.println(SquareMatrix.multiply(A, SquareMatrix.unitMatrix(3)));
		}
		catch(Exception e) {
			
		}
		try {
			System.out.println(A.multiply(SquareMatrix.unitMatrix(3)));
		}
		catch(Exception e){
			
		}
		*/
	}

}
