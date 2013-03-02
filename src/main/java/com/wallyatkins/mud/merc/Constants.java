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
	 * Strength Attribute bonus table.
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
	
	/*
	 * Intelligence Attribute bonus table.
	 */
	public static final IntelligenceAttribute[] int_app = new IntelligenceAttribute[] {
		new IntelligenceAttribute((short) 3), /* 0 */
		new IntelligenceAttribute((short) 5), /* 1 */
		new IntelligenceAttribute((short) 7),
		new IntelligenceAttribute((short) 8), /* 3 */
		new IntelligenceAttribute((short) 9),
		new IntelligenceAttribute((short) 10), /* 5 */
		new IntelligenceAttribute((short) 11),
		new IntelligenceAttribute((short) 12),
		new IntelligenceAttribute((short) 13),
		new IntelligenceAttribute((short) 15),
		new IntelligenceAttribute((short) 17), /* 10 */
		new IntelligenceAttribute((short) 19),
		new IntelligenceAttribute((short) 22),
		new IntelligenceAttribute((short) 25),
		new IntelligenceAttribute((short) 28),
		new IntelligenceAttribute((short) 31), /* 15 */
		new IntelligenceAttribute((short) 34),
		new IntelligenceAttribute((short) 37),
		new IntelligenceAttribute((short) 40), /* 18 */
		new IntelligenceAttribute((short) 44),
		new IntelligenceAttribute((short) 49), /* 20 */
		new IntelligenceAttribute((short) 55),
		new IntelligenceAttribute((short) 60),
		new IntelligenceAttribute((short) 70),
		new IntelligenceAttribute((short) 85),
		new IntelligenceAttribute((short) 99) /* 25 */
	};

	/*
	 * Wisdom Attribute bonus table.
	 */
	public static final WisdomAttribute[] wis_app = new WisdomAttribute[] {
		new WisdomAttribute((short) 0), /* 0 */
		new WisdomAttribute((short) 0), /* 1 */
		new WisdomAttribute((short) 0),
		new WisdomAttribute((short) 0), /* 3 */
		new WisdomAttribute((short) 0),
		new WisdomAttribute((short) 1), /* 5 */
		new WisdomAttribute((short) 1),
		new WisdomAttribute((short) 1),
		new WisdomAttribute((short) 1),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2), /* 10 */
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 3), /* 15 */
		new WisdomAttribute((short) 3),
		new WisdomAttribute((short) 4),
		new WisdomAttribute((short) 5), /* 18 */
		new WisdomAttribute((short) 5),
		new WisdomAttribute((short) 5), /* 20 */
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 7) /* 25 */
	};
	
	/*
	 * Dexterity Attribute bonus table.
	 */
	public static final DexterityAttribute[] dex_app = new DexterityAttribute[] {
		new DexterityAttribute((short) 60), /* 0 */
		new DexterityAttribute((short) 50), /* 1 */
		new DexterityAttribute((short) 50),
		new DexterityAttribute((short) 40),
		new DexterityAttribute((short) 20),
		new DexterityAttribute((short) 10), /* 5 */
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0), /* 10 */
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) -10), /* 15 */
		new DexterityAttribute((short) -15),
		new DexterityAttribute((short) -20),
		new DexterityAttribute((short) -30),
		new DexterityAttribute((short) -40),
		new DexterityAttribute((short) -50), /* 20 */
		new DexterityAttribute((short) -60),
		new DexterityAttribute((short) -75),
		new DexterityAttribute((short) -90),
		new DexterityAttribute((short) -105),
		new DexterityAttribute((short) -120) /* 25 */
	};
	
	/*
	 * Constitution Attribute bonus table.
	 */
	public static final ConstitutionAttribute[] con_app = new ConstitutionAttribute[] {
		new ConstitutionAttribute((short) -4, (short) 20), /* 0 */
		new ConstitutionAttribute((short) -3, (short) 25), /* 1 */
		new ConstitutionAttribute((short) -2, (short) 30),
		new ConstitutionAttribute((short) -2, (short) 35), /* 3 */
		new ConstitutionAttribute((short) -1, (short) 40),
		new ConstitutionAttribute((short) -1, (short) 45), /* 5 */
		new ConstitutionAttribute((short) -1, (short) 50),
		new ConstitutionAttribute((short) 0, (short) 55),
		new ConstitutionAttribute((short) 0, (short) 60),
		new ConstitutionAttribute((short) 0, (short) 65),
		new ConstitutionAttribute((short) 0, (short) 70), /* 10 */
		new ConstitutionAttribute((short) 0, (short) 75),
		new ConstitutionAttribute((short) 0, (short) 80),
		new ConstitutionAttribute((short) 0, (short) 85),
		new ConstitutionAttribute((short) 0, (short) 88),
		new ConstitutionAttribute((short) 1, (short) 90), /* 15 */
		new ConstitutionAttribute((short) 2, (short) 95),
		new ConstitutionAttribute((short) 2, (short) 97),
		new ConstitutionAttribute((short) 3, (short) 99), /* 18 */
		new ConstitutionAttribute((short) 3, (short) 99),
		new ConstitutionAttribute((short) 4, (short) 99), /* 20 */
		new ConstitutionAttribute((short) 4, (short) 99),
		new ConstitutionAttribute((short) 5, (short) 99),
		new ConstitutionAttribute((short) 6, (short) 99),
		new ConstitutionAttribute((short) 7, (short) 99),
		new ConstitutionAttribute((short) 8, (short) 99) /* 25 */
	};

}
