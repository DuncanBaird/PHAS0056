package module2;

public class Complex {
	
	// member variables
	double re; double im;
	
	// constructors
	public Complex() {
		this.re = 0;
		this.im = 0;
	}
	
	public Complex(double real, double imaginary) {
		this.re = real;
		this.im = imaginary;
	}
	
	// method to return real value of complex number
	public double real() {
		return this.re;
	}
	
	// method to return imaginary value of complex number
	public double imag() {
		return this.im;
	}
	
	// method to return modulus of complex number
	public double modulus() {
		double mod = Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
		return mod;
	}
	
	// method to return argument of complex number (in radians)
	public double angle() {
		double argument = Math.atan(this.im/this.re);
		return argument;
	}
	
	// method to return conjugate of complex number
	public Complex conjugate() {
		return new Complex(this.re,-1*this.im);
	}
	
	// method to normalise complex number
	public Complex normalised() {
		double normalisation = 1/this.modulus();
		return new Complex(normalisation*this.re,normalisation*this.im);
	}
	
	// method for testing equality of 2 complex numbers
	public boolean equals(Complex c) {
		boolean result = true;
		if ((this.re == c.re) && (this.im == c.im)) {
			result = true;
		} else {
				result = false;
			}
		
		return result;
	}
	
	// method for defining cartesian complex number from polar form
	public Complex setFromModulusAngle(double mag, double ang) {
		this.re = mag * Math.cos(ang);
		this.im = mag * Math.sin(ang);
		return new Complex(this.re,this.im);
	}
	
	//// static methods
	
	
	// method for converting to string complex number
	public String toString() {	
			return "Re(w) = "+this.re+", Im(w) = "+this.im;
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
