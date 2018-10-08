package module2;

public class ThreeVector {
	
	// member variable
	double x; double y; double z;
	
	// constructors
	public ThreeVector() {
		
	}
	public ThreeVector(double a1,double a2,double a3) {
		this.x = a1;
		this.y = a2;
		this.z = a3;
	}

	// method for storing three vector
	void setThreeVector(double a1, double a2, double a3) {
		this.x = a1;
		this.y = a2;
		this.z = a3;
	}
	

	// method for calculating magnitude
	double magnitude(double a1, double a2, double a3) {
		double mag = Math.pow((a1*a1)+(a2*a2)+(a3*a3), 0.5);
		return mag;
	}
	
	// method for calculating unit vector of three vector
	ThreeVector unitVector() {
		double mag = this.magnitude(this.x, this.y, this.z);
		double unitVectorx = this.x / mag;
		double unitVectory = this.y / mag;
		double unitVectorz = this.z/ mag;
		;
		return new ThreeVector(unitVectorx, unitVectory, unitVectorz);
	}
	// method for converting to string vector components
	public String toString() {
		
		return "x = "+this.x+", y = "+this.y+", z = "+this.z;
	}

	//// Static methods
	
	// static scalar product method
	public static double scalarProduct(ThreeVector v1, ThreeVector v2) {
		double scalarProduct = (v1.x*v2.x)+(v1.y*v2.y)+(v1.z*v2.z);
		return scalarProduct;
	}
	
	// static vectorProduct method
	public static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {
		double crossedx = (v1.y*v2.z)-(v1.z*v2.y);
		double crossedy = (v1.z*v2.x)-(v1.x*v2.z);
		double crossedz = (v1.x*v2.y)-(v1.y*v2.x);
		return new ThreeVector(crossedx, crossedy, crossedz);
	}
	
	// static add method
	public static ThreeVector add(ThreeVector v1, ThreeVector v2) {
		new ThreeVector() = v3;
		
		return new ThreeVector 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeVector vector = new ThreeVector();
		vector.setThreeVector(1,1,1);
		System.out.println("The x componenent of the vector is " + vector.x);
		System.out.println("The magnitude of the vector is " + vector.magnitude(vector.x,vector.y,vector.z));
		System.out.println("The unitvector of the vector is " + vector.unitVector().toString());
		System.out.println(vector.toString());
	
	}

}
