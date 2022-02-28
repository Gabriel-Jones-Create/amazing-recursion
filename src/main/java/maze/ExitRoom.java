package maze;

/**
 * Represents room in a maze that is an exit
 * 
 * @author gabrieljones
 *
 */
public class ExitRoom extends NonExitRoom{

	/**
	 * Constructs new Exit Room based on long and short descriptions
	 * 
	 * @param longDesc Long description for room
	 * @param shortDesc Short description for room
	 */
	public ExitRoom(String longDesc, String shortDesc) {
		super(longDesc, shortDesc);
	}
	@Override 
	public boolean isExit() {
		return true;
	}

}
