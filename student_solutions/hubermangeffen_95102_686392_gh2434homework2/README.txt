Geffen Huberman
gh2434

ReadMe

Programming Part 1: 
Contains MyStack.java and SymbolBalance.java. Compile both in order to run the program. Then run SymbolBalance with a file name (save the file first) printed afterwards as args[0]. Prints whether your file is balanced, and if unbalanced, what symbol is the source of the problem. 

MyStack.java:

Implements stack methods using a linked list. 
Extra methods that I added are isEmpty(), toString(), and getSize(). 
isEmpty() is used in SymbolBalance.java to check that, if indeed all of the symbols are matched, the stack should be empty by the time the file finishes reading. 
toString() is used for testing purposes; since the linked list class already so carefully has a toString() method this proved simple.
getSize() is used for the TwoStackQueue.java class for Programming Part 2. In general it also seems like a useful method to have in a stack for future use. 

SymbolBalance.java:

A BufferedReader is used to read through the file, which runs in a while loop, reading each line at a time and placing the characters from the line into a character array. This array is iterated through, checking if each character is a symbol. 

For symbols { [ ( and their closing counterparts, pushing this character on the stack can happen in two conditions (lines 28 and 31 of file): either it is an open symbol, OR it is a close symbol AND the top element of the stack is not its respective open symbol. In this case, we know that a close bracket will have no later companion and thus the file is iterated through until the end and returned. 
The methods I created for this purpose are IsOpenSymbol, isCloseSymbol, and OpenCloseEqual.

For checking for comments (starting line 49)I first check that we haven’t reached the last index of the array since we must check both the current character and the character following it. If I find an open comment, I iterate through the line until its closed counterpart is found. If it is not found on the next line I look for a comment on following lines. 
The methods I used for this are isOpenComment, isCloseComment, CommentIterator and isSlash.

If I find quotations, I iterate through until I get to the end of the line. If I haven’t found the close quote, I know that it will never close, so I read the lines all the way until the end of the file and return the error. Methods used are isQuotations and StringIterator

In order to express the specific error received from a non-empty stack, I created a method called createErrorMessage that would return a different message based on what was wrong with the file. 


Programming Part 2:
Contains TwoStackQueue.java and TwoStackQueueTester.java. Both need to be compiled and TwoStackQueueTester needs to be run. 

TwoStackQueue.java:

Implements the MyQueue.java interface. For enqueue(), AnyType x is pushed on to the stack. For dequeue, all elements but the first one added to the stack are pushed on to stackie2 so that the first one can be popped. Then, the elements are all added back to stackie1 and removed from stackie2. 

TwoStackQueueTester.java:
Has a main method that creates a TwoStackQueue<String>. 

Should print: 
0
4
Te
di
Scordato
Son
mi
Eppur
T'ho
Fatto
Piangere
Tanto
Per che
I sono
Un brutto
Lo so
0