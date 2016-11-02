drs2176
Dan Sendik
Data Structures Homework 2

Files submitted:
written.txt
SymbolBalance.java
MyStack.java
Test.java
TwoStackQueue.java
MyQueue.java
Program2.java
Program2.txt
README.txt

all java files were created and complied in eclipse. To compile and run these files, please use eclipse.

~~~~~~~SymbolBalance.java
different from instructions: 

This program solves the problem of analyzing a file and determining whether the symbols are balanced.

This program takes in a file and uses string builder to send each line to the check parity method. The check parity method is located in MyStack and uses a for loop followed by a series of if statements to iterate through each character of each line. When an if statement is entered, it stores the symbol that triggered that specific if statement. Additionally, when the SymbolBalance program completes feeding the input file to MyStack, it then looks at the stack and if any symbols are left in the stack, meaning they do not have parity, they are printed to the user stating that they are unbalanced and the counterpart which is missing.

~~~~~~~MyStack.java
different from instructions:

This program solves the problem of keeping track of what symbols are balanced an unbalanced by using a stack.

This program uses two linked lists; fileList (stores the test file, adding each character individually), and symbolStack (stores special symbols). Check parity method uses if statements to find and store symbols in the symbolStack. The series of methods(matchesLastX) are only triggered if a closing symbol was found, and check the stack to see if an opening symbol is present. 

~~~~~~~Test.java
different from instructions:

This program tests the SymbolBalance program with a lot of different inputs

~~~~~~~TwoStackQueue.java
different from instructions: I included a main() with the queue tester file that was provided to us inside this program.

this creates the TwoStackQueue class and it implements the MyQueue interface


~~~~~~~MyQueue.java
different from instructions:

This program solves the problem of making an efficient queue that adds people to one end and removes people from the other end.

It is an Interface that has two ArrayList stacks. stack1 is for enqueue/push methods, stack2 is for dequeue/pop methods. 

~~~~~~~Program2.java
different from instructions:

has a main() that tests the MyQueue and TwoStackQueue programs. There are a series of enqueue and dequeue operations, queue size checks and isEmpty checks.
