README.txt

Ben Arbib - ba2490

file includes:
README.txt (this file)
ba2490written.pdf
MyQueue.java
MyStack.java
Program2.java
Program2.txt
SymbolBalance.java
Test.java
TwoStackQueue.java

MyQueue.java is the interface that my TwoStackQueue class implements, I have not altered it in any way. No need to compile or run.

MyStack.java is a class that acts as a stack using a linked list and its commands. it is used by TwoStackQueue class and SymbolBalance class. No need to compile or run.

Program2.java - This program is a tester for the TwoStackQueue class. 
it implements two queues - String and Integer. Must be compiled and run while in the same folder as TwoStackQueue.java
To compile - javac Program2.java
To run - java Program2

Program2.txt - txt file with info about the Big O of TwoStackQueue.java

SymbolBalance.java - takes as an input a .txt or .java file from command
line and goes over the text, character by character, and analyzes the file
for its symbols, such as {} () and []. it uses a stack, pushes in a
symbol, and pops one when it finds a match. if by the end of the file an
element is left in the stack the file is unbalanced.
must be compiled and run while MyStack.java and Test.java is in the same folder.
To compile - javac SymbolBalance.java
To run - java SymbolBalance Test.java

Test.java - A test program for SymbolBalance to go over. no need to compile or run (will not compile) but needs to be in the same folder as SymbolBalance.java

TwoStackQueue.java - is a class of a queue built from two stacks. 
enqueues into one stack, and dequeues from the other stack. it implements 
MyQueue.java and uses MyStack.java, therefore must be in the same folder with them. No need to compile or run but needs to be in the same folder as Program2.java 
