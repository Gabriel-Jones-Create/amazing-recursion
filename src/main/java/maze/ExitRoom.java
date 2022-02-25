package maze;

public class ExitRoom extends NonExitRoom{

	public ExitRoom(String longDesc, String shortDesc) {
		super(longDesc, shortDesc);
	}
	@Override 
	public boolean isExit() {
		return true;
	}

}
