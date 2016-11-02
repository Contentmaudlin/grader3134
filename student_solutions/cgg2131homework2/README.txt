README.txt
Data Structures - Homework 2
Connor Goggins

I am submitting the following files:
written.pdf
SymbolBalance.java
MyStack.java
Test.java
TwoStackQueue.java
MyQueue.java
Program2.java
Program2.txt
README.txt


SymbolBalance.java takes the name of an input Java file as a command line argument, parses
that file into a String, and pushes opening characters to a stack implemented using my
custom stack interface.  If there is a mismatch, imbalance, or a closing symbol without a
corresponding opening symbol.

MyStack.java is a custom generic stack class implemented using LinkedList.  MyStack gives
me the functionality necessary to create stack objects in SymbolBalance.java and
TwoStackQueue.java.  Although the underlying data structure may be a LinkedList, only basic
list operations were used to simulate the stack's methods.

Test.java is structured as a sample file for testing SymbolBalance.java.  The error case
that this specific test file checks for is if SymbolBalance.java will catch a */ with no
beginning /*.


To successfully execute SymbolBalance.java, use Terminal to navigate to the directory where these
files are located.  Then type in the following two lines, each followed by the enter key:
javac MyStack.java
javac SymbolBalance.java

This will compile both MyStack.java and SymbolBalance.java.  Now, type in the following line
and press enter to run the program.  Please note that Test.java can be substituted for your
desired test file:
java SymbolBalance Test.java


TwoStackQueue.java implements a generic queue using two generic stacks.  I instantiated the stacks using
the MyStack class I wrote earlier.  To support pushing to one end and popping to the other
end of the queue, I designated one stack as the input stack and the other stack as the
output stack.  When I wanted to push an element to the queue, I popped each element from
the output stack and pushed it to the input stack, then pushed the new element to the input
stack.  When I wanted to pop an element from the queue, I popped each element from the input
stack and pushed it to the output stack, then popped the output stack once.

MyQueue.java is the interface that I implemented to develop TwoStackQueue.java.  It declared
all the methods that I needed to describe in TwoStackQueue.java.

Program2.java is the program I wrote to test whether my TwoStackQueue functions as intended.
In it, I test all relevant operations and also provide a correct output to compare with
the actual output.

Program2.txt describes the time complexity of the enqueue and dequeue operations for my
TwoStackQueue.


To successfully execute Program2.java, use Terminal to navigate to the directory where
Problem2.java is located.  Then type in the following lines, each followed by the enter key
to compile the code:
javac TwoStackQueue.java
javac MyQueue.java
javac Program2.java

Now, type in the following line and press enter to run the program:
java Program2