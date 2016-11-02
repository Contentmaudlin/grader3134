Name: Or Aboodi
uni: oda2102
Homework 2, Data structures

Files I am submitting:
-a pdf with the written parts solution
-this readme
-MyStack.java (for problem 1 and 2)
-SymbolBalance.java (for problem1)
-Test.java(for problem 1)
-TwoStackQueue.java (problem 2)
-MyQueue.java (problem 2)
-Problem2.java (problem 2)
-Problem2.txt (written part of problem 2)
-----

Problem1:

in order to compile this code, you need to run the following:
javac MyStack.java
javac SymbolBalance.java

You will need all the files to be in the same directory. Then, run the following:
java SymbolBalance Test.java

if you have any more text files you want to check with SymbolBalance, you need to include it in the same directory and run it the same way as Test.java.

**Note: after asking the instructors, they said it will be ok if my code for the quotes accounts for quote symbols across the entire file, not necesarily line by line. This means that if on one line there is only one quote symbol, and on the next line there is another quote symbol, they will count as balanced, even though in java this is not necesarily so. Note that this may change the results of other symbol mismatches since if a quote is started on one line and never closed, the stacks will not intake any character after that, and my code will print out all mismatches it found.

**Note: the output in my program simply states which mismatch/imbalance the text has, and prints out all mismatches and outputs. For example, if the code is (], then my program will let you know that you have both a parentheses and a square bracket imbalance. I understand this is ok since were told we can format the output as we wish, and it makes sense that the person will know all their mistakes.

**Note: in the SymbolBalance.java, I implemented the whole code in the main static method. I know that it would have been cleaner if I used helper methods and just called them from the main method, but I was told that this was sufficient for full marks since it works and is clear. If I had more time, I would clean the code and make helper methods for checking the stacks. 



Problem 2:

in order to compile this code, make sure the files (including MyQueue.java) are all in the same directory and run the following:
javac MyStack.java
javac TwoStackQueue.java
javac Problem2.java

To run this code, just run:
java Problem2
if you have your own tester file, make sure it is in the same directory and compile and run it just like Problem2.java. 


happy grading :) Sorry for all the side notes!
