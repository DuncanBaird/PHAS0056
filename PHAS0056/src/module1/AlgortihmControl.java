package module1;

public class AlgortihmControl {

	public static void loop() {
		// loop for printing integers from 1 to 8
		for(int i = 1; i <= 8; i++) {
			System.out.println(i);
			
		}
	}
	public static void decrement() {
		// loop for printing integers from 10 to -5
		for(int i = 10; i >= -5; i--) {
			System.out.println(i);
			
		}

	}
	public static void increment() {
		// loop for printing 2.5 to 4.3 in 0.1 increments
		for(double i = 25 ; i <= 43; i++) {
			System.out.println(i/10);
			
		}
	}
	public static int timer(double maxTime, int loopSteps) {
		// timer method
		// initialise variables
		long timeNow = System.currentTimeMillis();
		int loops = 0;
		float timeDif = 0;
		// while loop to loop until maxTime time has passed
		while(timeDif < (maxTime*1000)) {
			timeDif = System.currentTimeMillis() - timeNow;
			loops++;
			if(loops % loopSteps == 0) { // if statement to print the number of loops every hundred loops
				System.out.println("The number of Timer loops run so far is " + loops);
			}	
		}
		return loops;
	}
	
	public static void main(String[] args) {
		//// Calling methods from above
		System.out.println("Result of loop method is");
		loop();
		System.out.println("Result of decrement method is:");
		decrement();
		System.out.println("Result of increment method is:");
		increment();
		System.out.println("Result of timer method is:");
		int loopsTotal = timer(5,100);
		System.out.println("Total loops run is " + loopsTotal);
		int loopsTotal2 = timer(10,50000);
		System.out.println("Total loops run is " + loopsTotal2);
		System.out.println("Why result?");
		
	}

}
