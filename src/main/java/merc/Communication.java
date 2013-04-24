package merc;

public abstract class Communication {
	
	public static void write_to_buffer(Descriptor desc, String txt, int length) {
		if (length <= 0) {
			length = txt.length();
		}
		//TODO: I don't think this is necessary
		// Java sockets library instead
		if (desc.outtop == 0 && !desc.fcommand) {
			//desc.outbuf.toCharArray() = '\n';
		}
	}
	
	public static void send_to_char(String txt, MudCharacter character) {
		if (txt != null && character.desc != null) {
			write_to_buffer(character.desc, txt, txt.length());
		}
		return;
	}

}
