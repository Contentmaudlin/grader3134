README.txt
==========
Homework 2
==========
Sungmin An
==========
UNI: sa3333
===========

SymbolBalance.java
==================
* Checks whether []’s {}’s /*’s & “’s are properly balanced. If one finds an error, report the first error found.  
* Compile the code the normal way via javac SymbolBalance.java, but run the code in the following way: java SymbolBalance Test.java (or whatever the test file is, put it as command line argument). Failure to do this results in an error that is caught in the main method and the subsequent (little impolite) message. 
* checkBalance method was written separately from the main method. 
* Error handling was done with try/catch statements in the main method to follow the design principle of dealing with error cases in the top-most layer of the program.
* String error holds the erroneous symbol so that the error message can be printed.  
* Booleans like isStringLit and isComment hold the value of whether one must ignore the characters inside the string literals or comments when these booleans are true. 
* Stacks were not used to account for string literals or comments. Instead, they were handled via aforementioned booleans. When ‘/‘ is found, we check whether the next char is ‘*’ if it is, then we know it’s a comment. For closing comment blocks, reverse logic applies. 
* If closing symbol */ is encountered without opening symbol, we immediately store it inside the error variable and break the outerloop so that the code is more efficient and doesn’t have to run through the entire loop. 
* The if statement at the end checks whether “ is balanced at the end of the line. If not, we give an error message and break out of the outerloop. 
* If the variable isComment is still true even after the end of the outerloop, this means that /* was never close. So we store “/*” as the error. 
* If there are still elements in the stack after the loop & no error has been found in the outerloop, we set the first unmatched element as error (the symbol in the bottom of the stack). 
* Last if/else statement in checkBalance prints the error message from the stored symbol. If the file is free of errors, it prints a success message. 
* The program checks the closing symbol for errors and prints out the opening symbol when the error is reported. For example, say we have [). Then the program will output “Unbalanced! ( is mismatched.”

Test.java
=========
* This file is merely a test file to test SymbolBalance.java.
* This file will never compile since it contains an error, so there is no need for it to run either. 
* When tested with SymbolBalance.java, that class will find that /* is unbalanced. 

MyStack.java
============
* Implements the Stack ADT. 
* There would be no need to compile this program separately, since this program will be automatically compiled when other classes like SymbolBalance.java or TwoStackQueue.java use it. But if one were to do so, use the standard format: javac MyStack.java 
* Similarly, there is no need to run this class since it’ll be run by other classes. 
* addLast(), removeLast(), getLast() methods were used from the LinkedList API to push(), pop(), and peek(), respectively. 

TwoStackQueue.java
==================
* Implements the MyQueue API by using two separate MyStacks. 
* This program will be automatically compiled by Program2.java or any other tester that is used. If one needs to compile it, do it via javac TwoStackQueue.java. 
* Similarly, there is no need to run this program independently because it will be run by Program2.java. 
* Enqueue() was implemented via pushing item x into S1. size variable was used to keep track of the size of the imaginary queue since there is actually no queue, only two different stacks. 
* isEmpty() method from the same class was used to check whether the queue is empty. If it is and one tries to dequeue(), returns null. 
* If/else statement in dequeue() checks whether S2 is empty. If it is, there is no need to move the elements from S1 into S2, and we can just pop the top element in S2 to dequeue. This makes the code much more efficient and it might run in O(1) instead of O(N) when this is the case. 
* While loop and S2.push(S1.pop()) was used to copy over all elements in S1 into S2 so that the order of the elements in S1 is reversed in S2. 


MyQueue.java
============
* Interface that TwoStackQueue implements. 
* This will be automatically compiled and run by Program2.java or any other tester that tests TwoStackQueue.java.

Program2.java
=============
* Tester class for TwoStackQueue.java.
* Compile via javac Program2.java. Run by java Program2.
* Tests all the methods in TwoStackQueue.java. 

Written.txt
===========

Problem1: 
* Handles all cases regardless of whether size L > P, P > L, or P = L. 
* Assumes that L is generic and P is Integer from the problem description. 

Problem2: 
* Assumes that the lists contain integers, just as Professor Bauer mentioned in Piazza. 

Problem3:
* When you pop an object, it doesn’t actually remove it from the array since it’ll get overwritten later. 
* Instead of keeping track of the size, top2 was set as list.length-1 so the second stack starts at the end of the array and increases in size by top2 moving leftwards. 
* By this logic, stack overflow happens whenever top1 == top2 + 1. +1 is needed because top keeps track of the unfilled top index of the stack. This may seem uncomfortable because it means that top1 can be equal to list.length, but when it is so, one must pop the stack1 in order to either push an element into stack1 or stack2. So the program is perfectly sensible. Similar logic applies when top2 == -1. 
* When popping/peeking a stack, check whether stack is empty by using the isEmpty1() or isEmpty2() methods. If the stack is empty, print out a mean message and returns null. 
* In peek1() & peek2(), prev variable is needed to make sure the returned element doesn’t get removed.  



