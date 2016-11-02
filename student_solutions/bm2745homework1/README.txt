Benjamin Mazel
bm2745

Files Contained:
Rectangle.java
Problem1.java
Problem2.java
Problem3.java
Problem3.txt
written.pdf
README.txt

For Problem1:
	The main method (tester) in this class creates a hardcoded array of rectangles (which will print for the user's convenience) as well as finds the maximum rectangle in that array and prints its dimensions as well. This can also be run from the main method of a separate tester class, using Problem1.findMax(yourRectArr).
	To run this code:
javac Rectangle.java
javac Problem1.java
java Problem1

For Problem2:
	The main method (tester) in this class creates a hardcoded array of rectangles (which will print for the user's convenience) as well as a rectangle which is NOT in that array. It also allows the user to pass one new rectangle to search for as a command line argument where the first int passed is its length and the second, its width. It then sorts the array and prints every member of the array as well as its position in the array (found using binarySearch) for convenience. It also prints the two outside rectangles as well as whether or not they're found in the array. This can also be run from the main method of a separate tester class, using Problem2.binarySearch(yourRectArr, yourRect).
	In addition, this class uses a helper method binSearchHelper which is the recursive method called by binarySearch.
	To run this code:
javac Rectangle.java
javac Problem2.java
java Problem2 A B
***Here, A and B are two ints representing the length and width of a rectangle the user wishes to search for. They are optional to put!***

For Problem3:
	The main method (tester) in this class runs all three code fragments for n as powers of 10 from 1 to 100000. It prints the time in ns each fragment took to run. For convenience, the first code fragment is denoted as a, the second as b, and the third as foo. 
	To make the runtimes of foo more evident, each step of foo is delayed by 1 ms = 10^6 ns.
	To run this code:
javac Problem3.java
java -Xint Problem3
