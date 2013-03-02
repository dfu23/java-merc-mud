package com.wallyatkins.mud.merc;

public class RoomIndexData {
	public RoomIndexData[] next;
	public MudCharacter[] people;
	public MudObject[] contents;
	
	public String name;
	public String description;
	
	public short vnum;
	public short room_flags;
	public short light;
	public short sector_type;
}
