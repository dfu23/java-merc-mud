package merc.enums;

public enum MobileActionBits {

	IS_NPC(1),
	SENTINEL(2),
	SCAVENGER(4),
	AGGRESSIVE(32),
	STAY_AREA(64),
	WIMPY(128),
	PET(256),
	TRAIN(512),
	PRACTICE(1024);
	
	private final int index;
	
	MobileActionBits (int index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
