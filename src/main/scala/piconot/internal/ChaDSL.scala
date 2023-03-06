package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File

object ChaDSL {
  sealed trait Direction
  case object North extends Direction
  case object East extends Direction
  case object West extends Direction
  case object South extends Direction
  case object StayHere extends Direction

  def parseDirection(input: String): MoveDirection = input match {
    case "One hop this time" => North
    case "Slide to the right" => East
    case "Slide to the left" => West
    case "Reverse" => South
    case "Freeze" => StayHere
    case _ => throw new IllegalArgumentException(s"Invalid input: $input")
  }

  val rules = List(
    /////////////////////////////////////////////////////////
    // State 0: go West
    /////////////////////////////////////////////////////////

    // as long as West is unblocked, go West
    Rule(
      State("0"),
      Surroundings(Anything, Anything, Open, Anything),
      parseDirection("Slide to the left"),
      State("0")
    ),

    // can't go West anymore, so try to go North (by transitioning to State 1)
    Rule(
      State("0"),
      Surroundings(Anything, Anything, Blocked, Anything),
      parseDirection("Freeze"),
      State("1")
    ),

    /////////////////////////////////////////////////////////
    // State 1: go North
    /////////////////////////////////////////////////////////

    // as long as North is unblocked, go North
    Rule(
      State("1"),
      Surroundings(Open, Anything, Anything, Anything),
      parseDirection("One hop this time"),
      State("1")
    ),

    // can't go North any more, so try to go South (by transitioning to State 2)
    Rule(
      State("1"),
      Surroundings(Blocked, Anything, Anything, Open),
      parseDirection("Reverse"),
      State("2")
    ),

    /////////////////////////////////////////////////////////
    // States 2 & 3: fill from North to South, West to East
    /////////////////////////////////////////////////////////

    // State 2: fill this column from North to South
    Rule(
      State("2"),
      Surroundings(Anything, Anything, Anything, Open),
      parseDirection("Reverse"),
      State("2")
    ),

    // can't go South anymore, move one column to the East and go North
    // (by transitioning to State 3)
    Rule(
      State("2"),
      Surroundings(Anything, Open, Anything, Blocked),
      parseDirection("Slide to the right"),
      State("3")
    ),

    // State 3: fill this column from South to North
    Rule(
      State("3"),
      Surroundings(Open, Anything, Anything, Anything),
      parseDirection("One hop this time"),
      State("3")
    ),

    // can't go North anymore, move one column to the East and go South
    // (by transitioning to State 2)
    Rule(
      State("3"),
      Surroundings(Blocked, Open, Anything, Anything),
      parseDirection("Slide to the right"),
      State("2")
    )
  )
}


val emptyMaze = Maze("resources" + File.separator + "empty.txt")

object EmptyText extends TextSimulation(emptyMaze, rules)