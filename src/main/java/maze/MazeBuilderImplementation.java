package maze;

public class MazeBuilderImplementation implements MazeBuilder{

	@Override
	public Room createRoom(String longDescription, String shortDescription) {
		// TODO Auto-generated method stub
		if(longDescription.equals(null) || shortDescription.equals(null)) {
			throw new NullPointerException("Descriptions cannot be null");
		}
		return new NonExitRoom(longDescription, shortDescription);
	}

	@Override
	public Room createExit(String longDescription, String shortDescription) {
		// TODO Auto-generated method stub
		if(longDescription.equals(null) || shortDescription.equals(null)) {
			throw new NullPointerException("Descriptions cannot be null");
		}
		return new ExitRoom(longDescription, shortDescription);
	}

	@Override
	public MazeBuilder addPassage(Room room0, Room room1) {
		// TODO Auto-generated method stub
		addOneWayPassage(room0,room1);
		addOneWayPassage(room1,room0);
		return this;
	}

	@Override
	public MazeBuilder addOneWayPassage(Room fromRoom, Room toRoom) {
		// TODO Auto-generated method stub
		//when it changes it changes globally
		if(fromRoom.getRooms().contains(toRoom) == -1) {
		fromRoom.getRooms().insertLast(toRoom);
		}
		return this;
	}

}
