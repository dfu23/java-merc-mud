package merc.data;

import merc.enums.ApplyAffectType;

public class AffectData {
	public AffectData next;
	public short type;
	public short duration;
	public ApplyAffectType location;
	public short modifier;
	public int bitvector;
}
