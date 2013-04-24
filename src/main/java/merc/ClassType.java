package merc;

import merc.enums.ApplyAffectType;
import merc.enums.ObjectVirtualNumber;

public class ClassType {
	char[] who_name = new char[4];	/* Three-letter name for 'who'	*/
	ApplyAffectType attr_prime;		/* Prime attribute				*/
	ObjectVirtualNumber weapon;		/* First weapon					*/
	short guild;					/* Vnum of guild room			*/
	short skill_adept;				/* Maximim skill level			*/
	short thac0_00;					/* Thac0 for level 0			*/
	short thac0_32;					/* Thac0 for level 32			*/
	short hp_min;					/* Min HP gained on leveling	*/
	short hp_max;					/* Max HP gained on leveling	*/
	boolean fmana;					/* Class gains mana on level	*/

	public ClassType(char[] who_name, ApplyAffectType attr_prime, ObjectVirtualNumber weapon,
			short guild, short skill_adept, short thac0_00, short thac0_32,
			short hp_min, short hp_max, boolean fmana) {
		super();
		this.who_name = who_name;
		this.attr_prime = attr_prime;
		this.weapon = weapon;
		this.guild = guild;
		this.skill_adept = skill_adept;
		this.thac0_00 = thac0_00;
		this.thac0_32 = thac0_32;
		this.hp_min = hp_min;
		this.hp_max = hp_max;
		this.fmana = fmana;
	}
}
