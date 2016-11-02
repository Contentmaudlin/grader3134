////////////////////////////////////////////////////

Maryam Aly 
UNI: mya2114
DATE: October 5th 2016
HW 2 
Professor Blaer

///////////////////////////////////////////////////

According to my understanding, I believe that all my codes and written questions are 
implemented correctly and they compile, run and give the expected output. 

-    All my written solutions are found in the pdf which is named written.pdf
     I wrote actual java code for the printLots method, but I just wrote pseudocode 
     that looks slightly like java code (structure wise) for the rest of the problems 
     (as we were asked to do in the homework) 

-    For the balancing symbol programming question, I had to use 2 boolean expressions 
     in order to handle the cases where I need to exclude all the braces in between 
     the quotation marks for the strings, and for the comments. 
     Other than that, I used the push and pop methods that I implemented in MyStack.java 
     so that I can detect the errors and mistakes and throw the exceptions according 
     to the errors that occured in the testing file. 
     For my own Test.java, I just left out the closing curly brace for my class. 
     After testing my SymbolBalance.java for my own test case, and the test 
     cases that we were provided, I believe that my code has passed all tests 
     and it returned the expected output (threw the right exceptions). 

-    For my second programmming question, I tried to make it as efficient and cheap as possible.
     I coded it in a way where you only copy the elements from S1 to S2 only if S2 is empty. 
     The reason I did that was mainly to reduce my Big Oh cost instead of copying every  
     element back and forth between both stacks when I don't really need to or have to do so.

--------------------------------------------------------------------------------------------

This zip file contains:

1)     a pdf called written.pdf with all the solutions to the written questions 
2)     SymbolBalance.java
3)     MyStack.java 
4)     Test.java
5)     TwoStackQueue.java
6)     MyQueue.java
7)     Program2.java
8)     Program2.txt
9)     README.txt

This is how you compile my code:

   // you don't need to compile Test.java (since it's missing a curly brace so it won't compile)
   // you don't need to compile the Program2.txt or the README.txt since they are text files
   // you can't compile the pdf, you just need to open it to check the written solutions. 

   ***Here is how you can compile the rest of the things that I've submitted: 

1)   javac SymbolBalance.java
2)   javac MyStack.java
3)   javac MyQueue.java
4)   javac TwoStackQueue.java
5)   javac Program2.java


---------------------------------------------------------------------------------------------

This is how you run my code:


1)   java SymbolBalance 
2)   java MyStack
3)   java MyQueue
4)   java TwoStackQueue
5)   java Program2



