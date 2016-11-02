Paul Bloom
pab2163
README for HWK2

All of my programs can be compiled using javac “ProgramName”.java from the command line in terminal. That was how I debugged them. 

SymbolBalance.java takes command line input, and needs to have MyStack.java compiled first to run. Run SymbolBalance from command line with:

java SymbolBalance “ProgramName”.java

Program2 does not take command line input, and needs to have MyStack.java as well as TwoStackQueue.java compiled to be run. Also, the MyQueue interface needs to be in the same directory and compiled. Run Program2 from command line just by calling

java Program2


As far as I am aware, both of my programming projects function as intended. I did consult Stack Overflow (and cited it in a comment) for help using BufferedReader to read a file character by character because I could not remember how to do that. For MyStack.java, I constructed it using a doubly-linked list because that seemed easiest using the existing LinkedList class for the list. The SymbolBalancing program I made makes heavy use of the MyStack class, although I used conditionals rather than the stack to check for comments, since using a stack to do so would either involve creating a new stack for strings (since the existing one only takes chars) or adding some extra variables to account for chars in the existing stack. I’m not sure if this was what I was supposed to do, but it seems to work on all the examples I tried. Quotes and each type of bracket do use the stack. 

My TwoStackQueue class implements the MyQueue interface provided.

I do have some constructors that don’t really do anything for the implementation of a Stack/Queue. I’m not sure if this is a bad thing, but the constructors don’t seem to need to do anything for those classes. 