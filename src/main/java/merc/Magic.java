package merc;

public abstract class Magic {
	
	public static boolean saves_spell(int level, MudCharacter victim) {
		int save;
		
		save = 50 + (victim.level - level - victim.saving_throw) * 5;
		save = Macros.URANGE(5, save, 95);
		return DB.number_percent() < save;
	}
	
}
