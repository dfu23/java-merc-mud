package merc;

public class Descriptor {
	public Descriptor next;
	public Descriptor snoop_by;
	public MudCharacter character;
	public MudCharacter original;
	public String host;
	public short descriptor;
	public short connected;
	public boolean fcommand;
	public char[] inbuf = new char[4 * 160];
	public char[] incomm = new char[160];
	public char[] inlast = new char[160];
	public int repeat;
	public String outbuf;
	public int outsize;
	public int outtop;
}
