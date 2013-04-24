package merc.enums;

public enum Position {
	
	DEAD((short) 0),
	MORTAL((short) 1),
	INCAPACITATED((short) 2),
	STUNNED((short) 3),
	SLEEPING((short) 4),
	RESTING((short) 5),
	FIGHTING((short) 6),
	STANDING((short) 7);
	
	private final short index;
	
	Position (short index) {
		this.index = index;
	}
	
	public short index() {
		return index;
	}

}
