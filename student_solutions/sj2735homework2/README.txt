Sejal Jain
sj2735

COMSW3134 HW 2

Programming Problem 1

I did not have many problems with the Stack interface and the MyStack class. For the Symbol Balance class, I put the entirety of it in the main method, although I do think it could be cleaner with helper methods. I used a stack where I pushed the special symbols and then I would pop the stack if the corresponding closing symbol was found. If the wrong closing symbol was found before the correct one, there would be an error. I decided to split the testing part into 3: blocked comments, quotes, everything else. Blocked comments and quotes were special because the closing and opening symbols were the same and everything in between was to be ignored regardless of whether or not the symbols were balanced. 

To test:

javac SymbolBalance.java
java SymbolBalance Test.java

Programming Problem 2

I implemented TwoStackQueue by making S1 the stack looked like a queue and S2 the stack that was the reverse queue. I would first keep enqueueing elements to S2, then when something needed to be dequeued, I would order them properly in S1 and then pop the top element, effectively dequeuing the first element. There would be a switch in the operating stack every time there was a switch from enqueueing to dequeueing. 

To test:

javac TwoStackQueueTester.java
java TwoStackQueueTester
