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
		
		//calculating AxB and BxA
		
		try {
			System.out.println("Matrix A multiplied by matrix B is\n" + A.multiply(B));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			System.out.println("Matrix B multiplied by matrix A is\n" + B.multiply(A));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//calculating commutator; [A,B], defined as (AB - BA
		
		try {
			System.out.println("The commutator of A and B is\n" 
		+ SquareMatrix.subtract(A.multiply(B),B.multiply(A)));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//calculating CxD
		
		try{
			SquareMatrix CD = C.multiply(D);
			SquareMatrix I = SquareMatrix.unitMatrix(2);
			System.out.println("Is matrix CD equal to matrix I?\n" + CD.equals(I));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
