package solver;

import maze.Maze;
import maze.MazeSolution;
import maze.Room;
import maze.UnsolvableMazeException;
import structure.ListInterface;
import structure.RecursiveLinkedList;

public class MazeSolver implements MazeSolution {
	private final Maze maze;
	private ListInterface<Room> visited;
	private ListInterface<Room> solution;
	private boolean canBeSolved;

	public MazeSolver(Maze m) {
		solution = new RecursiveLinkedList<Room>();
		visited = new RecursiveLinkedList<Room>();
		maze = m;
		canBeSolved = this.canBeSolved(m.getStart());
	}

	/**
	 * @param r
	 * @return
	 */
	private boolean canBeSolved(Room r) {
		if (r.isExit()) {
			solution.insertLast(r);
			return true;
		}
		visited.insertLast(r);
		ListInterface<Room> adjacentRooms = r.getRooms();
		for (int i = 0; i < adjacentRooms.size(); i++) {
			if (visited.contains(adjacentRooms.get(i)) == -1 && canBeSolved(adjacentRooms.get(i))) {
				solution.insertFirst(r);
				return true;
			}
		}
		return false;
	}

	@Override
	public Maze getMaze() {
		// TODO Auto-generated method stub
		return maze;
	}

	@Override
	public ListInterface<Room> getSolution() {
		// TODO Auto-generated method stub
		if (!canBeSolved) {
			throw new UnsolvableMazeException("This maze has no exit");
		}
		return solution;
	}
	/*
	 * private Room solve(Room r) { if(r.isExit()) { return r; } else { for(int i =
	 * 0; i < r.getRooms().size(); i++) { if(canBeSolved(r.getRooms().get(i))) {
	 * visited.insertLast(r.getRooms().get(i));
	 * solution.insertLast(r.getRooms().get(i)); return solve(r.getRooms().get(i));
	 * } } } return null; }
	 */

}
