Jack Ricci
jr3663

The following files are included in the directory jr3663homework1:

1.) Written.txt - This file contains the written portion of Homework 2

2.) SymbolBalance.java - This java file contains the BalanceSymbols method that balances the opening and closing
 symbols in any .java file. SymbolBalance.java also contains the main method used to drive BalanceSymbols

     *In order to compile and run SymbolBalance.java, the user should:
        1.) Navigate to the directory that SymbolBalance.java is in
        2.) Set the path variable to the location of the jdk bin
        (for instance, using my windows shell, I did:
        $ set path= %Path to jdk bin%
        3.) Compile SymbolBalance.java by running:
        $ javac SymbolBalance.java
        4.) The Java file to be checked should be the first command line argument so run SymbolBalance by running:
        $ java SymbolBalance NAME_OF_JAVA_FILE.java

3.) MyStack.java - This java file contains a generic stack class that implements the basic stack operations.
    *The MyStack class instantiates a linked list in order to perform its operations
    *The MyStack class does not require independent compilation or running, as for this assignment it is automatically
    compiled when SymbolBalance.java and Program2.java are compiled

4.) Test.java - This java file is the test file to be passed as the only command line argument when running
SymbolBalance.java
    * The file consists of a random assortment of comments, brackets, braces, and quotes. It should return an error
    for an incomplete quotation

5.) TwoStackQueue.java - java file that contains the TwoStackQueue class. TwoStackQueue implements the MyQueue
interface and instantiates two stacks that serve as the foundation of the queue
    *TwoStackQueue.java does not require independent compilation or running, as it is compiled during the compilation
    of Program2.java

6.) MyQueue.java - java file that contains the MyQueue interface.
    *This interface specifies the 4 methods that TwoStackQueue must implement
    *This file is also not compiled or run independently

7.) Program2.java - java file that contains the main method that drives the TwoStackQueue
    *main method contains two instantiations of the TwoStackQueue, one that performs queue operations using a
    queue of integers and the other is simply the test case provided on courseworks to show that the queue also works
    for String objects

    *In order to compile and run Program2.java, the user should:
            1.) Navigate to the directory that Program2.java is in
            2.) Set the path variable to the location of the jdk bin
            (for instance, using my windows shell, I did:
            $ set path= %Path to jdk bin%
            3.) Compile Program2.java by running:
            $ javac Program2.java
            4.) Run Program2 by running:
            $ java Program2

8.) Program2.txt - text file that analyzes the Big O run times of the enqueue and dequeue methods in TwoStackQueue.java