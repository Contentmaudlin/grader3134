{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf470
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 Harrisen Egly\
hte2102\
Homework 2 README\
\
Problem 1 Compiling and Running Instructions\
SymbolBalance.java requires MyStack.java in order to run as well as the importation of the Scanner class. MyStack.java works completely on its own using java.util.LinkedList. After this the program just asks for the file to be tested to be inputted into the command line. This requires the entire directory of the file otherwise it will return a FileNotFoundException. Test.java is provided in the compressed file and should return a result of \'93 and \} being mismatched. The program is done exactly as asked on the assignment. A while loop is used to run through the entire file character by character and passing it through various if loops to find the symbols to be pushed onto stacks as I felt this was the easiest way to make sure nothing was missed.\
\
Problem 2 Compiling and Running Instructions\
MyQueue.java is the provided MyQueue file from the homework. This was used so I could explicitly implement it in TwoStackQueue.java. TwoStackQueue.java uses MyStack.java to create a Two Stack Queue. Program2.txt discusses how elements are moved between the two queues in more depth but it is simply about popping items from S1 to S2 to reverse their order and allow for the Queue to be dequeued in the proper order. Program2.java is the test file for my Two Stack Queue. It should output an accurate ranking of American sports teams (if Michigan is at the top something went horribly wrong). All the files compile and run as specified in the assignment as long as MyQueue is included so it can be implemented in TwoStackQueue.java.\
\
Both codes include comments that show the inner workings of the code\'92s runnings and show the expected results of the two test files.}