Name: Anlan Huang  UNI:ah3358

1.
SymbolBalance.java take a the name of a java file as a command line argument.
Read in the file and check to make sure that all { }'s, ( )'s, [ ]'s, " "'s,
and /* */'s are properly balanced and ignore characters within literal strings
and comment blocks.

MyStack.java implements stack methods with basic list operations, not the stack
operations themselves.

Compile and run the program as such:

javac MyStack.java
javac SymbolBalance.java
java SymbolBalance Test.java

The program outputs whether or not the symbols are all appropriately balanced.
If they are not, it indicates which error condition occurred and what symbol
type caused the problem.

2.
TwoStackQueue.java builds a queue out of two completely separate stacks, S1
and S2. Enqueue operations happen by pushing the data on to stack 1. Dequeue
operations are completed with a pop from stack 2, using only push and pop
operations. TwoStackQueue provides the Queue ADT using two stacks and
explicitly implement the interface provided.

Program2.java is the tester class with a main method to demonstrate that the
TwoStackQueue works correctly (by enqueueing a number of objects and then
dequeueing and printing them in the correct order).

Compile and run the program as such:
javac MyQueue.java
javac TwoStackQueue.java
javac Program2.java
java Program2

If implemented correctly, this code should output:
Saber
Archer
Lancer
Caster
Assassin
Berserker
Rider
0
null
