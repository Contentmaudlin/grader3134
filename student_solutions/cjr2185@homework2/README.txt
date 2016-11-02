STUDENT INFO:
-------------
NAME: Christophe Rimann
UNI: cjr2185
----------------------------------------------------------------------


COMPILE/RUN INSTRUCTIONS:
-------------------------
Setting up:
	* Make sure SymbolBalance.java, TwoStackQueue.java, Test.java, MyStack.java 
	  and Program2.java are in the same directory (they should be by default)
	* Open command line, navigate to that directory

MyStack.java:
	* MyStack should be the first file compiled
	* Compile the program by running $ javac MyStack.java

SymbolBalance.java:
	* Compile the program by running $ javac SymbolBalance.java
	* Run the program with the command line arguments: $ java SymbolBalance Test.java
	* Test.java is in fact a modified version of SymbolBalance with 2 tests: firstly,
	  there is mistake within the initial comment, which is ignored. Secondly, there 
	  is a mis-match immediately in the public class: {).

TwoStackQueue.java:
	* This file should be compiled prior to Program2.java
	* Compile the program by running $ javac TwoStackQueue.java

Program2.java:
	* Compile the program by running $ javac Program2.java
	* Run the program by running $ java Program2.java


DESCRIPTIONS OF FILES:
----------------------

MyStack.java:
	* A simple implementation of the Stack ADT using the linkedlist 
	  built into Java

SymbolBalance.java:
	* Takes as a command line argument a file name, checks that file 
	  for any symbol imbalances for: [], {}, (), "", and comments.

TwoStackQueue.java:
	* A queue made up of 2 stacks that enqueues to one stack and 
	  dequeues to another.

Program2.java:
	* A class to test the TwoStackQueue