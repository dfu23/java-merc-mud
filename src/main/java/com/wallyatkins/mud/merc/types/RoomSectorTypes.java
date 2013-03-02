package com.wallyatkins.mud.merc.types;

public enum RoomSectorTypes {
	
	INSIDE((short) 0),
	CITY((short) 1),
	FIELD((short) 2),
	FOREST((short) 3),
	HILLS((short) 4),
	MOUNTAIN((short) 5),
	WATER_SWIM((short) 6),
	WATER_NOSWIM((short) 7),
	UNUSED((short) 8),
	AIR((short) 9),
	DESERT((short) 10),
	MAX((short) 11);
	
	private final short index;
	
	RoomSectorTypes (short index) {
		this.index = index;
	}
	
	public short index() {
		return index;
	}

}
