package module2;

public class TestComplex {

	public static void main(String[] args) {
		// Testing Methods form Complex class
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(-2,1);
		System.out.println(c1);
		System.out.println(c2);
		
		//Product of c1 and c2
		System.out.println("The product of c1 and c2 is " + Complex.multiply(c1, c2));
		
		// Ratio of c1 and c2
		System.out.println("The quotient of c1 and c2 is " + Complex.divide(c1,c2));
		// The product of c1 and I
		System.out.println("The product of c1 and I is " + Complex.multiply(c1, Complex.I));
		// The ratio of c1 and 0
		System.out.println("The quotient of c1 and 0 is " + Complex.divide(c1,Complex.ZERO));
		// The product of c1 with the conjugate of c1
		System.out.println("The product of c1 and the conjugate of c1 is " + Complex.multiply(c1, c1.conjugate()));
		// The product of c2 with the conjugate of c2
		System.out.println("The product of c2 and the conjugate of c2 is " + Complex.multiply(c2, c2.conjugate()));

	}

}
