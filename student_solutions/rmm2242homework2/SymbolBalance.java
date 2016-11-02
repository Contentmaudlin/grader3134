import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class SymbolBalance {

	public static void main(String[] args) {

		MyStack thestack = new MyStack<Character>();

		// use BufferedReader to get lines from the text file
		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) { // got this line from https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/

			String line;
			char testchar;
			char fromstack;
			boolean done = false;
			boolean inquotes = false;

			while (((line = br.readLine()) != null) && (done == false)) { // sets line equal to the next line from file

				int i = 0;
				int size = line.length()-1;
				while ((i <= size) && (done == false)) { // use while loop to iterate through characters in the line

					testchar = line.charAt(i);

					if ((testchar == '/') && (i < size)) { // might signal beginning of /* comments
						if ((testchar = line.charAt(++i)) == '*') { // take next char; if '*', definitely /* comments
							inquotes = true;// enter quotes
						}
					}

					if (inquotes) { // follow this if you're in block comments comments
						if ((testchar == '*')&& (i < size)) { // keep looking for asterisks
							if ((testchar = line.charAt(++i)) == '/') { // followed by slashes
								inquotes = false;// exit quotes
							}
						}
						else {
							++i;
						}

					} else { // follow this if you're not in block comments
						++i;

						if (testchar == '"') { // if you hit a quotation mark
							while (i <= size-1) {
								++i;
								if (line.charAt(i) == '"') { // keep checking new characters until you hit another quotation mark
									break;
								}
								if (i == size) { // if you end the line and never hit second quote mark
									System.out.println("Incomplete string literal");
									done = true; // you found an error case so you can exit the whole program
								}
							}
						}
						
						switch(testchar) { // no quotes, no block comments: check other symbols
							case '(':
							case '[':
							case '{':
								thestack.push(testchar); // push any of these onto the stack
								continue; // and don't bother executing any of the rest of the code
						}
						if (testchar == ')') {
							if (thestack.size() == 0) { // if you get a closing symbol and nothing's on the stack
								System.out.println("Error! ')' is mismatched");
								done = true;
								continue; // continue without trying to pop the stack
							}
							fromstack = (char) thestack.pop(); // otherwise pop the stack
							// System.out.println(testchar + "popped");
							if (fromstack != '(') { // if whatever you pop isn't the correct opening
								System.out.println("Error! Symbol ')' is mismatched");
								done = true;
							} 
						}
						if (testchar == ']') {
							if (thestack.size() == 0) {
							System.out.println("Error! Symbol ']' is mismatched");
							done = true;
							continue;
							}
							fromstack = (char) thestack.pop();
							// System.out.println(testchar + "popped");
							if (fromstack != '[') {
								System.out.println("Error! Symbol ']' is mismatched");
								done = true;
							} 
						}
						if (testchar == '}') {
							if (thestack.size() == 0) {
							System.out.println("Error! Symbol '}' is mismatched");
							done = true;
							continue;
							}
							fromstack = (char) thestack.pop();
							// System.out.println(testchar + "popped");
							if (fromstack != '{') {
								System.out.println("Error! Symbol '}' is mismatched");
								done = true;
							} 
						}
							
					}
				}
			}
			if (done == false) { 
				if (thestack.size() != 0) { // if you reach the end of the file and still have symbols on the stack
					testchar = (char) thestack.pop(); // pop the last one, it must be unbalanced
					System.out.println("Error! " + testchar + " is mismatched");
				}
				else { // no errors were detected
					System.out.println("All balanced!");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}