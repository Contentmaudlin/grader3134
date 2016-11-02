Name : Nicholas Puljic
Uni : nap2152

Instructions on how to compile and run .java files : 

To compile and run .java files on a mac, make sure all files needed for the .java file you are compelling are in the same folder. Open up terminal, and move to that folder using the “cd” terminal command. Use the terminal command “javac ‘file.java’” to compile the java file, it will create class files in the same folder. To the run the java file use the command “java ‘file’ *command line arguments”. This will run the file and print out in the terminal any errors or outputs of the file.


Files included, what they do, and how to compile and run them (if applicable) :

written.pdf : Answers the four written homework questions

SymbolBalance.java : Checks to see if all (), [], {}, /**/, and “” symbols in a given java file are balanced. Takes a command line argument that is the name of a java file in the same folder as it and runs the program on it. To compile this file, use the instructions provided above, and make sure the “MyStack.java” file and any test files (the provided one is “Test.java”) are in the same folder as it. To run it make sure to add the test file as a command line argument in the “java ‘file’ *command line arguments” terminal command.

MyStack.java : The generic stack class I wrote which is used in SymbolBalance.java, TwoStackQueue.java, and Program2.java. This file does not need to be compiled to test my work.

Test.java : The test file that I made to test SymbolBalance.java, it checks to see if the SymbolBalance.java file sees that there is a “ on two lines, which there shouldn’t be. This file does not need to be compiled to test my work.

TwoStackQueue.java : The generic queue ADT as implemented from MyQueue.java that uses two stacks that I wrote. It creates the methods implemented from MyQueue.java and creates a queue using two stacks from MyStack.java. This file does not need to be compiled to test my work.

MyQueue.java : The java file provided that is implemented in TwoStackQueue.java. This file does not need to be compiled to test my work.

Program2.java : The file that tests the TwoStackQueue.java file, it gives the expected outcome at the top and then uses all of the TwoStackQueue methods to test them. In order to compile and run this, make sure the MyQueue.java, MyStack.java, and TwoStackQueue.java are all in the same folder as this file. Then follow the instructions provided above to move to the file, compile it, and run it.

Program2.txt : A discussion of the Big-O running time of the enqueue and dequeue methods I wrote in TwoStackQueue.java. This file does not need to be compiled to test my work.

README.txt : The txt file you are reading now! Yay! States my name, uni, how to compile and run java files using the mac terminal, and gives an explanation of all of the files that I am submitting. Even this file.

Anything you should be aware of :
In the SymbolBalance.java in line 16 : “inFile = new File(args[0]);”, if these are all in the src of an Eclipse java project this line needs to be “inFile = new File("src/" + args[0]);”, or you will get a file not found error. It is very annoying that this happens. It took me many hours to find a solution to this. Send help.