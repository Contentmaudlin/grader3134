UNI: ia2341
Name: Ishaan Kishore Agrawal
Assignment - Homework #2

Files: MyStack.java, MyQueue.java, TwoStackQueue.java, Problem2.java, Problem2.txt
       SymbolBalance.java, Test.java, written.pdf
       
Notes on Compilation:

To compile a file on the command line, type "javac" followed by the name of the 
file (ex. MyStack.java). In order to run the file, once compiled, type "java" 
followed by the name of the class (ex. MyStack).
       
*************
MyStack.java
*************

This class contains the constructor and the corresponding methods of the stack 
data structure. The methods include push(), pop(), top(), size(), isEmpty() etc.

The stack data structure supports generic objects and follows a FIFO order.

*************
MyQueue.java
*************

This class was provided through the assignment itself. It provides the method 
headers that need to be implemented in the TwoStackQueue.java file.

*******************
TwoStackQueue.java
*******************

This class contains the constructor for a queue made out of 2 stacks. The stack 
that contains the data is the enqueueStack and the one that pops elements is the
dequeueStack. In order for this class to compile, the MyStack.java and the 
MyQueue.java files must have already been compiled as well.

**************
Problem2.java
**************

This class contains the test method which tests the functioning of the 
TwoStackQueue.java class and object. It enqueues elements -100, -10, 0, 10 and 100 
in the same order and checks whether the elements are dequeued in the same order
as they are enqueued. In order for this file to compile, the TwoStackQueue.java 
file must have also been compiled before this (as well as all the other 
subsidiary classes required for TwoStackQueue.java).

*************
Problem2.txt
*************

This text file provide a discussion about the runtimes of the enqueue and dequeue methods of the TwoStackQueue.java object.

*******************
SymbolBalance.java
*******************

This class contains the SymbolBalance object and constructor that checks all the
symbol balancing in a given .java file. It takes the .java file as input through
a command line argument. It contains a main method that calls all the methods 
(both private and public) that are needed to fully check the balancing of all
symbols. In order for this file to compile, the MyStack.java file must also be 
compiled, including whatever Test file is being run. The provided Test.java file must be compiled if that is the file you are testing.

**********
Test.java
**********

This file is used to test whether the SymbolBalance.java file works correctly or not.

************
written.pdf
************

This file contains all the solutions to the written part of the assignment.