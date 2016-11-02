//Fernando A. Pascual
//fap2122
//Data Structures HW2

For SymbolBalance, I read the file in as a File object then instantiated a scanner object
to read line by line. I checked first for the opening signs, then I checked to see if 
they had a corresponding close right after. I checked by peeking the stack and if it 
matched what I was closing, I would pop it off. If not, I would use a boolean statement 
to alert the program there was a mismatch and break out of my while loop.

For the 2 stack queue, most of the explanation is in Program2.txt. To dequeue I just popped from 
enqueue stack and pushed those values to the dequeue stack and popped off from the dequeue stack.
