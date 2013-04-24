package merc.data;

import merc.MudCharacter;
import merc.MudObject;

public class RoomIndexData {
	public RoomIndexData next;
	public MudCharacter people;
	public MudObject contents;
	
	public String name;
	public String description;
	
	public short vnum;
	public short room_flags;
	public short light;
	public short sector_type;
}
