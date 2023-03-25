package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File
import picolib.maze.Maze
import picolib.display.TextDisplay
import scala.collection.mutable.ListBuffer

given Conversion[String, RelativeDescription] = (name: String) =>
  name match {
    case "Freeze" => Blocked
    case "Funky" => Open
    case "Cha" => Anything
  }

given Conversion[String, MoveDirection] = (dir: String) =>
  dir match {
    case "One hop this time" => North
    case "Slide to the right" => East
    case "Slide to the left" => West
    case "Reverse" => South
    case "Criss cross" => StayHere
  }

// /** A class that describes the contents of a location in the maze. */
// sealed abstract class RelativeDescription(val name: String):
//   override def toString = name

// /** The location has a wall */
// object Blocked extends RelativeDescription("Freeze")

// /** The location has no wall */
// object Open extends RelativeDescription("Funky")

// /** The location may or may not have a wall */
// object Anything extends RelativeDescription("Cha")

// /** A class that describes a direction the robot can move. */
// sealed abstract class MoveDirection(val dir: String):
//   override def toString = dir

// /** Move to the north */
// object North extends MoveDirection("One hop this time")

// /** Move to the east */
// object East extends MoveDirection("Slide to the right")

// /** Move to the west */
// object West extends MoveDirection("Slide to the left")

// /** Move to the south */
// object South extends MoveDirection("Reverse")

// /** Don't move */
// object StayHere extends MoveDirection("Criss cross")

// /** A class that describes the positions to the north, east, west, and south of
//   * some other position.
//   */
// case class Surroundings(
//     north: RelativeDescription,
//     east: RelativeDescription,
//     west: RelativeDescription,
//     south: RelativeDescription
// ):
//   override def toString = f"$north$east$west$south"

// /** A class that represents a state in which the robot may find itself. */
// case class State(name: String):
//   override def toString = name

// case class Rule(
//     startState: State,
//     surroundings: Surroundings,
//     moveDirection: MoveDirection,
//     endState: State
// )
