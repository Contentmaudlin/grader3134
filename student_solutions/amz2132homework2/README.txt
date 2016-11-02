Angela Zhang
amz2132
COMS 3134 Data Structures
Homework 2

Files being submitted:
written.txt
SymbolBalance.java
MyStack.java
UnbalancedSymbolException.java (used in SymbolBalance.java and MyStack.java)
Test.java
TwoStackQueue.java
MyQueue.java
Program2.java
Program2.txt
README.txt



I compiled and ran my programs from terminal, so you should just be able to use the javac command to compile the programs and use the java command to run them. 

written.txt contains the written hw from the Weiss textbook and the problems in the instructions.

SymbolBalance checks to see if all special symbols specified in the homework instructions are properly balanced. For the quotation mark and comment cases, the stack was not used and instead I used a for loop to just check if the proper closing mark was present as this allowed me to ignore characters within the string literals and comment blocks. I wrote an exception class UnbalancedSymbolException and used it in both SymbolBalance.java and MyStack.java.

MyStack.java utilizes methods found in the LinkedList class to create functions of stacks such as top, pop, push, isEmpty, and size.

UnbalancedSymbolException.java is an exception class that I wrote and is used in MyStack.java and SymbolBalance.java.

Test.java tests to see if SymbolBalance. java can notice an unbalanced quotation mark.

TwoStackQueue.java creates a queue using two stacks, input and output. Anything enqueued is pushed to the input stack, and dequeues occur by transferring the input stack elements to the output stack elements one by one in reverse order (ie input stack: 1,2,3,4 would become output stack: 4,3,2,1) and then popping the output stack. The isEmpty method takes the size of both stacks into account when determining if the queue is empty. The size method takes into account the sizes of both the input and output stacks.

MyQueue.java was provided by the instructors.

Program2.java is a tester for the TwoStackQueue class, that enqueues and dequeues strings and, at the very end, dequeues the entire queue.

Program2.txt describes the big-O running time for the TwoStackQueue class. 
