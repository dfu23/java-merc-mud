package merc;

import merc.data.AffectData;
import merc.data.RoomIndexData;
import merc.enums.ApplyAffectType;
import merc.enums.EquipmentWearLocation;
import merc.enums.ItemExtraFlag;
import merc.enums.ItemType;
import merc.enums.MobileActor;
import merc.enums.MobileAffectBits;
import merc.enums.PlayerActionBits;
import merc.enums.RoomFlags;
import merc.enums.RoomSectorTypes;

public abstract class Handler {
		
	/**
	 * Retrieve a character's trusted level for permission checking.
	 * @param character
	 * @return
	 */
	public static int get_trust(MudCharacter character) {
		if (character.desc != null && character.desc.original != null) {
			character = character.desc.original;
		}
		
		if (character.trust != 0) {
			return character.trust;
		}
		
		if (character.IS_NPC() && character.level >= Globals.LEVEL_HERO) {
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
		
		if (character.IS_NPC()) {
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
		
		if (character.IS_NPC()) {
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
		
		if (character.IS_NPC()) {
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
		
		if (character.IS_NPC()) {
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
		
		if (character.IS_NPC()) {
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
		if (!character.IS_NPC() && character.level >= Globals.LEVEL_IMMORTAL) {
			return 1000;
		}
		
		if (!character.IS_NPC() && Macros.IS_SET(character.act.index(), MobileActor.PET.index())) {
			return 0;
		}
		
		return EquipmentWearLocation.MAX_WEAR.index() + 2 * get_curr_dex(character) / 3;
	}	
	
	/**
	 * Retrieves a character's carry capacity.
	 * @param character
	 * @return
	 */
	public static int can_carry_w(MudCharacter character) {
		if (!character.IS_NPC() && character.level >= Globals.LEVEL_IMMORTAL) {
			return 1000000;
		}
		
		if (!character.IS_NPC() && Macros.IS_SET(character.act.index(), MobileActor.PET.index())) {
			return 0;
		}
		
		return Constants.str_app[get_curr_str(character)].carry;
	}
	
	/**
	 * See if a string is one of the names of an object.
	 * @param name
	 * @param list
	 * @return
	 */
	public static boolean is_name(String name, String list) {
		//TODO: complete this logic
		return false;
	}

	/**
	 * Apply or remove an affect to a character.
	 * @param character
	 * @param paf
	 * @param fAdd
	 */
	public static void affect_modify(MudCharacter character, AffectData paf, boolean fAdd) {
		MudObject wield;
		int mod = paf.modifier;
		
		if (fAdd) {
			character.affected_by = Macros.SET_BIT(character.affected_by, paf.bitvector);
		} else {
			character.affected_by = Macros.REMOVE_BIT(character.affected_by, paf.bitvector);
			mod = 0 - mod;
		}
		
		if (character.IS_NPC()) {
			return;
		}
		
		switch (paf.location) {
			case NONE:
				break;
			case STRENGTH:
				character.pcdata.mod_str += mod;
				break;
			case DEXTERITY:
				character.pcdata.mod_dex += mod;
				break;
			case INTELLIGENCE:
				character.pcdata.mod_int += mod;
				break;
			case WISDOM:
				character.pcdata.mod_wis += mod;
				break;
			case CONSTITUTION:
				character.pcdata.mod_con += mod;
				break;
			case SEX:
				character.sex += mod;
				break;
			case CLASS:
				break;
			case LEVEL:
				break;
			case AGE:
				break;
			case HEIGHT:
				break;
			case WEIGHT:
				break;
			case MANA:
				character.mana += mod;
				break;
			case HIT:
				character.max_hit += mod;
				break;
			case MOVE:
				character.max_move += mod;
				break;
			case GOLD:
				break;
			case EXPERIENCE:
				break;
			case ARMOR_CLASS:
				character.armor += mod;
				break;
			case HIT_ROLL:
				character.hitroll += mod;
				break;
			case DAMAGE_ROLL:
				character.damroll += mod;
				break;
			case SAVING_PARALIZE:
				character.saving_throw += mod;
				break;
			case SAVING_ROD:
				character.saving_throw += mod;
				break;
			case SAVING_PETRIFIED:
				character.saving_throw += mod;
				break;
			case SAVING_BREATH:
				character.saving_throw += mod;
				break;
			case SAVING_SPELL:
				character.saving_throw += mod;
				break;
			default:
				// bug("Affect_modifiy: unknown location");
				return;
		}
		
		/*
		 * Check for weapon wielding.
		 * Guard against recursion (for weapons with affects).
		 */
		if ((wield = get_eq_char(character, EquipmentWearLocation.WIELD)) != null && get_obj_weight(wield) > Constants.str_app[get_curr_str(character)].wield) {
			int depth = 0; // was static in the C code?
			if (depth == 0) {
				depth++;
				//TODO: mess with the act() function later - comm.c
				//act("You drop $p.", character, wield, null, Globals.TO_CHAR);
				//act("$n drops $p.", character, wield, null, Globals.TO_ROOM);
				obj_from_char(wield);
				obj_to_room(wield, character.in_room);
				depth--;
			}
		}
	}
	
	/**
	 * Give an affect to a character.
	 * @param character
	 * @param paf
	 */
	public static void affect_to_char(MudCharacter character, AffectData paf) {
		AffectData paf_new = null;
		if (Globals.affect_free == null) {
			//paf_new = alloc_perm();
		} else {
			paf_new = Globals.affect_free;
			Globals.affect_free = Globals.affect_free.next;
		}
		
		paf_new = paf;
		//paf_new.next = character.a
		//character.
		
		affect_modify(character, paf_new, true);
		return;
	}	
	
	/**
	 * Give an object to a character.
	 * @param obj
	 * @param character
	 */
	public static void obj_to_char(MudObject obj, MudCharacter character) {
		obj.next_content = character.carrying;
		character.carrying = obj;
		obj.carried_by = character;
		obj.in_room = null;
		obj.in_obj = null;
		character.carry_number += get_obj_number(obj);
		character.carry_weight += get_obj_weight(obj);
	}
	
	/**
	 * Take and object from its character.
	 * @param obj
	 */
	public static void obj_from_char(MudObject obj) {
		MudCharacter character;
		if ((character = obj.carried_by) == null) {
			//bug("Obj_from_char: null ch.", 0);
			return;
		}
		if (obj.wear_loc != EquipmentWearLocation.NONE) {
			unequip_char(character, obj);
		}
		if (character.carrying == obj) {
			character.carrying = obj.next_content;
		} else {
			MudObject prev;
			for (prev = character.carrying; prev != null; prev = prev.next_content) {
				if (prev.next_content == obj) {
					prev.next_content = obj.next_content;
					break;
				}
			}
			if (prev == null) {
				//bug("Obj_from_char: obj not in list", 0);
			}
		}
		obj.carried_by = null;
		obj.next_content = null;
		character.carry_number -= get_obj_number(obj);
		character.carry_weight -= get_obj_weight(obj);
	}
	
	/**
	 * Find the Armor Class value of an object, including position effect.
	 * @param obj
	 * @param iWear
	 * @return
	 */
	public static int apply_ac(MudObject obj, EquipmentWearLocation iWear) {
		if (obj.item_type != ItemType.ARMOR) {
			return 0;
		}
		switch (iWear) {
			case BODY:
				return 3 * obj.value[0];
			case HEAD:
				return 2 * obj.value[0];
			case LEGS:
				return 2 * obj.value[0];
			case FEET:
				return obj.value[0];
			case HANDS:
				return obj.value[0];
			case ARMS:
				return obj.value[0];
			case SHIELD:
				return obj.value[0];
			case LEFT_FINGER:
				return obj.value[0];
			case RIGHT_FINGER:
				return obj.value[0];
			case NECK_1:
				return obj.value[0];
			case NECK_2:
				return obj.value[0];
			case ABOUT:
				return 2 * obj.value[0];
			case WAIST:
				return obj.value[0];
			case LEFT_WRIST:
				return obj.value[0];
			case RIGHT_WRIST:
				return obj.value[0];
			case HOLD:
				return obj.value[0];
		}
		return 0;
	}

	/**
	 * Find a piece of equipment on a character.
	 * @param character
	 * @param wield
	 * @return
	 */
	public static MudObject get_eq_char(MudCharacter character, EquipmentWearLocation iWear) {
		MudObject object = null;
		for (object = character.carrying; object != null; object = object.next_content) {
			if (object.wear_loc.index() == iWear.index()) {
				return object;
			}
		}
		return null;
	}
	
	/**
	 * Equip a character with an object.
	 * @param character
	 * @param obj
	 * @param iWear
	 */
	public static void equip_char(MudCharacter character, MudObject obj, EquipmentWearLocation iWear) {
		AffectData paf;
		if (get_eq_char(character, iWear) != null) {
			//bug("Equip_char: already equipped (%d).", iWear);
			return;
		}
		// TODO: rest of equip logic
	}
	
	/**
	 * Unequip a character with an object.
	 * @param character
	 * @param obj
	 */
	public static void unequip_char(MudCharacter character, MudObject obj) {
		AffectData paf;
		if (obj.wear_loc == EquipmentWearLocation.NONE) {
			//bug("Unequip_char: already unequipped.", 0);
			return;
		}
		character.armor += apply_ac(obj, obj.wear_loc);
		obj.wear_loc = EquipmentWearLocation.NONE;
		// TODO: rest of unequip logic
	}
	
//	public static int count_obj_list() {
//		
//	}

	/**
	 * Move an object out of a room.
	 * @param obj
	 */
	public static void obj_from_room(MudObject obj) {
		RoomIndexData in_room;
		if ((in_room = obj.in_room) == null) {
			//bug("obj_from_room: NULL", 0);
			return;
		}
		if (obj == in_room.contents) {
			in_room.contents = obj.next_content;
		} else {
			MudObject prev;
			for (prev = in_room.contents; prev != null; prev = prev.next_content) {
				if (prev.next_content == obj) {
					prev.next_content = obj.next_content;
					break;
				}
			}
			if (prev == null) {
				//bug("obj_from_room: obj not found", 0);
				return;
			}
		}
		obj.in_room = null;
		obj.next_content = null;
		return;
	}
	
	/**
	 * Move an obj into a room.
	 * @param obj
	 * @param pRoomIndex
	 */
	public static void obj_to_room(MudObject obj, RoomIndexData pRoomIndex) {
		obj.next_content = pRoomIndex.contents;
		pRoomIndex.contents = obj;
		obj.in_room = pRoomIndex;
		obj.carried_by = null;
		obj.in_obj = null;
		return;
	}
	
	/**
	 * move an object into an object.
	 * @param obj
	 * @param obj_to
	 */
	public static void obj_to_obj(MudObject obj, MudObject obj_to) {
		obj.next_content = obj_to.contains;
		obj_to.contains = obj;
		obj.in_obj = obj_to;
		obj.in_room = null;
		obj.carried_by = null;
		
		for (; obj_to != null; obj_to = obj_to.in_obj) {
			if (obj_to.carried_by != null) {
				obj_to.carried_by.carry_number += get_obj_number(obj);
				obj_to.carried_by.carry_weight += get_obj_weight(obj);
			}
		}
		
		return;
	}
	
	/**
	 * Return number of objects which an object counts as.
	 * @param obj
	 * @return
	 */
	public static int get_obj_number(MudObject obj) {
		int number;
		if (obj.item_type == ItemType.CONTAINER) {
			number = 0;
		} else {
			number = 1;
		}
		for (obj = obj.contains; obj != null; obj = obj.next_content) {
			number += get_obj_number(obj);
		}
		return number;
	}
	
	/**
	 * Return the weight of an object, including weight of contents.
	 * @param obj
	 * @return
	 */
	public static int get_obj_weight(MudObject obj) {
		int weight;
		weight = obj.weight;
		for (obj = obj.contains; obj != null; obj = obj.next_content) {
			weight += get_obj_weight(obj);
		}
		return weight;
	}
	
	/**
	 * True if room is dark.
	 * @param roomIndex
	 * @return
	 */
	public static boolean room_is_dark(RoomIndexData roomIndex) {
		if (roomIndex.light > 0) {
			return false;
		}
		
		if (Macros.IS_SET(roomIndex.room_flags, RoomFlags.DARK.index())) {
			return true;
		}
		
		if (roomIndex.sector_type == RoomSectorTypes.INSIDE.index() || roomIndex.sector_type == RoomSectorTypes.CITY.index()) {
			return false;
		}
		
		// weather_info
		if (Globals.weather_data.sunlight == Globals.SUN_SET || Globals.weather_data.sunlight == Globals.SUN_DARK)  {
			return true;
		}
		
		return false;
	}
	
	/**
	 * True if a character can see victim.
	 * @param character
	 * @param victim
	 * @return
	 */
	public static boolean can_see(MudCharacter character, MudCharacter victim) {
		if (character.equals(victim)) {
			return true;
		}
		
		if (!victim.IS_NPC() &&
				Macros.IS_SET(victim.act.index(), PlayerActionBits.WISINVIS.index()) &&
				get_trust(character) < get_trust(victim)) {
			return false;
		}
		
		if (!victim.IS_NPC() &&
				Macros.IS_SET(character.act.index(), PlayerActionBits.HOLYLIGHT.index())) {
			return true;
		}
		
		if (character.IS_AFFECTED(MobileAffectBits.BLIND.index())) {
			return false;
		}
		
		if (room_is_dark(character.in_room) &&
				!character.IS_AFFECTED(MobileAffectBits.INFRARED.index())) {
			return false;
		}
		
		if (victim.IS_AFFECTED(MobileAffectBits.INVISIBLE.index()) &&
				!character.IS_AFFECTED(MobileAffectBits.DETECT_INVIS.index())) {
			return false;
		}
		
		if (victim.IS_AFFECTED(MobileAffectBits.HIDE.index()) &&
				!character.IS_AFFECTED(MobileAffectBits.DETECT_HIDDEN.index()) &&
				victim.fighting == null &&
				character.IS_NPC() ? !victim.IS_NPC() : victim.IS_NPC()) {
			return false;
		}
		
		return true;
	}

	/**
	 * True if character can see object.
	 * @param character
	 * @param object
	 * @return
	 */
	public static boolean can_see_obj(MudCharacter character, MudObject object) {
		if (!character.IS_NPC() &&
				Macros.IS_SET(character.act.index(), PlayerActionBits.HOLYLIGHT.index())) {
			return true;
		}
		
		if (object.item_type.index() == ItemType.POTION.index()) {
			return true;
		}
		
		if (character.IS_AFFECTED(MobileAffectBits.BLIND.index())) {
			return false;
		}
		
		if (object.item_type.index() == ItemType.LIGHT.index() &&
				object.value[2] != 0) {
			return true;
		}
		
		if (room_is_dark(character.in_room) &&
				!character.IS_AFFECTED(MobileAffectBits.INFRARED.index())) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * True if character can drop object.
	 * @param character
	 * @param object
	 * @return
	 */
	public static boolean can_drop_obj(MudCharacter character, MudObject object) {
		if (!Macros.IS_SET(object.extra_flags, ItemExtraFlag.NODROP.index())) {
			return true;
		}
		
		if (!character.IS_NPC() &&
				character.level >= Globals.LEVEL_IMMORTAL) {
			return true;
		}
		
		return false;
	}
	
	
}
