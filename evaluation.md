# Evaluation: running commentary

## Internal DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

I initially started by attepting to implement my orginial design internally but ran into a series of issues early on. I don't feel like I have enough experience wrting DSLs to attack this on my first attempt. I will now shift towards working on a smaller goal and see if I can get that running. If so, I would like to add more featrues afterwards. I will now  attempt to change the syntax of the direction that the bot moves.

I have hit another road block and will now attempt to see if I have better luck implemting it externally.

I have spent multiple hours working on this and can not figure out how to get it running without errors. I am now at a point where I will be happy if all I can do is just change the syntax of the direction that tells the bot where to move next. I will make one final attempt to implement it internally

I finally have it working now, however, it is really poorly written. After every direction in my new syntax I have to add .asInstanceOf[picolib.semantics.MoveDirection] to avoid errors. Overall I am pleased but would like to fix this because it makes my DSL unusable.


**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

Right now after working on this for 8+ hours I will give this assignment a 9 difficultly rating. I can not seem to get it working whatsoever.


