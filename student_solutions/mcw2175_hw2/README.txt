COMS 3134 Homework 2
Madeline Wu (mcw2175)
October 7, 2016

GENERAL (compiling):
The functionality of TwoStackQueue can be tested by running the main method of Program2.java
using javac Problem2.java then java Problem2.
SymbolBalance can be tested by running it in the command line with the name of the desired test file
as a command line argument (ex: javac SymbolBalance.java, then: java SymbolBalance Test.java).
MyStack doesn't have it's own test file but is used in TwoStackQueue and SymbolBalance.

WRITTEN:
Problem 1 uses list iterators. P is assumed to be a list of integers,
while L is a generic type list. While both iterators have next elements,
and index int is used to keep track of what element of L is being examined.
If the index matches the current element from P, the item at that index of L
is printed. Otherwise, it is skipped over with a call to next().

Problem 3 creates two stacks from one array by having the bottom of one stack start
at the front of the array and the bottom of the stack stack start from the back. When items
are pushed onto Stack 1, index1 is incremented and the pop1() method returns the item at
index1 and decrements index1. When items are pushed onto Stack 2, index2 is decremented
and pop2() returns arr[index2] and increments index2. The stack is full when index1 = index2.

TWO STACK QUEUE:
The TwoStackQueue class implements the given MyQueue interface and creates a queue
using two instances of the MyStack class, which uses LinkedLists to implement a Stack.
Calls to the enqueue method push items onto the first stack, while calls to dequeue
pop the first item off of the second stack, or pop all items off of the first stack
and push them onto the second stack first if the second stack is empty when the method
is called.
Items can only be moved off of the first stack if the second stack is empty
to ensure that items are popped off of the second stack in the right order
(everyone that is on the second stack should be returned by the dequeue method before
anything on the first stack).

SYMBOL BALANCE:
The main method uses a BufferedReader to read a file line by line, and the method
that checks for balanced symbols runs on each line of the file, treating each line as a string.
An instance of MyStack was used to keep track of symbols in the file.
Within the balanced() method, each line was reader character by character, with
any spaces, tabs, periods, semicolons, and upper and lowercase letters skipped over.
Each line/string was checked first to see if it was part of a comment starting with /* and ending
with */.

If part of the line was a string, denoted by '' or "", its contents were ignored.
If the current character was not part of a comment or string, it was checked to see if it was a symbol.
Open braces like (, {, or [ were pushed onto the stack. If a closed brace was encountered,
the stack was checked using peek() to see if its matching open brace was at the top of the stack.
If not, the closed symbol was pushed onto the stack. If so, the open brace was popped off of the stack.
If the stack was empty, the closed brace was added to the stack.

At the end of the file read, if the stack still had symbols on it, it was checked by another method,
check(), to see if there were matches within the remaining symbols. Any matching pairs were removed
and if the array list was not empty, all remaining symbols were unbalanced.
