Sunand Iyer
sri2117

HW 2:

For pseudocode, I assume indexing starts at 0. 


Programming 1)

File Name: MyStack.java

This file is for implementing a stack. The instance variable is a linked list called stack. It is instantiated in the constructor. The void method push just adds an element to the 0th index (front) of the stack. The method pop returns the first element of the stack and removes that element from the stack. This is done using the remove method of a LinkedList. If the stack is empty (size is 0), then the method just returns null. The peek method works like the pop method except it doesn’t remove the first element. This isEmpty method returns a boolean that says if the stack is empty (True) or not (False). The size method returns an integer that is the size of the stack. 

File Name: SymbolBalance.java

This contains the main method to check to see if a file is balanced. Since, files are being read in, the try and catch clauses are used. A scanner is used to read through the file. The code reads through each line. It iterates through every character in the line. Also if the index i is less than length of line - 1, the substring of the line of index i and i + 1, is stored. This is to see if that substring equals /* or */ to indicate comments. If the string equals “/*” that means entering a comment so the boolean inComment is now true. If the string is “*/“ and inComment is true, that means we are at the end of the comment and inComment is false. If the string is “*/“ but inComment is false, that means we encountered end of comment without “/*”, so therefore there is an error. There also is the case of /*/ so when a */ is encountered the program has to check if the previous character is / to know that it should still stay in a comment if that is the case. The program prints the error and sets matched to be false. The variable matched is a boolean, that is true when the code is matched and false when an imbalance is found. I then check to see if I am in quotes. I the current character is a quote and the variables inQuotes and inComments are false, inQuotes is set to be true. If inQuotes is true and inComment is false, inQuotes is now false. I use booleans for quotes and comments since anything inside of these can be imbalanced and that won’t matter. Then if inComment and inQuotes are false and matched is true, I use switch case to check for the balancing of {}, [], and (). If I encounter a {, (, or [ I just push the character to the stack. If I encounter a },), or ], I first check to see if the stack is empty. If the stack is empty, I just print that there is a closing symbol with no respective opening symbol. I then set matched to be false. If the stack is not empty, I pop the item. If the popped item does not match the respective character at the current position (for example popped a ( when looking at }), matched is set to false and the program prints that the popped item is mismatched. While this is what my program prints, it can also be read that the character I am looking at is mismatched. After iterating through the entire file, the program runs a few more checks before it can say something is balanced. If inQuotes is true and matched is true, that means there was not closing quotations and the program prints such. If inComment is true and matched is true, there was no closing comments and the program prints such. If the stack is empty and matched is true, print balanced. If the stack is not empty but matched is true, that means the character that is popped from the stack is not matched. 

File Name: Test.java

This file tests to see if the program can detect when there is a closing for a comment but no opening. The output should print: */ matched with no /*.

To compile enter the following into Terminal/Command Line: javac SymbolBalance.java
To run: java SymbolBalance [testfile]

*When testing for Test4.java, my program prints that the { symbol is mismatched even though the description for the file says to test for unbalanced ] operator. This is because my program pushes a { onto the stack and then encounters a ]. It expects the ] to be a }, so therefore thinks that the { is matched with a ] and thus produces the error statement. This is how I have designed my program.  



Programming 2)

File Name: TwoStackQueue.java

This file is for implementing a stack using two queues. The TwoStackQueue implements the MyQueue Interface. The TwoStackQueue has an input stack (S1) and an output stack (S2) as instance variables. These variables are the 2 MyStack objects that represent the stacks. The constructor just initializes the 2 stacks. The enqueue method takes in a variable of type AnyType and just pushes the parameter into S1. The dequeue method first checks to see if S2 is empty since S2 is the stack which is popped to produce the output. If S2 is empty, S1 (input stack) is reversed since the first item pushed is at the bottom of S1. Each element of S1 is popped and pushed to S2, thus reversing S1. If after this, S2 is still empty, then the queue is empty and the method returns null. Otherwise, the method returns the top element of S2. The isEmpty method returns a boolean saying whether the queue is empty or not. It checks to see if both stacks are empty and returns true only if both are empty. The size method sums up the sizes of S1 and S2 and returns it as the size of the queue. 

File Name: Program2.java

This file is for testing the TwoStackQueue class. A TwoStackQueue of String objects is created, q. “Peter”, “Paul”, and “Mary” are enqueued in that order. The size is then printed to make sure that the method works. 3 is expected. Then the dequeue method is called. Next the size method is called, to make sure that it prints 2 now that something has been dequeued. Then it checks to see if the queue is empty and correctly prints false. Then it iterates through a while loop and prints out what it dequeues to make sure it outputs in correct order. It then tries to dequeue when queue is empty and correctly outputs null. The order of what should be printed is mentioned in the file. 

For compilation, the 3 files (MyQueue.java, TwoStackQueue.java, and Program2.java) all have to be in the same directory. The following can be pasted into Terminal/Command Line to compile: javac Program2.java
Then to run the file: java Program2
Output should be:
3
2
false
Paul
Mary
null