package piconot.internal

// A Picobot program that can fill an empty room
object EmptyBot extends ChaDSL("resources/empty.txt") {

  // States 0 and 1: move to the top left

  // State 0: move left 
  (0 `**x*`) → `Slide to the left`("1") // go all the way to the left
  (0 `**W*`) → `Freeze`("1") // can't go left anymore, so try to go up

  // State 1: move up
  (1 `x***`) → `One hop this time`("1") // go all the way to the top
  (1 `N**x`) → `Reverse`("2") // can't go up any more, so try to go down

  // States 2 and 3: fill from top to bottom, left to right

  // State 2: fill this column to the bottom
  (2 `***x`) → `Reverse`("2") // go all the way to the bottom
  (2 `*x*S`) → `Slide to the right`("3") // can't go down anymore, so try to go right

  // State 3: fill this column to the top
  (3 `x***`) → `One hop this time`("3") // go all the way to the top
  (3 `Nx**`) → `Slide to the right`("2") // can't go up anymore, so try to go right

  run
}