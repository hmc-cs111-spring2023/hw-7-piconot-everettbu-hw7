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

