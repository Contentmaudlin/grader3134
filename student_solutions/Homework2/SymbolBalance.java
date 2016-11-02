import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class SymbolBalance {

	static Charset ENCODING = StandardCharsets.UTF_8;

	public static void putSymbolsInStack(List<String> text) {
		boolean comment = false;//checks if you're going through a comment
		boolean litString = false;//checks if you're in a literal string
		ArrayList<String> brackList = new ArrayList<String>();

		ArrayList<String> brackets = new ArrayList<String>(Arrays.asList("(",")","[","]","{","}","\""));
		try {
			for (int i = 0; i < text.size(); i++) {
				for (int j = 0; j < (text.get(i)).length(); j++) {
					 if (text.get(i).substring(j, j + 1).equals("/") && text.get(i).length() >j + 1 && !litString && j < text.get(i).length() - 1) {//fix
					 	if (text.get(i).substring(j + 1, j + 2).equals("*")) {
					 		comment = true;
					 		//System.out.println("start comment");
					 	}
					 }
					 if (text.get(i).substring(j, j + 1).equals("*") && !litString && j < text.get(i).length() - 1 && !litString) {
					 	if (text.get(i).substring(j + 1, j + 2).equals("/")) {
					 		comment = false;
					 		//System.out.println("end comment");
					 	}
					 }
					 if (text.get(i).substring(j, j + 1).equals("\"") && !comment) {
					 	litString = !litString;
					 	//System.out.println("quote switched to " + litString);
						brackList.add("\"");
						continue;
					 }
					if (brackets.contains(text.get(i).substring(j, j + 1)) && !comment && !litString) {//adds special character to brackList
						brackList.add(text.get(i).substring(j, j + 1));
					}
				}
				if (litString) {//exception is thrown if the end of a line is reached without an ending quotation mark
					throw new IllegalStateException();
				}
			}
		} catch (IllegalStateException e) {
			System.out.println("comment not ended: missing quotation mark");
		}
		checkBrackets(brackList);
	}


	public static void checkBrackets(ArrayList<String> brackets) {
		MyStack<String> stack = new MyStack<String>();
		//System.out.println(brackets);
		int idx = -1;//used to check extra closing brackets (see README.txt)
		try {
			for (String s : brackets) {
				idx++;
				if (s.equals("(") || s.equals("{") || s.equals("[")) {
					stack.push(s);
				}
				if (s.equals(")")) {
					if (!stack.pop().equals("(")) {
						System.out.println("mismatched paranthesis )");
					}
				}
				if (s.equals("]")) {
					if (!stack.pop().equals("[")) {
						System.out.println("mismatched bracket ]");
					}
				}
				if (s.equals("}")) {
					if (!stack.pop().equals("{")) {
						System.out.println("mismatched curly brace }");
					}
				}
			}
		} catch (IllegalStateException e){
			System.out.println("mismatched: " + brackets.get(idx));
		}
		if (!stack.isEmpty()) {
			System.out.println("mismatched: " + stack.pop());
		}
	}

	public static List<String> readSmallTextFile(String aFileName) throws IOException {//thrown if file not found
		Path path = Paths.get(aFileName);
		return Files.readAllLines(path, ENCODING);
	}

	public static void main(String[] args) {
		try {
			List<String> text = readSmallTextFile(args[0]);
			putSymbolsInStack(text);
		} catch(IOException e) {
			System.out.print("File not found");
		}
	}
}
