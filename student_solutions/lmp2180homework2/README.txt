Loie Plautz
lmp2180
Homework 2

Program 1: Symbol Balancing
Compile/run instructions:
First, put MyStack.java, SymbolBalance.java, and Test.java in the same directory. Then, compile MyStack.java (javac MyStack.java). Next, compile SymbolBalance.java (javac SymbolBalance.java). You do not need to compile Test.java. To run, run SymbolBalance and include Test.java in the command line argument (java SymbolBalance Test.java). If you run SymbolBalance without an argument, the program will prompt you for a filename. Once run, the program will print out any errors in the file, or say that it is balanced if there are none. 
The program runs like the assignment asks, printing different error messages if there's an opening symbol without a close, closing without opening, or a mismatch. The error messages include the symbol/symbols involved in the error. The stack class is generic, and uses ArrayLists. There is some overlap in errors; sometimes, the program finds a mismatch where there is an unopened/unclosed symbol. This is still technically a correct way to document the error found, because an unopened/unclosed symbol with another symbol can be considered mismatched. 

Program 2: Two Stack Queue
Compile/run instructions:
First, put MyStack.java, TwoStackQueue.java, Program2.java, and MyQueue.java in the same directory. Then, compile MyStack.java (javac MyStack.java). Next, compile MyQueue.java (javac MyQueue.java). After that, compile TwoStackQueue.java (javac TwoStackQueue.java) and compile Program2.java (javac Program2.java). Once all the files are compiled, run Program2 (java Program2). 
The program runs like the assignment asks, enqueuing 1-5 in order, then dequeuing and printing the numbers in order 1-5. 


