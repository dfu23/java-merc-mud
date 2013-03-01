package com.wallyatkins.mud.merc;

import com.wallyatkins.mud.merc.types.ApplyAffectType;
import com.wallyatkins.mud.merc.types.EquipmentWearLocation;
import com.wallyatkins.mud.merc.types.MobileActor;

public abstract class Handler {
	
	public static int get_trust(MudCharacter character) {
		if (character.desc != null && character.desc.original != null) {
			character = character.desc.original;
		}
		
		if (character.trust != 0) {
			return character.trust;
		}
		
		if (character.act.equals(MobileActor.IS_NPC) && character.level >= Globals.LEVEL_HERO) {
			return Globals.LEVEL_HERO - 1;
		} else {
			return character.level;
		}
	}
	
	/**
	 * Retrieve a character's age.
	 * @param character
	 * @return
	 */
	public static int get_age(MudCharacter character) {
		return 17 + (character.played + (int) (System.currentTimeMillis() - character.logon)) / 7200;
	}
	
	/**
	 * Retrieve character's current strength.
	 * @param character
	 * @return
	 */
	public static int get_curr_str(MudCharacter character) {
		int max;
		
		if (character.act.equals(MobileActor.IS_NPC)) {
			return 13;
		}
		
		if (Constants.class_table[character.clazz].attr_prime.equals(ApplyAffectType.STRENGTH)) {
			max = 25;
		} else {
			max = 20;
		}
		
		return Macros.URANGE(3, character.pcdata.perm_str + character.pcdata.mod_str, max);
	}

	/**
	 * Retrieve character's current intelligence.
	 * @param character
	 * @return
	 */
	public static int get_curr_int(MudCharacter character) {
		int max;
		
		if (character.act.equals(MobileActor.IS_NPC)) {
			return 13;
		}
		
		if (Constants.class_table[character.clazz].attr_prime.equals(ApplyAffectType.INTELLIGENCE)) {
			max = 25;
		} else {
			max = 20;
		}
		
		return Macros.URANGE(3, character.pcdata.perm_int + character.pcdata.mod_int, max);
	}

	/**
	 * Retrieve character's current wisdom.
	 * @param character
	 * @return
	 */
	public static int get_curr_wis(MudCharacter character) {
		int max;
		
		if (character.act.equals(MobileActor.IS_NPC)) {
			return 13;
		}
		
		if (Constants.class_table[character.clazz].attr_prime.equals(ApplyAffectType.WISDOM)) {
			max = 25;
		} else {
			max = 20;
		}
		
		return Macros.URANGE(3, character.pcdata.perm_wis + character.pcdata.mod_wis, max);
	}

	/**
	 * Retrieve character's current dexterity.
	 * @param character
	 * @return
	 */
	public static int get_curr_dex(MudCharacter character) {
		int max;
		
		if (character.act.equals(MobileActor.IS_NPC)) {
			return 13;
		}
		
		if (Constants.class_table[character.clazz].attr_prime.equals(ApplyAffectType.DEXTERITY)) {
			max = 25;
		} else {
			max = 20;
		}
		
		return Macros.URANGE(3, character.pcdata.perm_dex + character.pcdata.mod_dex, max);
	}

	/**
	 * Retrieve character's current constitution.
	 * @param character
	 * @return
	 */
	public static int get_curr_con(MudCharacter character) {
		int max;
		
		if (character.act.equals(MobileActor.IS_NPC)) {
			return 13;
		}
		
		if (Constants.class_table[character.clazz].attr_prime.equals(ApplyAffectType.CONSTITUTION)) {
			max = 25;
		} else {
			max = 20;
		}
		
		return Macros.URANGE(3, character.pcdata.perm_con + character.pcdata.mod_con, max);
	}
	
	/**
	 * Retrieve a character's number of carry capacity.
	 * @param character
	 * @return
	 */
	public static int can_carry_n(MudCharacter character) {
		if (!character.act.equals(MobileActor.IS_NPC) && character.level >= Globals.LEVEL_IMMORTAL) {
			return 1000;
		}
		
		if (!character.act.equals(MobileActor.IS_NPC) && Macros.IS_SET(character.act.index(), MobileActor.PET.index())) {
			return 0;
		}
		
		return EquipmentWearLocation.MAX_WEAR.index() + 2 * get_curr_dex(character) / 3;
	}
	
	public static int can_carry_w(MudCharacter character) {
		if (!character.act.equals(MobileActor.IS_NPC) && character.level >= Globals.LEVEL_IMMORTAL) {
			return 1000000;
		}
		
		if (!character.act.equals(MobileActor.IS_NPC) && Macros.IS_SET(character.act.index(), MobileActor.PET.index())) {
			return 0;
		}
		
		return Constants.str_app[get_curr_str(character)].carry;
	}

	/**
	 * Find a piece of equipment on a character.
	 * @param character
	 * @param wield
	 * @return
	 */
	public static MudObject get_eq_char(MudCharacter character, EquipmentWearLocation wear) {
		MudObject object = null;
		for (object = character.carrying; object != null; object = object.next_content) {
			if (object.wear_loc.index() == wear.index()) {
				return object;
			}
		}
		return null;
	}

}
