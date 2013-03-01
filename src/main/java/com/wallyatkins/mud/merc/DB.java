package com.wallyatkins.mud.merc;

import java.util.Random;

public abstract class DB {
	
	private static final Random random = new Random();
	
	/*
	 * Generate a percentile roll.
	 */
	public static int number_percent() {
		int percent;
		while ((percent = random.nextInt() & (128-1)) > 99);
		return 1 + percent;
	}
	
	/*
	 * Simple linear interpolation.
	 */
	public static int interpolate(int level, int value_00, int value_32) {
		return value_00 + level * (value_32 - value_00) / 32;
	}
}
