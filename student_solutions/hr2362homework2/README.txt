README.txt

Homework 2
Kelly Ryu (hr2362)

<MyStack.java>

The MyStack object uses a generic LinkedList to push new elements and pop the element last entered. peek(), empty(), and size() methods are also defined. If the stack is empty, peek() and pop() methods simply return null. 


<SymbolBalance.java>

The java class takes in a text java file as an argument and prints out the first of any [], {}, (), “”, /**/ imbalances. The program must be run with a text file name as a command line argument.
Since the quotation marks must be in the same line to be correct, the program marks each new line with ‘ /n’ characters. For example, a file with only one quotation mark on two consecutive lines would print an error. Everything within the quotation marks of the same line or in between /* and */ are ignored. The MyStack object is used to store the opening brackets. When a closing bracket is encountered, the stack is popped to see if the last encountered opening bracket matches that one. 


<TwoStackQueue.java>

The class inherits enqueue, dequeue, isEmpty, and size methods from the MyQueue interface. The enqueue method pushes the element onto stack1, which stores the elements in a first-in-last-out order. The dequeue method pops one element from stack2, which stores the elements in a first-in-first-out method. Thus the elements are passed back and forth between the two stacks depending on the operations performed. 