package maze;

import structure.ListInterface;
import structure.RecursiveLinkedList;

public class NonExitRoom implements Room{
	private String longDesc;// Long description for the room
	private String shortDesc;// Short description for the room
	private ListInterface<Room> neighbors;//List of adjacent rooms to this room object
	
	/**
	 * Constructs a Room that is not exit to the maze based on long and short description
	 * 
	 * @param longDesc Long Description
	 * @param shortDesc Short Description
	 */
	public NonExitRoom(String longDesc, String shortDesc) {
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
		neighbors = new RecursiveLinkedList<Room>();
	}

	@Override
	public String getFullDescription() {
		return longDesc;
	}

	@Override
	public String getShortDescription() {
		return shortDesc;
	}

	@Override
	public boolean isExit() {
		// return false because is non-exit room
		return false;
	}

	@Override
	public ListInterface<Room> getRooms() {
		return neighbors;
	}

}
