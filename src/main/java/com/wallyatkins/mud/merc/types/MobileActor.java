package com.wallyatkins.mud.merc.types;

public enum MobileActor {
	IS_NPC(1),			/* Auto set for mobs	*/
	SENTINAL(2),		/* Stays in one room	*/
	SCAVENGER(4),		/* Picks up objects		*/
	AGGRESSIVE(32),		/* Attacks PC's			*/
	STAY_AREA(64),		/* Won't leave area		*/
	WIMPY(128),			/* Flees when hurt		*/
	PET(256),			/* Auto set for pets	*/
	TRAIN(512),			/* Can train PC's		*/
	PRACTICE(1024);		/* Can practice PC's	*/
	
	private final int index;
	
	MobileActor (int index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}
}
