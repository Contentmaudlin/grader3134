*******************
Arjun Mangla
Data Structures in Java
Paul Blaer
Fall 2016
Homework-2
*******************

The programs in this homework work as expected.




MyStack.java

This class is the blueprint of the MyStack class object 
(Stack implementation of generic LinkedList)

1. Three instance variables - ints size (of the stack), topOfStack, and theList(LinkedList) whose value is taken in as an argument
in the constructor.

2. push method - Method to push element onto the stack. adds element to the top of the stack and increments size by 1.

3. pop method - Method to pop element off the stack. removes element from the top of the stack, returns its value and decrements size by 1.

4. top method - returns the value of the element on top the stack.




SymbolBalance.java

This class is the blueprint of the SymbolBalance class.

1. 1 Instance Variable - symbolStack - instance of the MyStack class.

2. checkBalance method - Takes a textFile as input, checks if {},[],(),””, /* */ are balanced and returns a String with the unbalanced symbol.

	Calls the readFile method on the input file name. This method takes in a String - name of file - and returns a string with all the text in the file.

	Initializes a char open with a random character value. variable is used later to check bracket balance.

	2 booleans string, comment to check when comment/string is going on and when not (to balance ””, /* */ and ignore symbols in between them. These are initialized with false.

	Now there’s a for loop that iterates through the characters of the string to check for symbols.

	Using charAt(), I initialize the current char to c and the next character to d just to make future references cleaner.

	Comments and strings are checked separately first.

	If c and d refer to comment block starters and comment and string are false (i.e. comment or string isn’t going on), comment is changed to true (comment starts) and loop continues to next iteration.

	If c and d refer to comment block enders and comment is true but string is false, comment is changed to false (comment ends) and loop continues to next iteration.

	If c refers to quotation marks and comment and string are false (i.e. comment or string isn’t going on), string is changed to true (string starts) and loop continues to next iteration.

	If c refers to quotation marks and string is true but comment is false, string is changed to false (string ends) and loop continues to next iteration.

	The next if statement block is entered if both comment and string are false. This block checks for bracket imbalances.

	If c points to an open-bracket character, the character is pushed to symbolStack and the loop goes to the next iteration.

	Otherwise, if c points to a close-bracket character, the if block is entered.
	Here, if the stack is not empty, the stack is popped and the returned value is stored in the variable open. Otherwise, open is assigned a random character that would never be pushed to the stack because we can’t assign null to a char value.

	if c is a closed bracket character and open is not the corresponding open bracket character, the value of c is returned as unbalanced.

	if open is an open bracket character and close is not the corresponding closed bracket character, the value of c is returned as unbalanced.

	The if block and for loop end.

	Now, if boolean string or comment is still true, a string is returned indicating the respective symbol is unbalanced.

	If the stack is not empty, it is popped and the popped character (generally an open bracket character here) is returned as unbalanced.

	If the booleans are false and the stack is empty, the file is declared balanced.


3. readFile method - reads file with help of scanner and returns string with entire text.


4. main method - calls the constructor and checkBalance on the created object for which the argument is taken directly from the command line, and prints the result.

Using Command-Line Arguments:

1. Create a source folder with your java program file and the file you want to use as input in your code (e.g. SymbolBalance.java, Test.java respectively)

2. Enter the folder that contains the files (e.g. cd am4409_hwk2)

3. Now, compile your Java code (e.g. javac SymbolBalance.java)

4. Now, run the code the way that you would but just add your desired command line argument after your program name in the way shown below:

java SymbolBalance Test1.java

This should do the trick!



TwoStackQueue.java

This class implements a generic queue with the help of two generic stacks and the provided MyQueue interface.

1. 2 instance variables - 2 instances of the MyStack class.

2. The constructor produces a TwoStackQueue with 2 stacks initialized with new LinkedLists.

3. enqueue method - pushes the value for the variable in the argument to S1 (adds element to the back of the queue.

4. dequeue method - dequeue method returns the element at the front of the queue.
(pops elements from S1 and simultaneously pushes them to top of S2, then pops S2)

5. isEmpty method - checks if size (size of S1 + size of S2) is 0 or not.

6. size method - returns the size of the queue (size of S1 + size of S2).




Written Problems:

1. Class includes LinkedLists L and P as instance variables. 
printLots method takes in the values for these as arguments when the method is called.
The int count is used to keep track of the index for L and i for elements in P.
An iterator acquired through the iterator method in collections is used to iterate through P. Wherever i and count have the same value, the item is printed out and the iterator is incremented.

Here, I have only used the Iterator class to make the code cleaner by creating a name and reference for the iterator P.iterator().

2. Method takes in both lists as arguments.
A new List Intersection is created to store and return result in.
1 iterator each is instantiated for both the lists using the iterator method in collections. 
Two variables item1 and item2 have been assigned initial values.
Now, there’s a while loop. While both lists have more elements, the loop will continue.
Inside,
(a) If item1 < item2, item1 will be changed to the next value on L1
(b) If item1 > item2, item2 will be changed to the next value on L2
(c) If items are equal, their value is added to Intersection List and both lists are incremented.
Once the loop’s over, the value of the Intersection list is returned.

3. This is a class with implementation of two stacks on one array from opposite sides.
The implementation for Stack1 is similar to MyStack. The implementation for Stack2 is opposite of MyStack because it’s filling up from the opposite end.