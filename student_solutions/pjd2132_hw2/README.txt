Peter Drake
pjd2132
README.txt

Files being submitted in pjd2132_hw2.zip:

written.pdf
SymbolBalance.java
MyStack.java
Test.java
TwoStackQueue.java
MyQueue.java
Program2.java
Program2.txt
README.txt

written.pdf solves the Written Problems, problems 1-4.

SymbolBalance.java, MyStack.java, and Test.java solve Programming Problem 1.

TwoStackQueue.java, MyQueue.java, Program2.java, and Program2.txt solve Programming Problem 2.

(There is more than one way to compile and run these programs, but here I outline how using a Unix shell.)
To compile and run these programs, the files must be downloaded to a system that can run a Unix shell. When at the Unix Command Line, type “javac ExampleProgram.java” when in the proper directory (where the files are located) to compile the program. So for example, “javac SymbolBalance.java” would compile the SymbolBalance program. Then, to run the program, type in “java ExampleProgram” to run the program. Enter any command-line arguments following the Program name separated by space(s). So, using SymbolBalance as an example; after compiling the necessary files, type:
“java SymbolBalance Test.java” 
to run the SymbolBalance with Test.java as a command-line argument.

Additional notes:
When testing SymbolBalance.java in Eclipse, I used slightly altered command-line arguments so it could run. Namely, before the file name, I added “src/“ so that Eclipse would be able to find the file. Without it, the program would not execute properly.