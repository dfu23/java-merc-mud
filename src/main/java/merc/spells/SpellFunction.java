package merc.spells;

import merc.MudCharacter;

public interface SpellFunction {
	public void execute(int sn, int level, MudCharacter character, MudCharacter victim);
}
