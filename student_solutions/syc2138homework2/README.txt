Sharon Chen syc2138 10/2/16
Data Structures Homework 2
README.txt

Files:
1. written.txt
2. SymbolBalance.java
3. MyStack.java
4. Test.java
5. TwoStackQueue.java
6. MyQueue.java
7. Program2.java
8. Program2.txt
9. README.txt

Descriptions:

1. written.txt
Problem 1 contains a method printLots that prints out line by line every element in L that occur at every position value that is present in P using an Iterator.

Problem2 contains a method that returns a generic list that has as its values, with no repeats, the values that occur in both list1 and list2, with the use of an iterator.

Problem3 contains a generic class MyStacks<E> that uses an array of type E elements to implement two stacks. To keep track the sizes of the stacks and make sure to notify the user of a stack overflow, indexes are kept track of. Push, pop, and top methods all have a parameter that specifies which stack to alter, 0 for stack1 and 1 for stack2.

Problem4 gives a sequence of steps as the solution to the problem. Also, a sequence of cars is given that cannot have a solution.


2. SymbolBalance.java

This program checks code for symbol balancing. It also displays the symbol balancing error or a success message, depending on the condition of the file's text. Its algorithm depends on MyStack for the stack data structure.

To compile and run this SymbolBalance with the Test.java test file, simply go to the command prompt and type this:
javac SymbolBalance.java
java SymbolBalance Test.java

The Test.java filename here is a command line argument and is accessed by args[0] in the main method. The method loops through the text until it reaches the end of the text with no mismatch found, or when it finds a mismatch. The open characters (, {, and [ are pushed onto the characters stack when they are encountered. The closed characters ), }, and ] are matched with the topmost character in the stack. If the close character corresponds with the open character that is popped off the stack, no mismatch is found. Otherwise, a mismatch is found.

The quotation mark " and /*, which denote the start of a string and a comment, both demarcate the beginning of text that are not considered in symbol balancing. That region of text ends when a " or */, respectively, appears. If they don't appear, or if */ appears even though /* didn't, then a mismatch has been found.


3. MyStack.java

This class defines the stack data structure using the LinkedList implementation. Push is defined in terms of addFirst, while pop is defined in terms of isEmpty and removeFirst.


4. Test.java
This is a .java file that is used as a test file input for SymbolBalance.java. To use it, type this:
java SymbolBalance Test.java

Because the multiline comment in Test.java that starts with /* is not ended, the error message "Unbalanced! Symbol /* is mismatched" is printed. Here is exactly what is printed in the command prompt:

import java.util.LinkedList;
/**
 *A class that defines the stack data structure.
 *@author Sharon Chen syc2138
 *@since 10/1/16
 */
public class MyStack<E>
{
Stack: {

        public MyStack(
Stack: (, {
)
        {
Stack: {, {

                stack = new LinkedList<>(
Stack: (, {, {
);
        }

        /**
         *Finds size of the stack.
         *@return the size of the stack
        public int size()
        {
                return stack.size();
        }

        private LinkedList<E> stack;

}

Unbalanced! Symbol /* is mismatched.


5. TwoStackQueue.java

This program implements MyQueue and uses two stacks to implement a queue. It has enqueue, dequeue, isEmpty, and size methods that use the MyStack methods pop, push, and size. To test this, use Program2.java by typing in javac Program2.java and java Program2.


6. MyQueue.java

This is the interface of a queue, so it includes public method signatures that every queue should implement.


7. Program2.java

This is a tester class for the TwoStackQueue.java. To use this, type these two lines:
javac Program2.java
java Program2


8. Program2.txt

This text file contains the explanations of the big-O running time costs of the enqueue and dequeue methods of TwoStackQueue.java. It contains code snippets that are relevant to the methods so that one can read explanations and also see code.

9. README.txt
This file! :)
