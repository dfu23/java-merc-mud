package merc;

import merc.enums.EquipmentWearLocation;
import merc.enums.ItemType;
import merc.enums.MobileActor;
import merc.enums.MobileAffectBits;
import merc.enums.Position;
import merc.enums.SkillSpell;

public class Fight {
	
	public void violence_update() {
		MudCharacter character;
		MudCharacter character_next; /* Never used. Not needed? */
		MudCharacter victim;
		MudCharacter r_char;
		MudCharacter r_char_next;
		
		for (character = Globals.char_list; character != null; character = character.next) {
			character_next = character.next;
			
			if ((victim = character.fighting) == null || character.in_room == null) {
				continue;
			}
			
			if (character.IS_AWAKE() && character.in_room == victim.in_room) {
				multi_hit(character, victim, SkillSpell.UNDEFINED);
			} else {
				stop_fighting(character, false);
			}
			
			if ((victim = character.fighting) == null) {
				continue;
			}
			
			/*
			 * Fun for the whole family!
			 */
			for (r_char = character.in_room.people; r_char != null; r_char = r_char_next) {
				r_char_next = r_char.next_in_room;
				
				if (r_char.IS_AWAKE() && r_char.fighting == null) {
					/*
					 * PC's auto-assist others in their group.
					 */
					if (r_char.IS_NPC() || r_char.IS_AFFECTED(MobileAffectBits.CHARM.index())) {
						if (!r_char.IS_NPC() || r_char.IS_AFFECTED(MobileAffectBits.CHARM.index()) || ActionCommunication.is_same_group(character, r_char)) {
							multi_hit(r_char, victim, SkillSpell.UNDEFINED);
						}
						continue;
					}
					
					/*
					 * NPC's assist NPC's of same type or 12.5% chance regardless
					 */
					if (r_char.IS_NPC() && r_char.IS_AFFECTED(MobileAffectBits.CHARM.index())) {
						if (r_char.pIndexData == character.pIndexData || DB.number_bits(3) == 0) {
							MudCharacter vch = null;
							MudCharacter target = null;
							int number = 0;

							for (vch = character.in_room.people; vch != null; vch = vch.next) {
								if (Handler.can_see(r_char, vch) && ActionCommunication.is_same_group(vch, victim) && DB.number_range(0, number) == 0) {
									target = vch;
									number++;
								}
							}
							
							if (target != null) {
								multi_hit(r_char, target, SkillSpell.UNDEFINED);
							}
						}
					}
				}
			}
		}
		
		return;
	}
	
	/**
	 * Do one group of attacks.
	 * @param attacker
	 * @param victim
	 * @param damageType
	 */
	public void multi_hit(MudCharacter attacker, MudCharacter victim, SkillSpell damageType) {
		
		int chance;
		
		one_hit(attacker, victim, damageType);
		if (!attacker.fighting.equals(victim) || damageType.equals(Globals.gsn_backstab)) {
			return;
		}
		
		// Determine the chance for a Second Attack
		if (attacker.IS_NPC()) {
			chance = attacker.level;
		} else {
			chance = attacker.pcdata.learned[Globals.gsn_second_attack] / 2; 
		}
		
		// Randomly determine if the chance is made to Second Attack
		if (DB.number_percent() < chance) {
			one_hit(attacker, victim, damageType);
			
			// If no longer attacking then no chance for Third Attack
			if (!attacker.fighting.equals(victim)) {
				return;
			}
		}

		// Determine the chance for a Third Attack
		if (attacker.IS_NPC()) {
			chance = attacker.level;
		} else {
			chance = attacker.pcdata.learned[Globals.gsn_third_attack] / 4; 
		}

		// Randomly determine if the chance is made to Third Attack
		if (DB.number_percent() < chance) {
			one_hit(attacker, victim, damageType);
			
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
			one_hit(attacker, victim, damageType);
		}
		
		return;
	}

	/**
	 * Hit one guy once.
	 * @param attacker
	 * @param victim
	 * @param damageType
	 */
	private void one_hit(MudCharacter attacker, MudCharacter victim, SkillSpell damageType) {
		
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
	
	private void update_pos(MudCharacter victim) {
		if (victim.hit > 0) {
			if (victim.position.index() <= Position.STUNNED.index()) {
				victim.position = Position.STANDING;
			}
			return;
		}
		
		if (victim.IS_NPC() || victim.hit <= -11) {
			victim.position = Position.DEAD;
			return;
		}
		
		if (victim.hit <= -6) {
			victim.position = Position.MORTAL;
		} else if (victim.hit <= -3) {
			victim.position = Position.INCAPACITATED;
		} else {
			victim.position = Position.STUNNED;
		}
	}
	
	private void stop_fighting(MudCharacter character, boolean both) {
		MudCharacter f_char;
		
		for (f_char = Globals.char_list; f_char != null; f_char = f_char.next) {
			if (f_char == character || (both && f_char.fighting == character)) {
				f_char.fighting = null;
				f_char.position = Position.STANDING;
				update_pos(f_char);
			}
		}
	}
	
}
