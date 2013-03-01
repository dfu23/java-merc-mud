package com.wallyatkins.mud.merc;

// Most or all of these can probably be replace by
// internal Java libraries like Math, etc.
public abstract class Macros {
	
	public static int UMIN(int a, int b) {
		return a < b ? a : b;  
	}
	
	public static int UMAX(int a, int b) {
		return a > b ? a : b;
	}
	
	public static int URANGE(int a, int b, int c) {
		return b < a ? a : b > c ? c: b;
	}
	
	public static boolean IS_SET(int flag, int bit) {
		return (flag & bit) != 0; // I think this is right?
	}
}
