Chiara Vallini 
cfv2111
10/10/2016 
Homework 2 - Data Structures - Section 1 

- Compile and running: 

In order to run my programs, go to terminal and write: 

Test Program 2: 

- Compile by writing in terminal: javac Program2.java 
- Run by writing in the terminal: java Program2

Test Program 1: 

- Compile by writing in terminal: javac SymbolBalance.java 
- Run by writing in the terminal: java SymbolBalance Test.java

SymbolBalance.java: 
This class takes in the name of a java file as a command line argument and reads the file. It then checks to make sure that all { }'s, ( )'s, [ ]'s, " "'s, '*//*'s are properly balanced. It ignores characters within literal strings and comment blocks. It returns an error if a mismatch is found. In order to find a mismatch in the parenthesis I use the 

The main method reads a file that is given into the command line with a buffer and calls a check method to check for mismatches. 


MyStack.java: 
This generic class implements stacks methods using LinkLists basic operations

Test.java
This class tests for an unbalanced ] operator and checks if the program can deal with ignoring parenthesis within quotations and coments


TwoStackQueue.java
This class implements the MyQueue interface to build a queue of two separate stacks, S1 and S2

MyQueue.java
This is the interface my TwoStackQueue class implements. 

Program2.java
This class tested my TwoStackQueue class for the implementation of a queue of integers using two stacks

