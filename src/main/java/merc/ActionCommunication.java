package merc;

public abstract class ActionCommunication {

	/*
	 * It is very important that this be an equivalance relation:
	 * (1) A ~ A
	 * (2) if A ~ B then B ~ A
	 * (3) if A ~ B and B ~ C, then A ~ C
	 */
	public static boolean is_same_group(MudCharacter a_char, MudCharacter b_char) {
		if (a_char.leader != null) {
			a_char = a_char.leader;
		}
		if (b_char.leader != null) {
			b_char = b_char.leader;
		}
		return a_char == b_char;
	}
	
}
