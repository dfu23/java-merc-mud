package merc.enums;

public enum RoomFlags {

	DARK((short) 1),
	NO_MOB((short) 4),
	INDOORS((short) 8),
	PRIVATE((short) 512),
	SAFE((short) 1024),
	SOLITARY((short) 2048),
	PET_SHOP((short) 4096),
	NO_RECALL((short) 8192);
	
	private final short index;
	
	RoomFlags (short index) {
		this.index = index;
	}
	
	public short index() {
		return index;
	}

}
