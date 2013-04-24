package merc;

import merc.attributes.ConstitutionAttribute;
import merc.attributes.DexterityAttribute;
import merc.attributes.IntelligenceAttribute;
import merc.attributes.StrengthAttribute;
import merc.attributes.WisdomAttribute;
import merc.enums.ApplyAffectType;
import merc.enums.ObjectVirtualNumber;
import merc.types.LiquidType;

public abstract class Constants {
	
	/*
	 * Class Table 
	 */
	public static final ClassType[] class_table = new ClassType[] {
			new ClassType("Mag".toCharArray(),
					ApplyAffectType.INTELLIGENCE,
					ObjectVirtualNumber.SCHOOL_DAGGER,
					(short) 3018,
					(short) 95,
					(short) 18,
					(short) 10,
					(short) 6,
					(short) 8,
					true
			),
			new ClassType("Cle".toCharArray(),
					ApplyAffectType.WISDOM,
					ObjectVirtualNumber.SCHOOL_MACE,
					(short) 3003,
					(short) 95,
					(short) 18,
					(short) 12,
					(short) 7,
					(short) 10,
					true
			),
			new ClassType("Thi".toCharArray(),
					ApplyAffectType.DEXTERITY,
					ObjectVirtualNumber.SCHOOL_DAGGER,
					(short) 3028,
					(short) 85,
					(short) 18,
					(short) 8,
					(short) 8,
					(short) 13,
					false
			),
			new ClassType("War".toCharArray(),
					ApplyAffectType.STRENGTH,
					ObjectVirtualNumber.SCHOOL_SWORD,
					(short) 3022,
					(short) 85,
					(short) 18,
					(short) 6,
					(short) 11,
					(short) 15,
					false
			)
	};
	
