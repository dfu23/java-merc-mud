package com.wallyatkins.mud.merc;

import com.wallyatkins.mud.merc.types.EquipmentWearLocation;
import com.wallyatkins.mud.merc.types.ItemType;

public class MudObject {
	public MudObject next;
	public MudObject next_content;
	public MudObject contains;
	public MudObject in_obj;
	public MudCharacter carried_by;
	
	public RoomIndexData[] in_room;
	
	public String name;
	public String short_descr;
	public String description;
	
	public ItemType item_type;
	public short extra_flags;
	public short wear_flags;
	public EquipmentWearLocation wear_loc;
	public short weight;
	public int cost;
	public short level;
	public short timer;
	public int[] value = new int[4];
}
