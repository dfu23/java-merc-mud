package merc.enums;

public enum ItemType {
	
	LIGHT((short) 1),
	SCROLL((short) 2),
	WAND((short) 3),
	STAFF((short) 4),
	WEAPON((short) 5),
	TREASURE((short) 8),
	ARMOR((short) 9),
	POTION((short) 10),
	FURNITURE((short) 12),
	TRASH((short) 13),
	CONTAINER((short) 15),
	DRINK_CONTAINER((short) 17),
	KEY((short) 18),
	FOOD((short) 19),
	MONEY((short) 20),
	BOAT((short) 22),
	CORPSE_NPC((short) 23),
	CORPSE_PC((short) 24),
	FOUNTAIN((short) 25),
	PILL((short) 26);
	
	private final short index;
	
	ItemType (short index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
