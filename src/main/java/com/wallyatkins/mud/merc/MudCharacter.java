package com.wallyatkins.mud.merc;

import com.wallyatkins.mud.merc.types.MobileActor;
import com.wallyatkins.mud.merc.types.Position;

/**
 * One character (PC or NPC).
 *
 */
public class MudCharacter {
	
	public MobileActor act;
	public Position position;
	public PlayerCharacterData pcdata;
	public MudObject carrying;
	
	public MudCharacter next;
	public MudCharacter nextInRoom;
	public MudCharacter master;
	public MudCharacter leader;
	public MudCharacter fighting;
	public MudCharacter reply;
	
	public RoomIndexData in_room;
	public RoomIndexData was_in_room;
	
	public Descriptor desc;
	
	public String name;
	public String shortDescription;
	public String longDescription;
	public String description;
	
	public short sex;
	public short clazz;
	public short race;
	public short level;
	public short trust;
	
	public int played;
	public long logon;
	public long save_time;
	public short timer;
	public short wait;
	
	public short hit;
	public short max_hit;
	public short mana;
	public short max_mana;
	public short move;
	public short max_move;
	
	public int gold;
	public int exp;
	public int affected_by;
	
	public short practice;
	public short carry_weight;
	public short carry_number;
	public short saving_throw;
	public short alignment;
	public short hitroll;
	public short damroll;
	public short armor;
	public short wimpy;
	public short deaf;

	/**
	 * Determines if this character is a NPC or a PC
	 * @return
	 */
	public boolean IS_NPC() {
		return Macros.IS_SET(this.act.index(), MobileActor.IS_NPC.index()); 
	}
	
	/**
	 * Determines if this character is an immortal or not.
	 * @return
	 */
	public boolean IS_IMMORTAL() {
		return Handler.get_trust(this) >= Globals.LEVEL_IMMORTAL;
	}
	
	/**
	 * Determines if this character is a hero or not.
	 * @return
	 */
	public boolean IS_HERO() {
		return Handler.get_trust(this) >= Globals.LEVEL_HERO;
	}
	
	// TODO: IS_AFFECTED()
	
	/**
	 * Determines if this character is good or not.
	 * @return
	 */
	public boolean IS_GOOD() {
		return this.alignment >= 350;
	}
	
	/**
	 * Determines if this character is evil or not.
	 * @return
	 */
	public boolean IS_EVIL() {
		return this.alignment <= -350;
	}
	
	/**
	 * Determines if this character is neutral or not.
	 * @return
	 */
	public boolean IS_NEUTRAL() {
		return (!IS_GOOD() && !IS_EVIL());
	}
	
	/**
	 * Determines if this character is awake or not.
	 * @return
	 */
	public boolean IS_AWAKE() {
		return this.position.index() > Position.SLEEPING.index();
	}
	
	/**
	 * Gets the hit roll for this character.
	 * @return
	 */
	public short GET_HITROLL() {
		return (short) (this.hitroll + Constants.str_app[Handler.get_curr_str(this)].tohit);
	}
	
	/**
	 * Gets the damage roll for this character.
	 * @return
	 */
	public short GET_DAMROLL() {
		return (short) (this.damroll + Constants.str_app[Handler.get_curr_str(this)].todam);
	}
}
