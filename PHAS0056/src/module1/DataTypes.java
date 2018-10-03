package module1;

public class DataTypes {

	public static void main(String[] args) {
		// assign value to double variable, doubVar and then print name and value
		double doubVar = 5.0;
		System.out.println("The value of doubVar is " + doubVar);
		// assign value to floating point variable, floatVar and then print name and value
		float floatVar = 5;
		System.out.println("The value of floatVar is " + floatVar);
		// assign value to integer variable, intVar and then print name and value
		int intVar = 5;
		System.out.println("The value of intVar is " + intVar);
		// assign value to long variable, longVar and then print name and value
		long longVar = 5;
		System.out.println("The value of longVar is " + longVar);
		// assign value to byte variable, byteVar and then print name and value
		byte byteVar = 5;
		System.out.println("The value of byteVar is " + byteVar);
		
		//// next multiply each variable by itself and print the result
		// multiply value of doubVar by itself and print result
		System.out.println("The value of doubVar multiplied by itself is " + doubVar * doubVar);
		// multiply value of floatVar by itself and print result
		System.out.println("The value of floatVar multiplied by itself is " + floatVar * floatVar);
		// multiply value of intVar by itself and print result
		System.out.println("The value of intVar multiplied by itself is " + intVar * intVar);
		// multiply value of longVar by itself and print result
		System.out.println("The value of longVar multiplied by itself is " + longVar * longVar);
		// multiply value of byteVar by itself and print result
		System.out.println("The value of byteVar multiplied by itself is " + byteVar * byteVar);
		
		//// investigating the output when mixing types
		
		// try combining char and double type
		char charVar = 'a';
		System.out.println(charVar); // should just output assignment of variable
		System.out.println(charVar + 1); // java should read 1 as a double, combines with unicode of char type	
		// try adding double type to char type before print 
		charVar = 'a' + 1;		
		System.out.println(charVar);
		System.out.println(charVar + 1);
		// output statement to explain
		System.out.println("Java is able to combine the double type "
				+ "by adding it to the unicode character value. "
				+ "If done before the print statement the output will "
				+ "be a character, but if addition is done in statement "
				+ "the ouput will be a double. Suggests that java takes "
				+ "the last type as the type.");
		
		// try combining boolean and double
		boolean boolVar = true ;
		/* System.out.println(boolVar + 1); */
		/* boolVar = true+1; */
		System.out.println("Boolean type cannot be combines with double, returns error. "
				+ "Potentially due to the boolean variable being stored as a single bit.");
		
		//try combining byte and short
		byteVar = 1; short shortVar = 126;
		System.out.println(shortVar + byteVar);
		System.out.println(shortVar + 1 + byteVar);
		System.out.println("Byte and Short types can be combined (even past the limit of the "
				+ "8 bit range of the byte type. Thus suggestion above must be false, java "
				+ "presumably takes the most appropriate type available, here the short type.");
		
		//// investigating not initialised variables
		float w = 10; float z;
		/* w = z - 1; */
		System.out.println(w);
		/* System.out.println(z); */
		System.out.println("If a variable (z here) is not initialised or assigned an error is "
				+ "returned when it is used.");
		
		//// investigating double type to integer type casts
		//using doubVar from before, converting to intCast
		doubVar = 4.99;
		System.out.println(doubVar);
		int intCast = (int) doubVar;
		System.out.println(intCast);
		System.out.println("The cast from double type to integer type appears "
				+ "to cut off the decimal places of double variable, normally one "
				+ "would probaly prefer to round up as 4.99 is approx. 5.");
		
				
		
	}

}
