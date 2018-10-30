package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		//Defining matrices
		SquareMatrix A = new SquareMatrix();
		SquareMatrix B = new SquareMatrix();
		SquareMatrix C = new SquareMatrix();
		SquareMatrix D = new SquareMatrix();
		double[][] A_elements = {{2,1,0},{0,1,0},{-1,0,2}};
		double[][] B_elements = {{1,3,1},{0,2,0},{1,0,-1}};
		double[][] C_elements = {{2,3},{3,4}};
		double[][] D_elements = {{-4,3},{3,-2}};
		
		//Trying to make each matrix into SquareMatrix Object
		try {
			A = new SquareMatrix(A_elements);
		}
		catch(Exception e){
			System.out.println(e);
		}
		try {
			B = new SquareMatrix(B_elements);
		}
		catch(Exception e){
			System.out.println(e);
		}
		try {
			C = new SquareMatrix(C_elements);
		}
		catch(Exception e){
			System.out.println(e);
		}
		try {
			D = new SquareMatrix(D_elements);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		//calculating A+B and A-B
		
		try {
			System.out.println("Matrix A added to matrix B is\n" + A.add(B));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			System.out.println("Matrix A subtracted by matrix B is\n" + A.subtract(B));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
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
