Yingshuang Zheng
yz3083

The file include: 

1.written homework in pdf form. I also make a separate java file for the first written homework in case you need to check whether the code compile or not. I name it as written1.java.

2.SymbolBalance.java, MyStack.java and Test.java are for programming 1. In this program, I read the java file first. And then check line by line, character by character in a loop fashion to see if we encounter the symbol we want. Since the read() method is in boolean type, i use readline() instead and store every line into a string. I create a variable c working as a pointer to store and go through element. whenever I encounter ( { or[, i push them to one stack, whenever I encounter )]or}, i pop the last element to see if that match or not. If i can not pop anything from the stack, then there is a mismatch of corresponding symbol. Whenever i encounter a “, I check every element in the line to find another “ in a loop fashion. If I cannot find another “, then there is a mismatch. Whenever I encounter a /*, i push them into the stack, and check until I find the corresponding */ to pop them out.At last, I also double check whether is there anything left in the stack, Anything that left in stack is an unbalanced symbol.

I push a ‘0’ into my stack as the first element to prevent the null mistake that it has nothing to pop. Also, it can works as an reference to see whether my stack is empty or not.(Although i have is empty function it is easier to check in this way)

The code will print “match” for every symbol it checked that has its corresponding matches.And it only can take one file to check at each time. Please remember to type .java extension when typing the command line.

The Test1-6.java is the test file that that Professor gave us. It is to test whether the SymbolBalance worked or not. Please put them in the same directory. Otherwise it won’t work. >.< 

3.MyQueue.java, Program2.java, Program2.txt,TwoStackQueue.java, and MyStack.java are for programming program 2. The idea for this problem is to push everything into stack1 as enqueue. The dequeue process requires to push everything from stack1 to stack2 if stack2 is empty.Otherwise, simply push element from stack2.

Please remember to put everything into one folder for them to function properly. ;D