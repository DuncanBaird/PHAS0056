package module1;

public class VectorMethods {

	// method for computing dot product of two 3D vectors
	public static double dotProduct(double a1,double a2, double a3, double b1, double b2, double b3) {
		// unused array form of method
		/*  double[] a, double[] b
		int n = a.length;
		double sum = 0;
		for (int i = 0; i < n; i++)
		{
			sum += a[i] * b[i];
			
		}*/
		double sum = (a1 * b1)+(a2 * b2)+(a3 * b3); //equation for dot product
		
		return sum; // return of dot product
	}
	
	// method for computing magnitude of 3D vector
	public static double magnitude(double a1,double a2, double a3) {
		// unused array form
		/* double[]a
		int n = a.length;
		double sum = 0;
		double mag;
		for (int i = 0; i < n; i++)
		{
			sum += Math.pow(a[i], 2);
			
		}
		return mag = Math.pow(sum, 0.5);*/
		double mag = Math.pow((a1*a1)+(a2*a2)+(a3*a3), 0.5); // calculation for magnitude
		return mag; // return magnitude value as double

	}

	// method for computing the radian angle between two 3D vectors
	public static double angle(double a1,double a2, double a3, double b1, double b2, double b3) {
		// calculation using dotproduct and magnitude method for angle
		double theta = Math.acos(dotProduct(a1,a2,a3,b1,b2,b3) / (magnitude(a1,a2,a3)*magnitude(b1,b2,b3)));
		return theta; // return angle value as double in radians
	}
	
	// main method for using previous methods
	public static void main(String[] args) {
		// creating object for calling methods
		VectorMethods vm = new VectorMethods();
		
		// unused array form
		/*double[] v1 = {1,1,1}; double[] v2 = {2,2,2};*/
		
		// defining vectors a and b
		double a1 = 1, a2 = 1, a3 = 1, b1 = 1, b2 = 1, b3 =1;
		// calling the dot product method for vectors a and b and outputting result
		double dotProd = vm.dotProduct(a1,a2,a3,b1,b2,b3);
		System.out.println("The dot product of vectors a and b is " + dotProd);
		// calling the magnitude method for vector a and outputting result
		double magnitude = vm.magnitude(a1,a2,a3);
		System.out.println("The magnitude of vector a is " + magnitude);
		
		//defining new vectors
		double c1 = 4, c2 = 3, c3 = 2, d1 = 1, d2 = 5, d3 = 4;
		// calculating angle between vectors c and d, and outputting result
		double angle = vm.angle(c1,c2,c3,d1,d2,d3);
		System.out.println("The angle between vectors c and d in radians is " + angle);
		// defining additional zero vector
		double e1 = 0, e2 = 0, e3 = 0;
		// calculating angle between vectors c and e, and outputting result
		double angle2 = vm.angle(c1,c2,c3,e1,e2,e3);
		System.out.println("The angle between vectors c and e in radians is " + angle2);
		// this produces a "Not a Number" result as there is a divide by 0 due to the zero vector	
	}

}
