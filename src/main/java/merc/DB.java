package merc;

import java.util.Random;

public abstract class DB {
	
	// Using Java's random in place of number_mm()
	private static final Random random = new Random();
	
	/*
	 * Stick a little fuzz on a number.
	 */
	public static int number_fuzzy(int number) {
		switch (number_bits(2)) {
			case 0:
				number -= 1;
				break;
			case 3:
				number += 1;
				break;
		}
		
		return Macros.UMAX(1, number);
	}
	
	/*
	 * Generate a random number.
	 */
	public static int number_range(int from, int to) {
		int power;
		int number;
		
		if ((to = to - from + 1) <= 1) {
			return from;
		}
		
		for (power = 2; power < to; power <<= 1) {
			
		}
		
		while ((number = random.nextInt() & (power - 1)) >= to);
		
		return from + number;
	}
	
	/*
	 * Generate a percentile roll.
	 */
	public static int number_percent() {
		int percent;
		while ((percent = random.nextInt() & (128 - 1)) > 99);
		return 1 + percent;
	}
	
	/*
	 * Generate a random door.
	 */
	public static int number_door() {
		int door;
		while ((door = random.nextInt() & (8 - 1)) > 5);
		return door;
	}
	
	/*
	 * Simple linear interpolation.
	 */
	public static int interpolate(int level, int value_00, int value_32) {
		return value_00 + level * (value_32 - value_00) / 32;
	}
	
	/*
	 * 
	 */
	public static int number_bits(int width) {
		return random.nextInt() & ((1 << width) - 1);
	}
	
	/*
	 * Roll some dice.
	 */
	public static int dice(int number, int size) {
		int idice;
		int sum;
		
		switch (size) {
			case 0: return 0;
			case 1: return number;
		}
		
		for (idice = 0, sum = 0; idice < number; idice++) {
			sum += number_range(1, size);
		}
		
		return sum;
	}
	
	// Need to explore if this is needed in the world of Java (?)
	// After initial research I think this won't be needed ...
	// Eh, leave it for now.
	public static void tail_chain() {
		return;
	}
	
}
