package com.wallyatkins.mud.merc;

import com.wallyatkins.mud.merc.types.ApplyAffectType;
import com.wallyatkins.mud.merc.types.ObjectVirtualNumber;

public abstract class Constants {
	
	/*
	 * Class Table 
	 */
	public static final ClassType[] class_table = new ClassType[] {
			new ClassType("Mag".toCharArray(),
					ApplyAffectType.INTELLIGENCE,
					ObjectVirtualNumber.SCHOOL_DAGGER,
					(short) 3018,
					(short) 95,
					(short) 18,
					(short) 10,
					(short) 6,
					(short) 8,
					true
			),
			new ClassType("Cle".toCharArray(),
					ApplyAffectType.WISDOM,
					ObjectVirtualNumber.SCHOOL_MACE,
					(short) 3003,
					(short) 95,
					(short) 18,
					(short) 12,
					(short) 7,
					(short) 10,
					true
			),
			new ClassType("Thi".toCharArray(),
					ApplyAffectType.DEXTERITY,
					ObjectVirtualNumber.SCHOOL_DAGGER,
					(short) 3028,
					(short) 85,
					(short) 18,
					(short) 8,
					(short) 8,
					(short) 13,
					false
			),
			new ClassType("War".toCharArray(),
					ApplyAffectType.STRENGTH,
					ObjectVirtualNumber.SCHOOL_SWORD,
					(short) 3022,
					(short) 85,
					(short) 18,
					(short) 6,
					(short) 11,
					(short) 15,
					false
			)
	};
	
	/*
	 * Strength Attribute bonus table;
	 */
	public static final StrengthAttribute[] str_app = new StrengthAttribute[] {
		new StrengthAttribute((short) -5, (short) -4, (short) 0, (short) 0), /* 0 */
		new StrengthAttribute((short) -5, (short) -4, (short) 3, (short) 1), /* 1 */
		new StrengthAttribute((short) -3, (short) -2, (short) 3, (short) 2),
		new StrengthAttribute((short) -3, (short) -1, (short) 10, (short) 3), /* 3 */
		new StrengthAttribute((short) -2, (short) -1, (short) 25, (short) 4),
		new StrengthAttribute((short) -2, (short) -1, (short) 55, (short) 5), /* 5 */
		new StrengthAttribute((short) -1, (short) 0, (short) 80, (short) 6),
		new StrengthAttribute((short) -1, (short) 0, (short) 90, (short) 7),
		new StrengthAttribute((short) 0, (short) 0, (short) 100, (short) 8),
		new StrengthAttribute((short) 0, (short) 0, (short) 100, (short) 9),
		new StrengthAttribute((short) 0, (short) 0, (short) 115, (short) 10), /* 10 */
		new StrengthAttribute((short) 0, (short) 0, (short) 115, (short) 11),
		new StrengthAttribute((short) 0, (short) 0, (short) 140, (short) 12),
		new StrengthAttribute((short) 0, (short) 0, (short) 140, (short) 13), /* 13 */
		new StrengthAttribute((short) 0, (short) 1, (short) 170, (short) 14),
		new StrengthAttribute((short) 1, (short) 1, (short) 170, (short) 15), /* 15 */
		new StrengthAttribute((short) 1, (short) 2, (short) 195, (short) 16),
		new StrengthAttribute((short) 2, (short) 3, (short) 220, (short) 22),
		new StrengthAttribute((short) 2, (short) 4, (short) 250, (short) 25), /* 18 */
		new StrengthAttribute((short) 3, (short) 5, (short) 400, (short) 30),
		new StrengthAttribute((short) 3, (short) 6, (short) 500, (short) 35), /* 20 */
		new StrengthAttribute((short) 4, (short) 7, (short) 600, (short) 40),
		new StrengthAttribute((short) 5, (short) 7, (short) 700, (short) 45),
		new StrengthAttribute((short) 6, (short) 8, (short) 800, (short) 50),
		new StrengthAttribute((short) 8, (short) 10, (short) 900, (short) 55),
		new StrengthAttribute((short) 10, (short) 12, (short) 999, (short) 60) /* 25 */
	};

}
