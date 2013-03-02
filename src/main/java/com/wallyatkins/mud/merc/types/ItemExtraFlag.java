package com.wallyatkins.mud.merc.types;

public enum ItemExtraFlag {
	
	GLOW((short) 1),
	HUM((short) 2),
	DARK((short) 4),
	LOCK((short) 8),
	EVIL((short) 16),
	INVIS((short) 32),
	MAGIC((short) 64),
	NODROP((short) 128),
	BLESS((short) 256),
	ANTI_GOOD((short) 512),
	ANTI_EVIL((short) 1024),
	ANTI_NEUTRAL((short) 2048),
	NOREMOVE((short) 4096),
	INVENTORY((short) 8192);
	
	private final short index;
	
	ItemExtraFlag (short index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
