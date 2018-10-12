package module2;

public class ParticleMain {

	public static void main(String[] args) {
		// Create particle object with mass = 4.3kg and drag = 2.4 kgm^-1
		FallingParticle particle = new FallingParticle(4.3,2.4);
		// set initial particle height to 5m above vessel
		particle.setH(5.0);
		
		// drop particle with varying time intervals(deltaT)
		particle.drop(0.5);
		System.out.println("For time interval dt = 0.5 s");
		System.out.println("Time taken to reach bottom is " + particle.getT() + " s");
		System.out.println("Velocity at the bottom is " + particle.getV() + " ms^-1");
		
		particle.drop(0.1);
		System.out.println("For time interval dt = 0.1 s");
		System.out.println("Time taken to reach bottom is " + particle.getT() + " s");
		System.out.println("Velocity at the bottom is " + particle.getV() + " ms^-1");
		
		particle.drop(0.01);
		System.out.println("For time interval dt = 0.01 s");
		System.out.println("Time taken to reach bottom is " + particle.getT() + " s");
		System.out.println("Velocity at the bottom is " + particle.getV() + " ms^-1");
		
		particle.drop(0.001);
		System.out.println("For time interval dt = 0.001 s");
		System.out.println("Time taken to reach bottom is " + particle.getT() + " s");
		System.out.println("Velocity at the bottom is " + particle.getV() + " ms^-1");
		
		particle.drop(0.0001);
		System.out.println("For time interval dt = 0.0001 s");
		System.out.println("Time taken to reach bottom is " + particle.getT() + " s");
		System.out.println("Velocity at the bottom is " + particle.getV() + " ms^-1");
		
		// brief explanation
		System.out.println("\nBy decreasing the value of the time interval, dT"
				+ "\nwe find that the results for velocity of the"
				+ "\nparticle at the bottom and the time taken to"
				+ "\nreach the bottom become more and more precise"
				+ "\n(and presumably more accurate).");
		
		

	}

}
