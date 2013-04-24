package merc.spells;

import merc.Communication;
import merc.Handler;
import merc.Magic;
import merc.MudCharacter;
import merc.data.AffectData;
import merc.enums.ApplyAffectType;
import merc.enums.MobileAffectBits;

public class Blindness implements SpellFunction {

	public void execute(int sn, int level, MudCharacter character, MudCharacter victim) {
		AffectData af = new AffectData();
		
		if (victim.IS_AFFECTED(MobileAffectBits.BLIND.index()) || Magic.saves_spell(level, victim)) {
			return;
		}
		
		af.type = (short) sn;
		af.location = ApplyAffectType.HIT_ROLL;
		af.modifier = -4;
		af.duration = (short) (1 + level);
		af.bitvector = MobileAffectBits.BLIND.index();
		
		Handler.affect_to_char(victim, af);
		Communication.send_to_char("You are blinded!", victim);
		if (character != victim) {
			Communication.send_to_char("Ok.", character);
		}
		return;
	}

}
