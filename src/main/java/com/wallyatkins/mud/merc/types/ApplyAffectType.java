package com.wallyatkins.mud.merc.types;

public enum ApplyAffectType {
	
	NONE((short) 0),
	STRENGTH((short) 1),
	DEXTERITY((short) 2),
	INTELLIGENCE((short) 3),
	WISDOM((short) 4),
	CONSTITUTION((short) 5),
	SEX((short) 6),
	CLASS((short) 7),
	LEVEL((short) 8),
	AGE((short) 9),
	HEIGHT((short) 10),
	WEIGHT((short) 11),
	MANA((short) 12),
	HIT((short) 13),
	MOVE((short) 14),
	GOLD((short) 15),
	EXPERIENCE((short) 16),
	ARMOR_CLASS((short) 17),
	HIT_ROLL((short) 18),
	DAMAGE_ROLL((short) 19),
	SAVING_PARALIZE((short) 20),
	SAVING_ROD((short) 21),
	SAVING_PETRIFIED((short) 22),
	SAVING_BREATH((short) 23),
	SAVING_SPELL((short) 24);
	
	private final short index;
	
	ApplyAffectType (short index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
