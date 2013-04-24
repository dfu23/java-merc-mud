package merc;

import merc.data.AffectData;
import merc.data.WeatherData;

public abstract class Globals {
	/*
	 * Max values
	 */
	public final static int MAX_SKILL = 90;
	public final static int MAX_CLASS = 4;
	public final static int MAX_LEVEL = 40;
	
	/*
	 * Hero and Immortal levels
	 */
	public final static int LEVEL_HERO = MAX_LEVEL - 4;
	public final static int LEVEL_IMMORTAL = MAX_LEVEL - 3;
	
	/*
	 * TO types for act.
	 */
	public final static short TO_ROOM = 0;
	public final static short TO_NOTVICT = 1;
	public final static short TO_VICT = 2;
	public final static short TO_CHAR = 3;
	
	/*
	 * Global Skill Numbers
	 */
	public final static short gsn_backstab = 72;
	public final static short gsn_dodge = 74;
	public final static short gsn_hide = 76;
	public final static short gsn_peek = 79;
	public final static short gsn_pick_lock = 80;
	public final static short gsn_sneak = 83;
	public final static short gsn_steal = 84;
	public final static short gsn_disarm = 73;
	public final static short gsn_enhanced_damage = 75;
	public final static short gsn_kick = 77;
	public final static short gsn_parry = 78;
	public final static short gsn_rescue = 81;
	public final static short gsn_second_attack = 82;
	public final static short gsn_third_attack = 85;
	public final static short gsn_blindness = 4;
	public final static short gsn_charm_person = 11;
	public final static short gsn_curse = 24;
	public final static short gsn_invis = 46;
	public final static short gsn_mass_invis = 51;
	public final static short gsn_poison = 53;
	public final static short gsn_sleep = 60;
	
	/*
	 * Time and weather stuff.
	 */
	public final static int SUN_DARK = 0;
	public final static int SUN_RISE = 1;
	public final static int SUN_LIGHT = 2;
	public final static int SUN_SET = 3;
	
	public final static int SKY_CLOUDLESS = 0;
	public final static int SKY_CLOUDY = 1;
	public final static int SKY_RAINING = 2;
	public final static int SKY_LIGHTNING = 3;
	
	// put extern things here?
	public static WeatherData weather_data = new WeatherData();
	public static MudCharacter char_list = new MudCharacter();
	public static AffectData affect_free = null;
}
