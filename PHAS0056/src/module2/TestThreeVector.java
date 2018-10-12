package module2;

public class TestThreeVector {

	public static void main(String[] args) {
	// Created 3 new ThreeVectors
	ThreeVector v1 = new ThreeVector(4,5,3);
	ThreeVector v2 = new ThreeVector(1,4,2);
	ThreeVector v3 = new ThreeVector(0,0,0);
	
	// Print values of vectors
	System.out.println("Vector 1 is " + v1.toString());
	System.out.println("Vector 2 is " + v2.toString());
	System.out.println("Vector 3 is " + v3.toString());
	
	// Print values of corresponding unit vectors
	System.out.println("The unit vector of vector 1 is " + v1.unitVector());
	System.out.println("The unit vector of vector 2 is " + v2.unitVector());
	System.out.println("The unit vector of vector 3 is " + v3.unitVector());
	
	// Print the scalar products (static and non-static methods)
	System.out.print("Using static methods: ");
	System.out.println("The scalar product of vector 1 and vector 2 is: " + ThreeVector.scalarProduct(v1, v2));
	System.out.print("Using non-static methods: ");
	System.out.println("The scalar product of vector 1 and vector 2 is: " + v1.scalarProduct(v2));
	
	System.out.print("Using static methods: ");
	System.out.println("The scalar product of vector 1 and vector 3 is: " + ThreeVector.scalarProduct(v1, v3));
	System.out.print("Using non-static methods: ");
	System.out.println("The scalar product of vector 1 and vector 3 is: " + v1.scalarProduct(v3));
	
	
	// Print the vector products (static and non-static methods)
	System.out.print("Using static methods: ");
	System.out.println("The vector product of vector 1 and vector 2 is: " + ThreeVector.vectorProduct(v1, v2));
	System.out.print("Using non-static methods: ");
	System.out.println("The vector product of vector 1 and vector 2 is: " + v1.vectorProduct(v2));
	
	System.out.print("Using static methods: ");
	System.out.println("The vector product of vector 1 and vector 3 is: " + ThreeVector.vectorProduct(v1, v3));
	System.out.print("Using non-static methods: ");
	System.out.println("The vector product of vector 1 and vector 3 is: " + v1.vectorProduct(v3));
	
	// Print the angles (in radians) (static and non-static methods)
	System.out.print("Using static methods: ");
	System.out.println("The angle between vector 1 and vector 2 is: " + ThreeVector.angle(v1, v2));
	System.out.print("Using non-static methods: ");
	System.out.println("The angle between vector 1 and vector 2 is: " + v1.angle(v2));
	
	System.out.print("Using static methods: ");
	System.out.println("The angle between vector 1 and vector 3 is: " + ThreeVector.angle(v1, v3));
	System.out.print("Using non-static methods: ");
	System.out.println("The angle between vector 1 and vector 3 is: " + v1.angle(v3));
	
	// Attempting suggestions
	/*System.out.println(v1);*/
	System.out.println("Printing a Java object with no toString method defiend results "
			+ "in the object type and hash code being printed in base 16");
	}
}
