package maze;

/**
 * Represents the implementation of the abstract class, {@link MazeBuilder}which can
 * be used to create a {@link Maze} with {@link Room}s
 * 
 * @author gabrieljones
 *
 */
public class MazeBuilderImplementation implements MazeBuilder {

	@Override
	public Room createRoom(String longDescription, String shortDescription) {
		if (longDescription.equals(null) || shortDescription.equals(null)) {
			throw new NullPointerException("Descriptions cannot be null");
		}
		return new NonExitRoom(longDescription, shortDescription);
	}

	@Override
	public Room createExit(String longDescription, String shortDescription) {
		if (longDescription.equals(null) || shortDescription.equals(null)) {
			throw new NullPointerException("Descriptions cannot be null");
		}
		return new ExitRoom(longDescription, shortDescription);
	}

	@Override
	public MazeBuilder addPassage(Room room0, Room room1) {
		addOneWayPassage(room0, room1);
		addOneWayPassage(room1, room0);
		return this;
	}

	@Override
	public MazeBuilder addOneWayPassage(Room fromRoom, Room toRoom) {
		// when it changes it changes globally
		if (fromRoom.getRooms().contains(toRoom) == -1) {
			fromRoom.getRooms().insertLast(toRoom);
		}
		return this;
	}

}
