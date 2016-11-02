Name: Victor Au
UNI: va2239
COMS W3134

Homework #2

I am submitting:
1. written.pdf
2. SymbolBalance.java (the main method is here)
3. MyStack.java
4. Test.java (for use with SymbolBalance)
5. TwoStackQueue.java
6. MyQueue.java
7. Program2.java
8. Program2.txt
9. README.txt

----------

WRITTEN PROBLEM 1:

My original solution was O(N^2), so I changed it up to make it O(N). First, I do some checking to make sure that both lists have at least one element and that P's elements stay within L's bounds. Then I combine the use of an enhanced for loop for L and an iterator for P. This is doable because both L and P are sorted! As the program traverses through each element of L, if counter matches position (position being itrP.next()), then the program prints out that element and essentially calls itrP.next(). The program does that for every element of L, seeing if its index matches with P's element. This is because P's elements dictate which elements of L to print out.

I only make one pass-through for each list, so this solution has a big-O running time of O(N).

Note: I checked Piazza, and a TA (Iris?) said that it should be safe to assume that P will have no repeated elements. I wrote this solution under that assumption.

----------

WRITTEN PROBLEM 2:

The goal of this problem is to find the intersection of lists L1 and L2 (and to have no duplicates). My original solution was O(N^2), so I changed it up to make it O(N). I use L3 as my intersection set. First, I check to see if either list is empty; if at least one is, the intersection is empty! I then use a while loop to keep track of two iterators (one for each list), and I use the Comparable interface's compareTo method to compare an element from L1 and an element from L2 and to see which element is bigger. If L1's element is greater than the L2 element it's being compared to, then I advance the second iterator via next()--if it can be advanced. If L2's element is greater, then I advance the first iterator via next()--if it can be advanced.

If they match, then I check for two more conditions. L3 has to be empty, OR L3's last element cannot match the new element (this is to avoid duplicates!). If either of these conditions holds true, I add the new element to L3. I also advance potentially both iterators via next()--depending on which can be advanced. The way I wrote my code doesn't quite cover the very last pair to be compared, so I add one more if-statement after the while loop to compareTo L1's element with L2's element.

At the end, I just print out L3, the intersection set. This solution should have a big-O running time of O(N).

----------

WRITTEN PROBLEM 4:

The solution I wrote in pseudocode involves the same steps as the Java solution. The only real difference is that my pseudocode would display the output track's "front" as the right and the "back" as the left. My Java code would display the output track's "front" as the left and the "back" as the right. This is because the Java Queue interface uses addLast and removeFirst, while the problem's queue essentially uses addFirst and removeLast.

----------

PROGRAMMING PROBLEM 1:

The goal of this problem is to create a class that takes a Java file as a command line argument, read in the file, and then check to make sure that the following symbols are balanced: { }, ( ), [ ], " ", and /* */.

For my instance variables/data, I declare and instantiate an object of MyStack<Character> (to help keep track of the symbols), a boolean stringLiteral (to help keep track of whether we're in a string literal), a boolean blockComment (to help keep track of whether we're in a block comment), and a char previous (to help keep track of the first char when checking for /* and */).

I split the problem into several steps.

1.
My main method creates a file (based off what the user types in for args[0]) and calls the method readFile() on it. 

2.
The readFile() method creates a FileReader and BufferedReader to scan through the file line-by-line. I googled and used this site to help me read the file line-by-line. (http://www.programcreek.com/2011/03/java-read-a-file-line-by-line-code-example/)

In each line, I use a for loop to traverse through each character. I keep track of the current character, c, and the previous character, previous. If blockComment is false (meaning that we're not currently in a block comment), the program calls stringCheck to check for the start/end of a string literal (indicated by "). If stringLiteral is false (meaning that we're not currently in a string literal), the program calls commentCheck to check for the start/end of a block comment (indicated by /* and */, respectively). If both stringLiteral and blockComment are false, then the program calls symbolCheck to check for {}, (), and [].

3.
The stringCheck method takes in a character as a parameter and checks for the start or end of a string literal. If the character is ", then it peeks at the top of the stack. If peek reveals ", it pops the " and sets stringLiteral to false (signifying the end). If peek doesn't reveal ", it pushes " to the stack and sets stringLiteral to true (signifying the start of a string literal).

4.
The commentCheck method takes in a character as a parameter and checks for the start or end of a block comment (indicated by /* and */, respectively). If the previous and current chars are / and *, AND blockComment is false, then this will push * to the stack and set blockComment to true (signifying the start of a block comment). If the previous and current chars are * and /, then this will check if blockComment is true or false. If it's true, this will pop the stack and set blockComment to false (meaning that we're exiting the comment). If it's false, this will print that there's a missing /* (because there can't be an ending to a block comment if it never began!).

5.
The symbolCheck method takes in a character as a parameter and first checks if the current character is {, (, or [. If it is one of those three, the program pushes the character to the stack and then returns to readFile().

The method then checks if the current character is }, ), or ]. If the character happens to be one of those three, the program first checks if the stack is empty. If the stack is empty, it means that there's a missing left symbol for that right symbol! The program will print out the symbol that's missing and then exit the program via System.exit(0).

If the stack isn't empty, then the program will pop the stack and compare that popped element to the current character. If they are equal, that iteration of the for loop is done, and the program will basically go back to readFile(). However, if they aren't equal, this means that there's a symbol mismatch! The program will print out that the file is unbalanced and also which left symbol is mismatched with which right symbol.

6.
After the program is done running stringCheck, commentCheck, and/or symbolCheck on each character of each line, the program moves on to the rest of readFile(), beginning with closing the BufferedReader. 

The program then calls the checkRestOfStack() method, which checks if the stack is empty or not. If it's not empty, it means that there's a symbol imbalance. It peeks at the stack's top element and prints out what the corresponding missing element is before exiting the program via System.exit(0). The program then goes back to readFile() and then prints out a message saying that the file doesn't have an imbalance.

----------

PROGRAMMING PROBLEM 2:

My approach is to store the elements of the queue into stack1. If I want to enqueue, I push() an element to stack1. If I want to dequeue, I transfer stack1's elements to stack2 via push/pop (using my transferStackElements() method, which reverses the order of the elements due to the nature of how push/pop works), pop stack2 and capture that element into a variable, transfer stack2's elements back to stack1 via my transferStackElements() method, and then return that element that was popped from stack2. The important part of this approach is that data would usually stay within stack1, only temporarily moving to stack2 when calling dequeue().

My dequeue() method has an "if" case, which returns null if the queue is empty. The "else" case is trickier. It has four steps:
1. Transfer stack1's elements to stack2, reversing the order.
2. Popping stack2 and saving that element to a variable (anyType returnElement).
3. Transfering stack2's elements back to stack1, reversing the order again.
4. Returning returnElement, the popped element from stack2.

My size() method simply returns the size of stack1, and isEmpty() returns true if stack1.size() is 0. (This is because the data usually is contained in stack1.)
