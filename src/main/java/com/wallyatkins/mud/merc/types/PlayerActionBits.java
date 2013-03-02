package com.wallyatkins.mud.merc.types;

public enum PlayerActionBits {

	IS_NPC(1),
	BOUGHT_PET(2),
	AUTOEXIT(8),
	AUTOLOOT(16),
	AUTOSAC(32),
	BLANK(64),
	BRIEF(128),
	COMBINE(512),
	PROMPT(1024),
	TELNET_GA(2048),
	HOLYLIGHT(4096),
	WISINVIS(8192),
	SILENCE(32768),
	NO_EMOTE(65536),
	NO_TELL(262144),
	LOG(524288),
	DENY(1048576),
	FREEZE(2097152),
	THIEF(4194304),
	KILLER(8288608);
	
	private final int index;
	
	PlayerActionBits (int index) {
		this.index = index;
	}
	
	public int index() {
		return index;
	}

}
