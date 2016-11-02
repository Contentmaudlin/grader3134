Mari Husain
mh3685
October 5th, 2016
Data Structures - Blaer

These files contain my responses to the first homework assignment for professor
Blaer's Data Structures class. 

Files included:

written.txt - My responses to the written portion of the homework (problems 1-4).

SymbolBalance.java - answer to programming problem 1. Implements and tests a symbol
balancing class using a stack. Note: I assumed that since Java doesn’t have multi-
line strings (like Python or whatever), if the program reaches the end of a line 
with an unclosed quote character, it just prints out the error about the unclosed
quote and assumes the quote ends at the new line character so that it can continue
checking for other errors. Eclipse acts like this, so I assumed it was an alright
line of reasoning? Also, the program is configured to only print out the first error found in a file, but this can be turned off by changing the printOnlyOneError at the top of the file to false.

MyStack.java - an implementation of a stack using a LinkedList. Used in problems 1
and 2.

Test.java - a tester file for SymbolBalance.java. Tests an unclosed “ character.
Because one of the parentheses is considered to be part of the string literal as a
result of the unclosed string (even though the 

TwoStackQueue.java - Answer to programming problem 2. Implements a queue using two
separate stacks.

Program2.java - a tester class for the TwoStackQueue class.

Program2.txt - A discussion of the big-O running time of the enqueue and dequeue
operations for my queue implementation.

How to compile and run these files:
The text files should open in any text viewer - they're just .txt files.

The java files should compile and run on any system running Java 8. They can either
be compiled and run from the command line using javac [filename], where the filename
is the name of the file you want to compile. For example, to run the SymbolBalance
code, you’d type javac SymbolBalance.java 

You can also open them in an IDE like Eclipse and compile and run them from there. 