	/*
	 * Titles
	 */
	public static final String[][][] title_table = new String[][][] {
		{
	        { "Man",                        "Woman"                         },

	        { "Apprentice of Magic",        "Apprentice of Magic"           },
	        { "Spell Student",              "Spell Student"                 },
	        { "Scholar of Magic",           "Scholar of Magic"              },
	        { "Delver in Spells",           "Delveress in Spells"           },
	        { "Medium of Magic",            "Medium of Magic"               },

	        { "Scribe of Magic",            "Scribess of Magic"             },
	        { "Seer",                       "Seeress"                       },
	        { "Sage",                       "Sage"                          },
	        { "Illusionist",                "Illusionist"                   },
	        { "Abjurer",                    "Abjuress"                      },

	        { "Invoker",                    "Invoker"                       },
	        { "Enchanter",                  "Enchantress"                   },
	        { "Conjurer",                   "Conjuress"                     },
	        { "Magician",                   "Witch"                         },
	        { "Creator",                    "Creator"                       },

	        { "Savant",                     "Savant"                        },
	        { "Magus",                      "Craftess"                      },
	        { "Wizard",                     "Wizard"                        },
	        { "Warlock",                    "War Witch"                     },
	        { "Sorcerer",                   "Sorceress"                     },

	        { "Elder Sorcerer",             "Elder Sorceress"               },
	        { "Grand Sorcerer",             "Grand Sorceress"               },
	        { "Great Sorcerer",             "Great Sorceress"               },
	        { "Golem Maker",                "Golem Maker"                   },
	        { "Greater Golem Maker",        "Greater Golem Maker"           },

	        { "Maker of Stones",            "Maker of Stones",              },
	        { "Maker of Potions",           "Maker of Potions",             },
	        { "Maker of Scrolls",           "Maker of Scrolls",             },
	        { "Maker of Wands",             "Maker of Wands",               },
	        { "Maker of Staves",            "Maker of Staves",              },

	        { "Demon Summoner",             "Demon Summoner"                },
	        { "Greater Demon Summoner",     "Greater Demon Summoner"        },
	        { "Dragon Charmer",             "Dragon Charmer"                },
	        { "Greater Dragon Charmer",     "Greater Dragon Charmer"        },
	        { "Master of all Magic",        "Master of all Magic"           },

	        { "Mage Hero",                  "Mage Heroine"                  },
	        { "Angel of Magic",             "Angel of Magic"                },
	        { "Deity of Magic",             "Deity of Magic"                },
	        { "Supremity of Magic",         "Supremity of Magic"            },
	        { "Implementor",                "Implementress"                 }
	    },{
	        { "Man",                        "Woman"                         },

	        { "Believer",                   "Believer"                      },
	        { "Attendant",                  "Attendant"                     },
	        { "Acolyte",                    "Acolyte"                       },
	        { "Novice",                     "Novice"                        },
	        { "Missionary",                 "Missionary"                    },

	        { "Adept",                      "Adept"                         },
	        { "Deacon",                     "Deaconess"                     },
	        { "Vicar",                      "Vicaress"                      },
	        { "Priest",                     "Priestess"                     },
	        { "Minister",                   "Lady Minister"                 },

	        { "Canon",                      "Canon"                         },
	        { "Levite",                     "Levitess"                      },
	        { "Curate",                     "Curess"                        },
	        { "Monk",                       "Nun"                           },
	        { "Healer",                     "Healess"                       },

	        { "Chaplain",                   "Chaplain"                      },
	        { "Expositor",                  "Expositress"                   },
	        { "Bishop",                     "Bishop"                        },
	        { "Arch Bishop",                "Arch Lady of the Church"       },
	        { "Patriarch",                  "Matriarch"                     },

	        { "Elder Patriarch",            "Elder Matriarch"               },
	        { "Grand Patriarch",            "Grand Matriarch"               },
	        { "Great Patriarch",            "Great Matriarch"               },
	        { "Demon Killer",               "Demon Killer"                  },
	        { "Greater Demon Killer",       "Greater Demon Killer"          },

	        { "Cardinal of the Sea",        "Cardinal of the Sea"           },
	        { "Cardinal of the Earth",      "Cardinal of the Earth"         },
	        { "Cardinal of the Air",        "Cardinal of the Air"           },
	        { "Cardinal of the Ether",      "Cardinal of the Ether"         },
	        { "Cardinal of the Heavens",    "Cardinal of the Heavens"       },

	        { "Avatar of an Immortal",      "Avatar of an Immortal"         },
	        { "Avatar of a Deity",          "Avatar of a Deity"             },
	        { "Avatar of a Supremity",      "Avatar of a Supremity"         },
	        { "Avatar of an Implementor",   "Avatar of an Implementor"      },
	        { "Master of all Divinity",     "Mistress of all Divinity"      },

	        { "Holy Hero",                  "Holy Heroine"                  },
	        { "Angel",                      "Angel"                         },
	        { "Deity",                      "Deity"                         },
	        { "Supreme Master",             "Supreme Mistress"              },
	        { "Implementor",                "Implementress"                 }
	    },{
	        { "Man",                        "Woman"                         },

	        { "Pilferer",                   "Pilferess"                     },
	        { "Footpad",                    "Footpad"                       },
	        { "Filcher",                    "Filcheress"                    },
	        { "Pick-Pocket",                "Pick-Pocket"                   },
	        { "Sneak",                      "Sneak"                         },

	        { "Pincher",                    "Pincheress"                    },
	        { "Cut-Purse",                  "Cut-Purse"                     },
	        { "Snatcher",                   "Snatcheress"                   },
	        { "Sharper",                    "Sharpress"                     },
	        { "Rogue",                      "Rogue"                         },

	        { "Robber",                     "Robber"                        },
	        { "Magsman",                    "Magswoman"                     },
	        { "Highwayman",                 "Highwaywoman"                  },
	        { "Burglar",                    "Burglaress"                    },
	        { "Thief",                      "Thief"                         },

	        { "Knifer",                     "Knifer"                        },
	        { "Quick-Blade",                "Quick-Blade"                   },
	        { "Killer",                     "Murderess"                     },
	        { "Brigand",                    "Brigand"                       },
	        { "Cut-Throat",                 "Cut-Throat"                    },

	        { "Spy",                        "Spy"                           },
	        { "Grand Spy",                  "Grand Spy"                     },
	        { "Master Spy",                 "Master Spy"                    },
	        { "Assassin",                   "Assassin"                      },
	        { "Greater Assassin",           "Greater Assassin"              },

	        { "Master of Vision",           "Mistress of Vision"            },
	        { "Master of Hearing",          "Mistress of Hearing"           },
	        { "Master of Smell",            "Mistress of Smell"             },
	        { "Master of Taste",            "Mistress of Taste"             },
	        { "Master of Touch",            "Mistress of Touch"             },

	        { "Crime Lord",                 "Crime Mistress"                },
	        { "Infamous Crime Lord",        "Infamous Crime Mistress"       },
	        { "Greater Crime Lord",         "Greater Crime Mistress"        },
	        { "Master Crime Lord",          "Master Crime Mistress"         },
	        { "Godfather",                  "Godmother"                     },

	        { "Assassin Hero",              "Assassin Heroine"              },
	        { "Angel of Death",             "Angel of Death"                },
	        { "Deity of Assassins",         "Deity of Assassins"            },
	        { "Supreme Master",             "Supreme Mistress"              },
	        { "Implementor",                "Implementress"                 }
	    },{
	        { "Man",                        "Woman"                         },

	        { "Swordpupil",                 "Swordpupil"                    },
	        { "Recruit",                    "Recruit"                       },
	        { "Sentry",                     "Sentress"                      },
	        { "Fighter",                    "Fighter"                       },
	        { "Soldier",                    "Soldier"                       },

	        { "Warrior",                    "Warrior"                       },
	        { "Veteran",                    "Veteran"                       },
	        { "Swordsman",                  "Swordswoman"                   },
	        { "Fencer",                     "Fenceress"                     },
	        { "Combatant",                  "Combatess"                     },

	        { "Hero",                       "Heroine"                       },
	        { "Myrmidon",                   "Myrmidon"                      },
	        { "Swashbuckler",               "Swashbuckleress"               },
	        { "Mercenary",                  "Mercenaress"                   },
	        { "Swordmaster",                "Swordmistress"                 },

	        { "Lieutenant",                 "Lieutenant"                    },
	        { "Champion",                   "Lady Champion"                 },
	        { "Dragoon",                    "Lady Dragoon"                  },
	        { "Cavalier",                   "Lady Cavalier"                 },
	        { "Knight",                     "Lady Knight"                   },

	        { "Grand Knight",               "Grand Knight"                  },
	        { "Master Knight",              "Master Knight"                 },
	        { "Paladin",                    "Paladin"                       },
	        { "Grand Paladin",              "Grand Paladin"                 },
	        { "Demon Slayer",               "Demon Slayer"                  },

	        { "Greater Demon Slayer",       "Greater Demon Slayer"          },
	        { "Dragon Slayer",              "Dragon Slayer"                 },
	        { "Greater Dragon Slayer",      "Greater Dragon Slayer"         },
	        { "Underlord",                  "Underlord"                     },
	        { "Overlord",                   "Overlord"                      },

	        { "Baron of Thunder",           "Baroness of Thunder"           },
	        { "Baron of Storms",            "Baroness of Storms"            },
	        { "Baron of Tornadoes",         "Baroness of Tornadoes"         },
	        { "Baron of Hurricanes",        "Baroness of Hurricanes"        },
	        { "Baron of Meteors",           "Baroness of Meteors"           },

	        { "Knight Hero",                "Knight Heroine"                },
	        { "Angel of War",               "Angel of War"                  },
	        { "Deity of War",               "Deity of War"                  },
	        { "Supreme Master of War",      "Supreme Mistress of War"       },
	        { "Implementor",                "Implementress"                 }
	    }
	};
	
