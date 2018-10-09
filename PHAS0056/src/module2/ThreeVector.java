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
	public double magnitude() {
		double mag = Math.pow((this.x*this.x)+(this.y*this.y)+(this.y*this.y), 0.5);
		return mag;
	}
	
	// method for calculating unit vector of three vector
	ThreeVector unitVector() {
		double mag = this.magnitude();
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
		return new ThreeVector(v1.x + v2.x,v1.y + v2.y,v1.z + v2.z);
	}
	
	// static angle method (radians)
	public static double angle(ThreeVector v1, ThreeVector v2) {
		double angle = Math.acos(scalarProduct(v1,v2)/(v1.magnitude()*v2.magnitude()));
		return angle;
		
	}
	
	//// Non-Static Methods
	
	// Non-static scalar product method
	public double scalarProduct(ThreeVector v) {
		return scalarProduct(this,v);
	}
	
	// Non-Static vector product method
	public ThreeVector vectorProduct(ThreeVector v) {
		return vectorProduct(this,v);
	}
	
	// Non-static add method
	public ThreeVector add(ThreeVector v) {
		return add(this,v);
	}
	
	// Non-Static angle method (radians)
	public double angle(ThreeVector v) {
		return angle(this,v);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeVector vector = new ThreeVector();
		vector.setThreeVector(1,1,1);
		/*System.out.println("The x componenent of the vector is " + vector.x);
		System.out.println("The magnitude of the vector is " + vector.magnitude(vector.x,vector.y,vector.z));
		System.out.println("The unitvector of the vector is " + vector.unitVector().toString());
		System.out.println(vector.toString());*/
	
	}

}
