Andrew Lee, awl2144, Data Structures with Dr. Blaer Fall 2016

Written Homework:

1. This code works by creating iterators for both the list of entries and
the list of indices. We save idxL to be the index in the list of entries
and index P is the index that we are currently looking for in List L and
prints the entries in List L out if they match the indices in List P.
The first while loop runs until you run out of indices to search for.
The second while loop saves the last index you are looking for in list P
and traverses the rest of List L to find it.

2. Because both lists are in ascending order, so you traverse both at the
same time, increasing the iterator on list 1 if the current entry in list 1
is lower than the entry at list 2 and needs to catch up, and vice versa. If
the two entries are equal, it is part of the intersection and is then added
to the list that is returned.

3. The two stacks in an array works by building one stack from each end of
the array. We keep two indices, one for the index of the top element in
each array, which begin at 0 and the length of the array minus one. In each
of the push methods, it checks if you push to an index already occupied by
the other stack and throws an exception if it is. For both pop and peek
methods, you check if the index you are checking is in bounds. In the case of
pop, you return them. IsEmpty methods check to see if the top of the stack
is at the ends of the array, in which case they are empty. Size returns the
end indices, which are the sizes of the stack (in size2 it is the length of
the array minus end2 minus 1). Note: this implementation is just for ints. The
problem did not specify any type requirement.


Programming Homework:

1. The SymbolBalance class requires a stack, which is written in MyStack.java.
This class uses a LinkedList to store data. Popping and pushing added and remove
elements from the front of the LinkedList. Peek returns the first element of
the LinkedList without popping it off the stack. IsEmpty and size simply use the
already implemented methods of the LinkedList. I added a toString method for
debugging purposes.

The SymbolBalance class first reads in the text line by line in the readSmalTextFile
method, which we call in the main method using the argument given in the command line.
The method uses the File and Path classes and the UTF8 character set to read in a
java file. (Thanks to: http://www.javapractices.com/topic/TopicAction.do?Id=42) for
helping me understand reading in text files with Java.

The method gives us a List of strings, which we then call the putSymbolsInStack
method on. The role of the putSymbolsInStack is to create an ArrayList of brackets,
paratheses, curly braces, and quotation marks called brackList, which is then passed into
the checkBrackets method. The putSymbolsInStack method also handles comments and literal
strings, which are kept track of using two booleans. If either of these two booleans
is on, it means that you are in a comment or literal string, and the symbols after a
comment start or opening quote are not added to brackList. This does not handle single line
comments (//), which we are exempt from dealing with in the problem.

Note: This program does not deal with strings that are longer than one line. If the
code reaches the end of a line and a quotation mark is not closed, an exception for
a mismatched quotation mark is thrown and caught. The code also does not deal with
escape characters.

After going through putSymbolsInStack, the list of relevant brackets(meaning not in a
comment or literal string) is passed to the checkBrackets. Here, a stack is instantiated
and opening symbols are pushed to the stack. When a closing bracket is reached, it pops
the stack, because the corresponding opening bracket must be the most recent entry to the
stack. If it does not match, an error is printed out.

If there are more opening brackets than closing brackets, there will be opening brackets left in the stack after the for loop, which are then printed out as mismatched. If there
are more closing brackets than opening brackets, then the method will try to pop from
an empty stack, and an exception will be caught. The variable idx is used to keep track of
which extra closing bracket is causing the error. It starts at -1 because of the enhanced
for loop. However, this shouldn't cause any problems unless the first bracket in the stack
is a closing one.

To run it:

javac SymbolBalance.java
java SymbolBalance Test.java

The first line with compile all necessary classes. The test class I provided deals with
a mismatched[ and ).

2. For the two stack queue, I used the MyStack class that I wrote for the symbol
balance problem. The TwoStackQueue class contains all the workings of the queue.
The enqueue operation adds the object to be pushed onto the top of stack1. Every
time you dequeue, you pop all the entries from stack1 and push them to stack2,
basically flipping stack1 upside down. Then popping from stack2 returns the object
that was in the queue in the longest. In the dequeue method, stack2 is then flipped
back into stack1 to prepare it for the next operation. Size runs on the size of stack1
because all the entries are stored in stack1 except for a moment during the dequeue
operation. IsEmpty runs on stack1 as well for the same reason. Included is Program2.java,
which includes two test examples, one with Strings and one with integers. To run
this tester class, type the following into the command line:

javac Program2.java
java Program2

Compiling Program2 automatically compiles TwoStackQueue.java and MyStack.java