	/*
	 * Strength Attribute bonus table.
	 */
	public static final StrengthAttribute[] str_app = new StrengthAttribute[] {
		new StrengthAttribute((short) -5, (short) -4, (short) 0, (short) 0), /* 0 */
		new StrengthAttribute((short) -5, (short) -4, (short) 3, (short) 1), /* 1 */
		new StrengthAttribute((short) -3, (short) -2, (short) 3, (short) 2),
		new StrengthAttribute((short) -3, (short) -1, (short) 10, (short) 3), /* 3 */
		new StrengthAttribute((short) -2, (short) -1, (short) 25, (short) 4),
		new StrengthAttribute((short) -2, (short) -1, (short) 55, (short) 5), /* 5 */
		new StrengthAttribute((short) -1, (short) 0, (short) 80, (short) 6),
		new StrengthAttribute((short) -1, (short) 0, (short) 90, (short) 7),
		new StrengthAttribute((short) 0, (short) 0, (short) 100, (short) 8),
		new StrengthAttribute((short) 0, (short) 0, (short) 100, (short) 9),
		new StrengthAttribute((short) 0, (short) 0, (short) 115, (short) 10), /* 10 */
		new StrengthAttribute((short) 0, (short) 0, (short) 115, (short) 11),
		new StrengthAttribute((short) 0, (short) 0, (short) 140, (short) 12),
		new StrengthAttribute((short) 0, (short) 0, (short) 140, (short) 13), /* 13 */
		new StrengthAttribute((short) 0, (short) 1, (short) 170, (short) 14),
		new StrengthAttribute((short) 1, (short) 1, (short) 170, (short) 15), /* 15 */
		new StrengthAttribute((short) 1, (short) 2, (short) 195, (short) 16),
		new StrengthAttribute((short) 2, (short) 3, (short) 220, (short) 22),
		new StrengthAttribute((short) 2, (short) 4, (short) 250, (short) 25), /* 18 */
		new StrengthAttribute((short) 3, (short) 5, (short) 400, (short) 30),
		new StrengthAttribute((short) 3, (short) 6, (short) 500, (short) 35), /* 20 */
		new StrengthAttribute((short) 4, (short) 7, (short) 600, (short) 40),
		new StrengthAttribute((short) 5, (short) 7, (short) 700, (short) 45),
		new StrengthAttribute((short) 6, (short) 8, (short) 800, (short) 50),
		new StrengthAttribute((short) 8, (short) 10, (short) 900, (short) 55),
		new StrengthAttribute((short) 10, (short) 12, (short) 999, (short) 60) /* 25 */
	};
	
