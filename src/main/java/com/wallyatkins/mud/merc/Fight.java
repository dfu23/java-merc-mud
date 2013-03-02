package com.wallyatkins.mud.merc;

import com.wallyatkins.mud.merc.types.EquipmentWearLocation;
import com.wallyatkins.mud.merc.types.ItemType;
import com.wallyatkins.mud.merc.types.MobileActor;
import com.wallyatkins.mud.merc.types.Position;
import com.wallyatkins.mud.merc.types.SkillSpell;

public class Fight {
	
	/**
	 * Do one group of attacks.
	 * @param attacker
	 * @param victim
	 * @param damageType
	 */
	public void multiHit(MudCharacter attacker, MudCharacter victim, SkillSpell damageType) {
		
		int chance;
		
		oneHit(attacker, victim, damageType);
		
		if (!attacker.fighting.equals(victim) || damageType.equals(SkillSpell.BACKSTAB)) {
			return;
		}
		
		// Determine the chance for a Second Attack
		if (attacker.IS_NPC()) {
			chance = attacker.level;
		} else {
			// TODO: I do not believe the below logic for chance is correct
			// no able to determine how the skills are learned yet
			chance = attacker.pcdata.learned[SkillSpell.SECOND_ATTACK.ordinal()] / 2; 
		}
		
		// Randomly determine if the chance is made to Second Attack
		if (DB.number_percent() < chance) {
			oneHit(attacker, victim, damageType);
			
			// If no longer attacking then no chance for Third Attack
			if (!attacker.fighting.equals(victim)) {
				return;
			}
		}

		// Determine the chance for a Third Attack
		if (attacker.IS_NPC()) {
			chance = attacker.level;
		} else {
			// TODO: I do not believe the below logic for chance is correct
			// no able to determine how the skills are learned yet
			chance = attacker.pcdata.learned[SkillSpell.THIRD_ATTACK.ordinal()] / 4; 
		}

		// Randomly determine if the chance is made to Third Attack
		if (DB.number_percent() < chance) {
			oneHit(attacker, victim, damageType);
			
			// If no longer attacking then no more chance
			if (!attacker.fighting.equals(victim)) {
				return;
			}
		}

		// Determine the next chance for attack (?)
		if (attacker.IS_NPC()) {
			chance = attacker.level / 2;
		} else {
			chance = 0; 
		}

		// Randomly determine if the chance is made to attack
		if (DB.number_percent() < chance) {
			oneHit(attacker, victim, damageType);
		}
		
		return;
	}

	/**
	 * Hit one guy once.
	 * @param attacker
	 * @param victim
	 * @param damageType
	 */
	private void oneHit(MudCharacter attacker, MudCharacter victim, SkillSpell damageType) {
		
		MudObject wield;
		
		int victim_ac; // armor class
		int thac0; // to hit armor class
		int thac0_00;
		int thac0_32;
		int dam;
		int diceroll;
		
		/*
	     * Can't beat a dead char!
	     * Guard against weird room-leavings.
	     */
		if (victim.position.equals(Position.DEAD) || !attacker.in_room.equals(victim.in_room)) {
			return;
		}
		
		/*
	     * Figure out the type of damage message.
	     */
		wield = Handler.get_eq_char(attacker, EquipmentWearLocation.WIELD);
		if (damageType.equals(SkillSpell.UNDEFINED)) {
			damageType = SkillSpell.HIT;
			if (wield != null && wield.item_type.equals(ItemType.WEAPON)) {
				// TODO: figure out what damageType really is and what wield.value[3] would be
				//damageType += wield.value[3];
			}
	    }
		
		/*
	     * Calculate to-hit-armor-class-0 versus armor.
	     */
		if (attacker.act.equals(MobileActor.IS_NPC)) {
			thac0_00 = 20;
			thac0_32 = 0;
		} else {
			thac0_00 = Constants.class_table[attacker.clazz].thac0_00;
			thac0_32 = Constants.class_table[attacker.clazz].thac0_32;
		}
		thac0 = DB.interpolate(attacker.level, thac0_00, thac0_32) - attacker.GET_HITROLL();
		victim_ac = Macros.UMAX(-15, victim.GET_AC() / 10);
		if (!Handler.can_see(attacker, victim)) {
			victim_ac -= 4;
		}
		
		/*
		 * The moment of excitement!
		 */
		while((diceroll = DB.number_bits(5)) >= 20);
		
		if (diceroll == 0 ||
				(diceroll != 19 && diceroll < thac0 - victim_ac)) {
			/* Miss. */
			damage(attacker, victim, 0, damageType);
			DB.tail_chain();
			return;
		}
		
		/*
		 * Hit.
		 * Calculate damage.
		 */
		if (attacker.IS_NPC()) {
			dam = DB.number_range(attacker.level / 2, attacker.level * 3 / 2);
			if (wield != null) {
				dam += dam / 2;
			}
		} else {
			if (wield != null) {
				dam = DB.number_range(wield.value[1], wield.value[2]);
			} else {
				dam = DB.number_range(1, 4);
			}
		}
		
		/*
		 * Bonuses.
		 */
		dam += attacker.GET_DAMROLL();
		//if (!attacker.IS_NPC() &&
		//		attacker.pcdata > 0) {
		//	
		//}
	}

	/**
	 * Inflict damage from a hit.
	 * @param attacker
	 * @param victim
	 * @param damage
	 * @param damageType
	 */
	private void damage(MudCharacter attacker, MudCharacter victim, int damage, SkillSpell damageType) {
		if (victim.position.index() == Position.DEAD.index()) {
			return;
		}
		
		/*
		 * Stop and residual loopholes
		 */
		if (damage > 1000) {
			// TODO: log a bug - SLF4J?
			//bug("Damage: %d: more than 1000 points!");
			damage = 1000;
		}
		
		// TODO: a lot more damage infliction logic
	}
}
