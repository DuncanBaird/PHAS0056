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
	
	// method for defining Cartesian complex number from Polar form
	public Complex setFromModulusAngle(double mag, double ang) {
		this.re = mag * Math.cos(ang);
		this.im = mag * Math.sin(ang);
		return new Complex(this.re,this.im);
	}
	
	//// static methods
	
	// static method to add complex numbers
	public static Complex add(Complex w, Complex z) {
		return new Complex(w.re+z.re,w.im+z.im);
	}
	
	// static method to subtract complex numbers
	public static Complex subtract(Complex w, Complex z) {
		return new Complex(w.re-z.re,w.im-z.im);
	}
	
	// static method to multiply complex numbers
	public static Complex multiply(Complex w, Complex z) {
		return new Complex(((w.re*z.re)-(w.im*z.im)),((w.re*z.im)+(w.im*z.re)));
	}
	
	// static method to divide complex numbers
	public static Complex divide(Complex w, Complex z) {
		double quotient_real = ((w.re*z.re)+(w.im*z.im))/((Math.pow(z.re, 2)+Math.pow(z.im, 2)));
		double quotient_im = ((w.im*z.re)-(w.re*z.im))/((Math.pow(z.re, 2)+Math.pow(z.im, 2)));
		return new Complex(quotient_real, quotient_im);
	}
	
	// method for converting to string complex number
	public String toString() {	
			return "Re(w) = "+this.re+", Im(w) = "+this.im;
		}
	public static final Complex ONE = new Complex(1,0); 
	public static final Complex ZERO = new Complex (0,0);
	public static final Complex I = new Complex (0,1);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