	/*
	 * Intelligence Attribute bonus table.
	 */
	public static final IntelligenceAttribute[] int_app = new IntelligenceAttribute[] {
		new IntelligenceAttribute((short) 3), /* 0 */
		new IntelligenceAttribute((short) 5), /* 1 */
		new IntelligenceAttribute((short) 7),
		new IntelligenceAttribute((short) 8), /* 3 */
		new IntelligenceAttribute((short) 9),
		new IntelligenceAttribute((short) 10), /* 5 */
		new IntelligenceAttribute((short) 11),
		new IntelligenceAttribute((short) 12),
		new IntelligenceAttribute((short) 13),
		new IntelligenceAttribute((short) 15),
		new IntelligenceAttribute((short) 17), /* 10 */
		new IntelligenceAttribute((short) 19),
		new IntelligenceAttribute((short) 22),
		new IntelligenceAttribute((short) 25),
		new IntelligenceAttribute((short) 28),
		new IntelligenceAttribute((short) 31), /* 15 */
		new IntelligenceAttribute((short) 34),
		new IntelligenceAttribute((short) 37),
		new IntelligenceAttribute((short) 40), /* 18 */
		new IntelligenceAttribute((short) 44),
		new IntelligenceAttribute((short) 49), /* 20 */
		new IntelligenceAttribute((short) 55),
		new IntelligenceAttribute((short) 60),
		new IntelligenceAttribute((short) 70),
		new IntelligenceAttribute((short) 85),
		new IntelligenceAttribute((short) 99) /* 25 */
	};

