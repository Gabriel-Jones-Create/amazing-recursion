package maze;

/**
 * A {@link Maze} is at least one {@link Room} which may contain paths
 * to other {@link Room}s. A {@link Maze} is said to be solvable if
 * it is possible to navigate between its {@link Room}s in such a way
 * that one arrives at a {@link Room} whose {@link Room#isExit()} returns
 * {@code true}.
 * @author jcollard, jddevaug
 *
 */
public class Maze {
  /**
   * The starting room of the {@link Maze}.
   */
  private final Room start;

  /**
   * Creates a {@link Maze} specifying the starting {@link Room}.
   * @param start the starting room of this {@link Maze}
   * @throws NullPointerException if {@code start} is {@code null}.
   */
  public Maze(final Room start) {
    if (start == null) {
      throw new NullPointerException("A Maze must have a starting room.");
    }
    this.start = start;
  }

  /**
   * Returns the starting {@link Room} of this {@link Maze}.
   * @return the starting {@link Room} of this {@link Maze}
   */
  public final Room getStart() {
    return start;
  }

}
