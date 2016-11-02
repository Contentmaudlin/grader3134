Dominique Gordon
dlg2156
HW 2 Data Structures

Written 1

My program works exactly as described. I decided to leave in my import lines as well as the main method instead of just providing the printLots method because those are what I used to test it with in Eclipse. I chose to iterate through L for every elem of P until we reached the desired value because you couldn’t simply call L[P[i]] with the methods allowed. I think I possibly could have done this problem more efficiently because it was nested iterations.

Written 2

My program works exactly as described. My pseudocode is VERY java like. I chose to perform this using just one while loop rather than using nested ones in order to reduce time complexity. Essentially, you begin at the beginning of both lists, and if it’s a match, you add it to the intersection list, if it’s not, you move the list with the lower element forward, in the hopes that the next element might be a match. This works because the lists are sorted.

Written 3

My program works exactly as described (I think). I struggled a little more with this problem, and it was difficult to test since I’d written it in pseudocode. 

Written 4

My program works exactly as described. For part b, essentially any combination where a high number (like 9) is forced to block a number lower than it because they are already occurred earlier in the input and couldn’t yet be sent to the output and thus are filling all 3 of the holding slots.

Programming 1

My program works exactly as described. The fundamental design concept of my program is having two booleans (comment and quote) that tell you whether you are in a comment or not. If you are within a comment, you do not check for matching signs. I used MyStack to push and pop open and close symbols. My test.java is very simple, just with an unbalanced “ in a print statement.

Programming 2

My program works exactly as described. I added a size method to MyStack so that I could use it within TwoStackQueue.java. Basically, in a queue you want to access the start and the end of the line, while in a stack you only access the end. So, I used a second stack to essentially flip the first stack over so you could access the end of the second stack (the start of the first stack). My Program2.java tester file is very simple, I chose to print letters in order because I thought they more clearly demonstrated the first in first out nature of queues.
