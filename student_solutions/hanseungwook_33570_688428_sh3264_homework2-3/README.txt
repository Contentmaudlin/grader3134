Seungwook Han
sh3264
Programming Project 2
README file

Overall, all parts of the programming project work correctly - as given by the instructions. Each of the classes has been elaborately commented as well; therefore, further explanation of my logic/algorithm could be found there.

Compilation needs to be done in the following order:
javac MyStack.java
javac SymbolBalance.java
javac Test.java
javac MyQueue.java
javac TwoStackQueue.java
javac Program2.java

The running classes are SymbolBalance.java (where Test.java is used as a file to be taken in as a command line argument) and Program2, which is a tester class of the TwoStackQueue.

SymbolBalance.java can be run with the code: 
java SymbolBalance Test.java

The Test.java could be replaced with any other file name that is in the same directory.

Program2 can be run with the code: 
java Program2


MyStack.java
This class is a simple generic implementation of a stack with LinkedList. Since we must use basic ADT methods, I used the addFirst and removeFirst methods for the LinkedList in order to push and pop from the stack. As for the pop method, if the stack size is smaller or equal to 0, then it does not pop anything but returns null.

SymbolBalance.java
The main method of this class reads from the command line argument to open a file, parse it into a String, and use the private isBalanced method in order to evaluate whether the file is symbol-balanced. A little bit of error handling is done through the try and catch IO exception e (when the given file name does not exist) and when no command line argument is given the respective error statement is printed. The isBalanced method implements a for loop going through the whole String of the given file character by character, but uses a stack with String because of the “*/“ “/*” comment handling. If the file is balanced, it prints the statement that the “This file is balanced!”. When it is not balanced, it outputs the statement that the file is not balanced along with the symbol that has been mismatched.

Test.java
This is a test file for the SymbolBalance class. This file checks every part of the code, whether it correctly ignores all the symbols placed inside quotation marks or comment blocks and whether it correctly matches the symbols. I have designed it so that the ‘[‘ is mismatched on line 21. This works correctly and outputs the statement that the file is unbalanced and that ‘[‘ is mismatched.

TwoStackQueue.java
This class implements the Queue ADT by using two stacks. This makes use of the MyStack.java that we have explained above. The constructor creates two stacks, one for input and another for output. The enqueue method always pushes the respective AnyType object into the input stack. The dequeue method returns null when the input stack and output stacks are both size 0. When the input stack is not empty but the output stack is, it transfers the data from the input stack onto the output stack and then returns the latest value popped from the output stack. When the output stack is not empty, it just passes on and pops the latest value from the stack. isEmpty method checks whether both input and output stacks are empty and the size method sums the size of the input and output stacks to get the whole size.

Program2.java
This is a tester class that creates and uses the TwoStackQueue ADT. I have written the expected output of the tester class in the comment block and, as far as I know, this is working properly.