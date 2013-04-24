package merc.types;

import merc.spells.SpellFunction;

public class SkillType {

	String name;				/* Name of skill */
	short[] skill_level;		/* Level needed by class */
	SpellFunction spell_fun;	/* Spell pointer (for spells) */
	short target;				/* Legal targets */
	short minimum_position;		/* Position for caster / user */
	short pgsn;					/* Pointer to associated gsn */
	short slot;					/* Slot for #OBJECT loading */
	short min_mana;				/* Minimum mana used */
	short beats;				/* Waiting time after use */
	String noun_damage;			/* Damage message */
	String msg_off;				/* Wear off message */
	
	/**
	 * Sample Skill Data - blindness
	 * name = "blindness"
	 * skill_level = {8, 5, 37, 37} - for the four classes
	 * spell_fun = spell_blindness
	 * target = TAR_CHAR_OFFENSIVE
	 * minimum_position = POS_FIGHTING
	 * pgsn = &gsn_blindness
	 * slot = SLOT(4)
	 * min_mana = 5
	 * beats = 12
	 * noun_damage = "" - no damage
	 * msg_off = "You can see again"
	 */
}
