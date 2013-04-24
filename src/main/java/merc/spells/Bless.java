package merc.spells;

import merc.Communication;
import merc.Handler;
import merc.MudCharacter;
import merc.data.AffectData;
import merc.enums.ApplyAffectType;
import merc.enums.Position;

public class Bless implements SpellFunction {

	public void execute(int sn, int level, MudCharacter character, MudCharacter victim) {
		AffectData af = new AffectData();
		
		if (victim.position == Position.FIGHTING || victim.IS_AFFECTED(sn)) {
			return;
		}
		
		af.type = (short) sn;
		af.duration = (short) (6 + level);
		af.location = ApplyAffectType.HIT_ROLL;
		af.modifier = (short) (level / 8);
		af.bitvector = 0;
		
		Handler.affect_to_char(victim, af);
		Communication.send_to_char("You are righteous", victim);
		if (character != victim) {
			Communication.send_to_char("Ok.", character);
		}
		return;		
	}

}
