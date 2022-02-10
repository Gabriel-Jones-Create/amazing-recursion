package config;

import maze.Maze;
import maze.MazeBuilder;
import maze.MazeSolution;
import structure.ListInterface;

/**
 * This class acts as a configuration file which tells the testing framework
 * which implementation you want us to use when we grade your assignment.
 *
 * @author jcollard, jddevaug
 *
 */
public final class Configuration {
  /**
   * Private constructor to prevent class instantiation.
   */
  private Configuration() {
  }


  /**
   * Returns a new instance of the {@link ListInterface} that you want to be
   * graded.
   * @param <T>
   *        the type of the {@link ListInterface}
   * @return
   *        the {@link ListInterface} you want graded
   */
  public static <T> ListInterface<T> getListInterface() {
    return null;
  }

  /**
   * Returns a new instance of the {@link MazeBuilderTest} that you want to be
   * graded.
   * @return
   *        the {@link MazeBuilderTest} you want to be graded
   */
  public static MazeBuilder getMazeBuilder() {
    return null;
  }

  /**
   * Given a {@link Maze}, returns a new instance of the {@link MazeSolution}
   * that you want us to use to test your implementation.
   * @param maze the {@link Maze} that must be solved
   * @return
   *        the {@link MazeSolution} you want graded
   */
  public static MazeSolution getMazeSolution(final Maze maze) {
    return null;
  }

}
