package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File

object ChaDSL {
  sealed trait PicobotDirection
  case object North extends PicobotDirection
  case object East extends PicobotDirection
  case object West extends PicobotDirection
  case object South extends PicobotDirection
  case object StayHere extends PicobotDirection

  val directionMap = Map(
    "One hop this time" -> North,
    "Slide to the right" -> East,
    "Slide to the left" -> West,
    "Reverse" -> South,
    "Freeze" -> StayHere
  )


  val rules = List(
    /////////////////////////////////////////////////////////
    // State 0: go West
    /////////////////////////////////////////////////////////

    // as long as West is unblocked, go West
    Rule(
      State("0"),
      Surroundings(Anything, Anything, Open, Anything),
      ("Slide to the left").asInstanceOf[picolib.semantics.MoveDirection],
      State("0")
    ),

    // can't go West anymore, so try to go North (by transitioning to State 1)
    Rule(
      State("0"),
      Surroundings(Anything, Anything, Blocked, Anything),
      ("Freeze").asInstanceOf[picolib.semantics.MoveDirection],
      State("1")
    ),

    /////////////////////////////////////////////////////////
    // State 1: go North
    /////////////////////////////////////////////////////////

    // as long as North is unblocked, go North
    Rule(
      State("1"),
      Surroundings(Open, Anything, Anything, Anything),
      ("One hop this time").asInstanceOf[picolib.semantics.MoveDirection],
      State("1")
    ),

    // can't go North any more, so try to go South (by transitioning to State 2)
    Rule(
      State("1"),
      Surroundings(Blocked, Anything, Anything, Open),
      ("Reverse").asInstanceOf[picolib.semantics.MoveDirection],
      State("2")
    ),

    /////////////////////////////////////////////////////////
    // States 2 & 3: fill from North to South, West to East
    /////////////////////////////////////////////////////////

    // State 2: fill this column from North to South
    Rule(
      State("2"),
      Surroundings(Anything, Anything, Anything, Open),
      ("Reverse").asInstanceOf[picolib.semantics.MoveDirection],
      State("2")
    ),

    // can't go South anymore, move one column to the East and go North
    // (by transitioning to State 3)
    Rule(
      State("2"),
      Surroundings(Anything, Open, Anything, Blocked),
      ("Slide to the right").asInstanceOf[picolib.semantics.MoveDirection],
      State("3")
    ),

    // State 3: fill this column from South to North
    Rule(
      State("3"),
      Surroundings(Open, Anything, Anything, Anything),
      ("One hop this time").asInstanceOf[picolib.semantics.MoveDirection],
      State("3")
    ),

    // can't go North anymore, move one column to the East and go South
    // (by transitioning to State 2)
    Rule(
      State("3"),
      Surroundings(Blocked, Open, Anything, Anything),
      ("Slide to the right").asInstanceOf[picolib.semantics.MoveDirection],
      State("2")
    )
  )
}


val emptyMaze = Maze("resources" + File.separator + "empty.txt")

object EmptyText extends TextSimulation(emptyMaze, rules)