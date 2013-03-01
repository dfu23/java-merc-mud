package com.wallyatkins.mud.merc;

public class PlayerCharacterData {
	public PlayerCharacterData next;
	
	public String pwd;
	public String bamfin;
	public String bamfout;
	public String title;
	
	public short perm_str;
	public short perm_int;
	public short perm_wis;
	public short perm_dex;
	public short perm_con;
	
	public short mod_str;
	public short mod_int;
	public short mod_wis;
	public short mod_dex;
	public short mod_con;
	
	public short[] condition = new short[3];
	public short[] learned = new short[90]; // From merc.h MAX_SKILL
}
