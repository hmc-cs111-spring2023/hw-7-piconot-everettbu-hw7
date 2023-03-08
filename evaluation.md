# Evaluation: running commentary

## Internal DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

I initially started by attepting to implement my orginial design internally but ran into a series of issues early on. I don't feel like I have enough experience wrting DSLs to attack this on my first attempt. I will now shift towards working on a smaller goal and see if I can get that running. If so, I would like to add more featrues afterwards. I will now  attempt to change the syntax of the direction that the bot moves.

I have hit another road block and will now attempt to see if I have better luck implemting it externally.

I have spent multiple hours working on this and can not figure out how to get it running without errors. I am now at a point where I will be happy if all I can do is just change the syntax of the direction that tells the bot where to move next. I will make one final attempt to implement it internally

I finally have it working now, however, it is really poorly written. After every direction in my new syntax I have to add .asInstanceOf[picolib.semantics.MoveDirection] to avoid errors. Overall I am pleased but would like to fix this because it makes my DSL unusable.

Once again, I have shifted direction to try and make my DSL funtional. To do this, I used elements from the sample code and added my own elements of inherence to make it my own. Using the key elements of the sample code, I am able now to get my code to complie which is huge. However, I am unable to get it to run which is something I will work on now. Hopefully, if I am able to resolve this issue quickly I will have time to change the code that I have now to make it more of my own.

Stuck. I made one final attempt to change my code and ended up braking it. There is some issue within my code that I can not seem to fix. This is where I tap out. 
I learned a decent amount about attempting to implement a dsl:
- it is best to start off with a simple idea and build from there. I wish that I knew this before I started as it could have potentially saved me a lot of time. Moving forward, I will take this approach when working on my project. 
- It is worthwile to take the time to get to know the host language thoroughly. I thought that I spent a decent amount of time reviewing Picobot and the picolib package, but I wish that I had spent more time doing this. I feel that if I had a better understanding of this I would have found it easier to write my DSL.
- I also struggled getting my languge to run. I should have figured this out before moving forward with anything else.



**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

Right now after working on this for 8+ hours I will give this assignment a 9 difficultly rating. I can not seem to get it working whatsoever.

Ive bumped this up to a 10 rating. I simply could not figure this one out.


