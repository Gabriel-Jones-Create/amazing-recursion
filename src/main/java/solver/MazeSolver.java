package solver;

import maze.Maze;
import maze.MazeSolution;
import maze.Room;
import maze.UnsolvableMazeException;
import structure.ListInterface;
import structure.RecursiveLinkedList;

/**
 * Represents a MazeSolver Object which can finds path in an inputed maze that
 * leads to an exit.
 * 
 * @author gabrieljones
 *
 */
public class MazeSolver implements MazeSolution {
	private final Maze maze;// inputed maze for MazeSolver to solve
	private ListInterface<Room> visited;// stores List of Room objects that have been visited by Maze Solver
	private ListInterface<Room> solution;// stores List of Rooms objects that can be solved mapping a solution route
	private boolean canBeSolved; // boolean value that checks if the input maze can be solved

	/**
	 * Constructs Maze Solver object based on inputed maze
	 * 
	 * @param m maze which this object will solve
	 */
	public MazeSolver(Maze m) {
		solution = new RecursiveLinkedList<Room>();
		visited = new RecursiveLinkedList<Room>();
		maze = m;
		canBeSolved = this.canBeSolved(m.getStart());
	}

	/**
	 * Returns <code>true</code> if the maze can be solved from a certain room and
	 * <code>false</code> otherwise adding rooms that can be solved to a Recursive
	 * Linked List
	 * 
	 * @param r room that is checked if maze can be solved from
	 * @return <code>true</code> if the maze can be solved from a certain room and
	 *         <code>false</code> otherwise
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
		return maze;
	}

	@Override
	public ListInterface<Room> getSolution() {
		if (!canBeSolved) {
			throw new UnsolvableMazeException("This maze has no exit");
		}
		return solution;
	}

}
