package module3;

import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.lang.Math;


public class Alphabet {

	public static char randomCharacter() {
		Random random = new Random();
		int integer = random.nextInt(127)+1;
		char character = (char) integer;
		return character;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder characters = new StringBuilder(250);
		int total = 0;
		int exceptions = 0;
		
		for (int i=1; i<=400;i++) {
			char character = randomCharacter();
			
			if(Character.isLetterOrDigit(character)) {
				characters.append(character);
				try {
					total += Integer.parseInt(Character.toString(character));
				}
				catch (Exception e) {
					exceptions ++;
				}
			}
			
		}
		System.out.println("The contents of the stringbuilder is: " + characters);
		System.out.println("The number of characters in the StringBuilder is:" + characters.length());
		System.out.println("The sum of all integers here is: " + total);
		System.out.println("The number of exceptions thrown is: " + exceptions);
	}
}
