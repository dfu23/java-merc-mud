package merc.enums;

public enum MobileAffectBits {

	BLIND(1),
	INVISIBLE(2),
	DETECT_EVIL(4),
	DETECT_INVIS(8),
	DETECT_MAGIC(16),
	DETECT_HIDDEN(32),
	HOLD(64),
	SANCTUARY(128),
	FAERIE_FIRE(256),
	INFRARED(512),
	CURSE(1024),
	FLAMING(2048),
	POISON(4096),
	PROTECT(8192),
	PARALYSIS(16384),
	SNEAK(32768),
	HIDE(65536),
	SLEEP(131072),
	CHARM(262144),
	FLYING(524288),
	PASS_DOOR(1048576);
	
	private final int index;
	
	MobileAffectBits (int index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
