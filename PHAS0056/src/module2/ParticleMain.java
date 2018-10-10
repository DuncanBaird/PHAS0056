package module2;

public class ParticleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FallingParticle particle = new FallingParticle(4.3,2.4);
		particle.setH(5.0);
		
		particle.drop(0.5);
		System.out.println("Time take to reach bottom is " + particle.getT());
		System.out.println("Velocity at the bottom is " + particle.getV());
		

	}

}
