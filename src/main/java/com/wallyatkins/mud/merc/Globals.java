package com.wallyatkins.mud.merc;

public abstract class Globals {
	public final static int MAX_SKILL = 90;
	public final static int MAX_CLASS = 4;
	public final static int MAX_LEVEL = 40;
	public final static int LEVEL_HERO = MAX_LEVEL - 4;
	public final static int LEVEL_IMMORTAL = MAX_LEVEL - 3;
	
	/*
	 * Time and weather stuff.
	 */
	public final static int SUN_DARK = 0;
	public final static int SUN_RISE = 1;
	public final static int SUN_LIGHT = 2;
	public final static int SUN_SET = 3;
	
	public final static int SKY_CLOUDLESS = 0;
	public final static int SKY_CLOUDY = 1;
	public final static int SKY_RAINING = 2;
	public final static int SKY_LIGHTNING = 3;
	
	// put extern things here?
	public static WeatherData weather_data = new WeatherData();
}
