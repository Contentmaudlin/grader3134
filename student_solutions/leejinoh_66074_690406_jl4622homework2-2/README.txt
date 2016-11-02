Jinoh Lee (jl4622)
Homework 2
README

Includes written in PDF Format, README.txt, Problem2.txt, and java files of MyStack, Problem 2, SymbolBalance, Test, and TwoStackQueue.

Differences in Code:
    MyStack.java includes a get and size method to aid with other classes/programs
    TwoStackQueue includes warning suppressers in order to properly implement MyQueue

Problem 1:
    First compile MyStack.java
    Then freely use SymbolBalance.java with provided Test.java or other Test cases 
    However, test cases must be named "Test.java" 
    SymbolBalance works by reading each String, and pushing every character onto a Stack
    The Stack is then iterated through, with various logical expressions guiding whether or not an error occurs.

Problem 2:
    First compile MyStack.java, then MyQueue.java, then TwoStackQueue.java. 
    Run Problem2.java (tester class) 
    The Enqueue method was created by simpling pushing elements into the first stack (S1)
    The Dequeue method was created by popping every element in S1 into S2 (if S2 is empty)
    This avoids the "last in first out" characteristics of stacks because the last for S1 becomes the first for S2, thus imitating a Queue.

