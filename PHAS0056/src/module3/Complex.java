package module3;

public class Complex {
	
	double re; double im; // real:re and imaginary:im components of a complex number
	
	public Complex() {
		this.re = 0.0;
		this.im = 0.0;
	}
	
	public Complex(double real, double imaginary) {
		this.re = real;
		this.im = imaginary;
	}
	
	public double real() {
		return this.re;
	}
	
	public double imag() {
		return this.im;
	}
	
	public double modulus() {
		// |x + iy| = (x*x+y*y)^0.5 
		double mod = Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
		return mod;
	}
	
	public double angle() { // in radians
		// argument(x+iy) = arctan(y/x)
		double argument = Math.atan(this.im/this.re);
		return argument;
	}
	
	public Complex conjugate() {
		// [conjugate of x+iy] = x-iy
		return new Complex(this.re,-1*this.im);
	}
	
	public Complex normalised() throws Exception {
		// normalised z = z / |z|
				if ((this.re == 0.0) && (this.im == 0.0)) {
			throw new Exception("Can't normalise a zero complex number: " + this.toString());
		}
		double normalisation = 1/this.modulus();		
		return new Complex(normalisation*this.re,normalisation*this.im);
	}
	
	// method for testing equality of 2 complex numbers
	public boolean equals(Complex c) {
		// initialising loop variable
		boolean result = true;
		// if statement to check equality of complex numbers
		if ((this.re == c.re) && (this.im == c.im)) {
			result = true;
		} else {
				result = false;
			}
		
		return result;
	}
	
	public String toString() {	
			return "Re() = "+this.re+", Im() = "+this.im;
		}
	
	// method for defining Cartesian complex number from Polar form
	public Complex setFromModulusAngle(double mag, double ang) {
		// x = r*cos(theta) 	y = r*sin(theta)
		this.re = mag * Math.cos(ang);
		this.im = mag * Math.sin(ang);
		return new Complex(this.re,this.im);
	}
	
	//// static methods
	
	public static Complex add(Complex w, Complex z) {
		// z + w = Re(z+w) + iIm(z+w)
		return new Complex(w.re+z.re,w.im+z.im);
	}
	
	public static Complex subtract(Complex w, Complex z) {
		// z - w = Re(z+w) - iIm(z+w)
		return new Complex(w.re-z.re,w.im-z.im);
	}
	
	public static Complex multiply(Complex w, Complex z) {
		// w * z = [Re(w)*(Re(z) - Im(w)*Im(z)]+i[Re(w)*Im(z)+Im(w)*Re(z)]
		return new Complex(((w.re*z.re)-(w.im*z.im)),((w.re*z.im)+(w.im*z.re)));
	}
	
	public static Complex divide(Complex w, Complex z) throws Exception{
		if ((z.re == 0.0) && (z.im == 0.0)) {
			throw new Exception("Can't divide by a zero complex number: " + z.toString());
		}
		// w/z = [Re(w)*Re(z)+Im(w)*Im(z)/Re(z)^2+Im(z)]+i[Im(w)*Re(z)+Re(w)*Im(z)/Re(z)^2+Im(z)]
		double quotient_real = ((w.re*z.re)+(w.im*z.im))/((Math.pow(z.re, 2)+Math.pow(z.im, 2)));
		double quotient_im = ((w.im*z.re)-(w.re*z.im))/((Math.pow(z.re, 2)+Math.pow(z.im, 2)));
		return new Complex(quotient_real, quotient_im);
	}
	
	// key variables for complex numbers
	public static final Complex ONE = new Complex(1,0); 
	public static final Complex ZERO = new Complex (0,0);
	public static final Complex I = new Complex (0,1);
	
	public static void main(String[] args) {
	}
}
