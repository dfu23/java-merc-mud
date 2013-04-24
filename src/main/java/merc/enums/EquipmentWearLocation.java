package merc.enums;

public enum EquipmentWearLocation {

	NONE((short) -1),
	LIGHT((short) 0),
	LEFT_FINGER((short) 1),
	RIGHT_FINGER((short) 2),
	NECK_1((short) 3),
	NECK_2((short) 4),
	BODY((short) 5),
	HEAD((short) 6),
	LEGS((short) 7),
	FEET((short) 8),
	HANDS((short) 9),
	ARMS((short) 10),
	SHIELD((short) 11),
	ABOUT((short) 12),
	WAIST((short) 13),
	LEFT_WRIST((short) 14),
	RIGHT_WRIST((short) 15),
	WIELD((short) 16),
	HOLD((short) 17),
	MAX_WEAR((short) 18);
	
	private final short index;
	
	EquipmentWearLocation (short index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
