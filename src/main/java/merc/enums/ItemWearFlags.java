package merc.enums;

public enum ItemWearFlags {

	TAKE((short) 1),
	WEAR_FINGER((short) 2),
	WEAR_NECK((short) 4),
	WEAR_BODY((short) 8),
	WEAR_HEAD((short) 16),
	WEAR_LEGS((short) 32),
	WEAR_FEET((short) 64),
	WEAR_HANDS((short) 128),
	WEAR_ARMS((short) 256),
	WEAR_SHIELD((short) 512),
	WEAR_ABOUT((short) 1024),
	WEAR_WAIST((short) 2048),
	WEAR_WRIST((short) 4096),
	WIELD((short) 8192),
	HOLD((short) 16384);
	
	private final short index;
	
	ItemWearFlags (short index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
