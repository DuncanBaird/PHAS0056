package module3;

public class ThreeVector {
	
	// elements of vector
	double x; double y; double z;
	
	public ThreeVector() {
		
	}
	public ThreeVector(double a1,double a2,double a3) {
		this.x = a1;
		this.y = a2;
		this.z = a3;
	}

	void setThreeVector(double a1, double a2, double a3) {
		this.x = a1;
		this.y = a2;
		this.z = a3;
	}
	
	public double magnitude() {
		// magnitude of vector = (x*x+y*y+z*z)^0.5
		double mag = Math.pow((this.x*this.x)+(this.y*this.y)+(this.z*this.z), 0.5);
		return mag;
	}
	
	ThreeVector unitVector() throws Exception {
		if ((this.x == 0.0) && (this.y == 0.0) && (this.z == 0.0)) {
			throw new Exception("Can't find unit vector of zero vector: " + this.toString());
		}
		// unit vector = vector / magnitude of vector
		double mag = this.magnitude();
		double unitVectorx = this.x / mag;
		double unitVectory = this.y / mag;
		double unitVectorz = this.z/ mag;
		;
		return new ThreeVector(unitVectorx, unitVectory, unitVectorz);
	}

	public String toString() {
		return "x = "+this.x+", y = "+this.y+", z = "+this.z;
	}

	//// Static methods

	public static double scalarProduct(ThreeVector v1, ThreeVector v2) {
		// a.b = ax*bx + ay*by + az*bz
		double scalarProduct = (v1.x*v2.x)+(v1.y*v2.y)+(v1.z*v2.z);
		return scalarProduct;
	}
	
	public static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {
		// a x b = (ay*bz-az*by)i,(az*bx-ax*bz)j,(a*by-ay*bx)k
		double crossedx = (v1.y*v2.z)-(v1.z*v2.y);
		double crossedy = (v1.z*v2.x)-(v1.x*v2.z);
		double crossedz = (v1.x*v2.y)-(v1.y*v2.x);
		return new ThreeVector(crossedx, crossedy, crossedz);
	}
	
	public static ThreeVector add(ThreeVector v1, ThreeVector v2) {	
		// a + b = (ax+bx)i,(ay+by)j,(az+bz)k
		return new ThreeVector(v1.x + v2.x,v1.y + v2.y,v1.z + v2.z);
	}
	
	public static double angle(ThreeVector v1, ThreeVector v2) throws Exception { // angle in radians
		if ((v1.magnitude() == 0)|(v2.magnitude() == 0)) {
			throw new Exception("Can't find angle of zero vector: " + v1 + " or " + v2 );
		}
		// theta = arccos(a.b / |a||b|)
		double angle = Math.acos(scalarProduct(v1,v2)/(v1.magnitude()*v2.magnitude()));
		return angle;
		
	}
	
	//// Non-Static Methods of above static methods
	
	public double scalarProduct(ThreeVector v) {
		return scalarProduct(this,v);
	}
	
	public ThreeVector vectorProduct(ThreeVector v) {
		return vectorProduct(this,v);
	}
	
	public ThreeVector add(ThreeVector v) {
		return add(this,v);
	}
	
	public double angle(ThreeVector v) throws Exception {
		return angle(this,v);
	}
	public static void main(String[] args) {
	}
}
