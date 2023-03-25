import picolib._
import picolib.maze._
import java.io.File
import picolib.semantics._
import piconot.internal.given


val emptyMaze1 = Maze("resources" + File.separator + "empty.txt")

val rules1 = List(
  /////////////////////////////////////////////////////////
  // State 0: go West
  /////////////////////////////////////////////////////////

  // as long as West is unblocked, go West
  Rule(
    State("0"),
    Surroundings("Cha", "Cha", "Funky", "Cha"),
    "Slide to the right",
    State("0")
  ),

  // can't go West anymore, so try to go North (by transitioning to State 1)
  Rule(
    State("0"),
    Surroundings("Cha", "Cha", "Freeze", "Cha"),
    "Criss cross",
    State("1")
  ),

  /////////////////////////////////////////////////////////
  // State 1: go North
  /////////////////////////////////////////////////////////

  // as long as North is unblocked, go North
  Rule(
    State("1"),
    Surroundings("Funky", "Cha", "Cha", "Cha"),
    "One hop this time",
    State("1")
  ),

  // can't go North any more, so try to go South (by transitioning to State 2)
  Rule(
    State("1"),
    Surroundings("Freeze", "Cha", "Cha", "Funky"),
    "Reverse",
    State("2")
  ),

  /////////////////////////////////////////////////////////
  // States 2 & 3: fill from North to South, West to East
  /////////////////////////////////////////////////////////

  // State 2: fill this column from North to South
  Rule(
    State("2"),
    Surroundings("Cha", "Cha", "Cha", "Funky"),
    "Reverse",
    State("2")
  ),

  // can't go South anymore, move one column to the East and go North
  // (by transitioning to State 3)
  Rule(
    State("2"),
    Surroundings("Cha", "Funky", "Cha", "Freeze"),
    "Slide to the right",
    State("3")
  ),

  // State 3: fill this column from South to North
  Rule(
    State("3"),
    Surroundings("Funky", "Cha", "Cha", "Cha"),
    "One hop this time",
    State("3")
  ),

  // can't go North anymore, move one column to the East and go South
  // (by transitioning to State 2)
  Rule(
    State("3"),
    Surroundings("Freeze", "Funky", "Cha", "Cha"),
    "Slide to the right",
    State("2")
  )
)

////////////////////////////////////////////////////////////////////////////////
// Create and run simulations with the maze and rules defined above
////////////////////////////////////////////////////////////////////////////////

// text-based simulation
object EmptyText1 extends TextSimulation(emptyMaze, rules)
