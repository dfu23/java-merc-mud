package merc.enums;

public enum ObjectVirtualNumber {

	MONEY_ONE((short) 2),
	MONEY_SOME((short) 3),
	
	CORPSE_NPC((short) 10),
	CORPSE_PC((short) 11),
	SEVERED_HEAD((short) 12),
	TORN_HEART((short) 13),
	SLICED_ARM((short) 14),
	SLICED_LEG((short) 15),
	FINAL_TURD((short) 16),
	
	MUSHROOM((short) 20),
	LIGHT_BALL((short) 21),
	SPRING((short) 22),
	
	SCHOOL_MACE((short) 3700),
	SCHOOL_DAGGER((short) 3701),
	SCHOOL_SWORD((short) 3702),
	SCHOOL_VEST((short) 3703),
	SCHOOL_SHIELD((short) 3704),
	SCHOOL_BANNER((short) 3716);
	
	private final short index;
	
	ObjectVirtualNumber (short index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