	/*
	 * Wisdom Attribute bonus table.
	 */
	public static final WisdomAttribute[] wis_app = new WisdomAttribute[] {
		new WisdomAttribute((short) 0), /* 0 */
		new WisdomAttribute((short) 0), /* 1 */
		new WisdomAttribute((short) 0),
		new WisdomAttribute((short) 0), /* 3 */
		new WisdomAttribute((short) 0),
		new WisdomAttribute((short) 1), /* 5 */
		new WisdomAttribute((short) 1),
		new WisdomAttribute((short) 1),
		new WisdomAttribute((short) 1),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2), /* 10 */
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 2),
		new WisdomAttribute((short) 3), /* 15 */
		new WisdomAttribute((short) 3),
		new WisdomAttribute((short) 4),
		new WisdomAttribute((short) 5), /* 18 */
		new WisdomAttribute((short) 5),
		new WisdomAttribute((short) 5), /* 20 */
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 6),
		new WisdomAttribute((short) 7) /* 25 */
	};
	
	/*
	 * Dexterity Attribute bonus table.
	 */
	public static final DexterityAttribute[] dex_app = new DexterityAttribute[] {
		new DexterityAttribute((short) 60), /* 0 */
		new DexterityAttribute((short) 50), /* 1 */
		new DexterityAttribute((short) 50),
		new DexterityAttribute((short) 40),
		new DexterityAttribute((short) 20),
		new DexterityAttribute((short) 10), /* 5 */
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0), /* 10 */
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) 0),
		new DexterityAttribute((short) -10), /* 15 */
		new DexterityAttribute((short) -15),
		new DexterityAttribute((short) -20),
		new DexterityAttribute((short) -30),
		new DexterityAttribute((short) -40),
		new DexterityAttribute((short) -50), /* 20 */
		new DexterityAttribute((short) -60),
		new DexterityAttribute((short) -75),
		new DexterityAttribute((short) -90),
		new DexterityAttribute((short) -105),
		new DexterityAttribute((short) -120) /* 25 */
	};
	
	/*
	 * Constitution Attribute bonus table.
	 */
	public static final ConstitutionAttribute[] con_app = new ConstitutionAttribute[] {
		new ConstitutionAttribute((short) -4, (short) 20), /* 0 */
		new ConstitutionAttribute((short) -3, (short) 25), /* 1 */
		new ConstitutionAttribute((short) -2, (short) 30),
		new ConstitutionAttribute((short) -2, (short) 35), /* 3 */
		new ConstitutionAttribute((short) -1, (short) 40),
		new ConstitutionAttribute((short) -1, (short) 45), /* 5 */
		new ConstitutionAttribute((short) -1, (short) 50),
		new ConstitutionAttribute((short) 0, (short) 55),
		new ConstitutionAttribute((short) 0, (short) 60),
		new ConstitutionAttribute((short) 0, (short) 65),
		new ConstitutionAttribute((short) 0, (short) 70), /* 10 */
		new ConstitutionAttribute((short) 0, (short) 75),
		new ConstitutionAttribute((short) 0, (short) 80),
		new ConstitutionAttribute((short) 0, (short) 85),
		new ConstitutionAttribute((short) 0, (short) 88),
		new ConstitutionAttribute((short) 1, (short) 90), /* 15 */
		new ConstitutionAttribute((short) 2, (short) 95),
		new ConstitutionAttribute((short) 2, (short) 97),
		new ConstitutionAttribute((short) 3, (short) 99), /* 18 */
		new ConstitutionAttribute((short) 3, (short) 99),
		new ConstitutionAttribute((short) 4, (short) 99), /* 20 */
		new ConstitutionAttribute((short) 4, (short) 99),
		new ConstitutionAttribute((short) 5, (short) 99),
		new ConstitutionAttribute((short) 6, (short) 99),
		new ConstitutionAttribute((short) 7, (short) 99),
		new ConstitutionAttribute((short) 8, (short) 99) /* 25 */
	};

	public static final LiquidType[] liq_table = new LiquidType[] {
		new LiquidType("water", "clear", new short[]{0, 1, 10}),  /*  0 */
		new LiquidType("beer", "amber", new short[]{3, 2, 5}),
		new LiquidType("wine", "rose", new short[]{5, 2, 5}),
		new LiquidType("ale", "brown", new short[]{2, 2, 5}),
		new LiquidType("dark ale", "dark", new short[]{1, 2, 5}),
		new LiquidType("whisky", "golden", new short[]{6, 1, 4}),  /*  5 */
		new LiquidType("lemonade", "pink", new short[]{0, 1, 8}),
		new LiquidType("firebreather", "boiling", new short[]{10, 0, 0}),
		new LiquidType("local specialty", "everclear", new short[]{3, 3, 3}),
		new LiquidType("slime mold juice", "green", new short[]{0, 4, -8}),
		new LiquidType("milk", "white", new short[]{0, 3, 6}),  /* 10 */
		new LiquidType("tea", "tan", new short[]{0, 1, 6}),
		new LiquidType("coffee", "black", new short[]{0, 1, 6}),
		new LiquidType("blood", "red", new short[]{0, 2, -1}),
		new LiquidType("salt water", "clear", new short[]{  0, 1, -2 }),
		new LiquidType("cola", "cherry", new short[]{0, 1, 5})   /* 15 */
	};
}
