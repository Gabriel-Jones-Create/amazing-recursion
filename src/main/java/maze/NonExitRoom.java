package maze;

import structure.ListInterface;
import structure.RecursiveLinkedList;

public class NonExitRoom implements Room{
	private String longDesc;
	private String shortDesc;
	private ListInterface<Room> neighbors;
	
	public NonExitRoom(String longDesc, String shortDesc) {
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
		neighbors = new RecursiveLinkedList<Room>();
	}

	@Override
	public String getFullDescription() {
		// TODO Auto-generated method stub
		return longDesc;
	}

	@Override
	public String getShortDescription() {
		// TODO Auto-generated method stub
		return shortDesc;
	}

	@Override
	public boolean isExit() {
		// return false because is non-exit room
		return false;
	}

	@Override
	public ListInterface<Room> getRooms() {
		// TODO Auto-generated method stub
		return neighbors;
	}

}
