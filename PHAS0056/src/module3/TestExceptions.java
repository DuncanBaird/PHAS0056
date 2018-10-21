package module3;

public class TestExceptions {

	public static void main(String[] args) {
		// Testing Complex, ThreeVector and FallingParticle classes
		
		//// Complex
		Complex w = new Complex(0,0);
		Complex z = new Complex(1,0);
		
		System.out.println("Complex number w is " +w);
		System.out.println("Complex number z is " +z);
		
		try { // attempt z/0 type calculation
			System.out.println(Complex.divide(z, w));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try { // attempt to normalise 0
			System.out.println(w.normalised());
		}
		catch (Exception e) {
			System.out.println(e);
		}		
		
		//// ThreeVector
		ThreeVector v1 = new ThreeVector(0,0,0);
		ThreeVector v2 = new ThreeVector(2,2,2);
		
		System.out.println("Vector v1 is " + v1);
		System.out.println("Vector v2 is " + v2);
		
		try { // attempt to find unitvector
			System.out.println(v1.unitVector());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		try { // attempt to find angle
			System.out.println(ThreeVector.angle(v1, v2));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//// FallingParticle
		/*FallingParticle particle = null;*/
		try { // attempt to drop negative mass
			new FallingParticle(-5,2);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		try { // attempt to drop with negative drag
			new FallingParticle(5,-2);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		try { // attempt to drop from below bottom
			FallingParticle particle = new FallingParticle(10,5);
			particle.setH(-10);
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
