import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolBalance {
	public static void main(String[] args) {
		try {
			if (args.length >= 1) {
				String fileName = args[0];
				File input = new File(fileName);
				String output = null;
				output = checkSymbols(input);
				System.out.println(output);
			} else {
				System.out.println("Please enter a file name");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Yikes!! that file cannot be found!");
		}
	}

	private static String checkSymbols(File testFile)
			throws FileNotFoundException {
		Scanner scan = new Scanner(testFile);
		scan.useDelimiter("");
		String error = "symbols balanced";
		MyStack<String> theStack = new MyStack<String>();
		while (scan.hasNext()) {
			String current = null; 
			current = scan.next();
			//push opening symbols onto stack 
			if (current.equals("{") || current.equals("(")
					|| current.equals("[")) {
				theStack.push(current);
			}
			// pop opening symbols when closing symbols encountered
			if (current.equals("}") || current.equals(")")
					|| current.equals("]")) {
				if (theStack.isEmpty()) {
					error = "symbols imbalanced-closing symbol without opening symbols-"
							+ current;
					return error;
				}
				String popped = null;
				popped = theStack.pop();
				if (current.equals("}") && !(popped.equals("{"))) {;
					error = "symbols imbalanced-symbol mismatch-" + popped + current;
					return error;
				}
				if (current.equals(")") && !(popped.equals("("))) {
					error = "symbols imbalanced-symbol mismatch-" + popped + current;
					return error;
				}
				if (current.equals("]") && !(popped.equals("["))) {
					error = "symbols imbalanced-symbol mismatch-" + popped + current;
					return error;
				}
			}
			// balancing /* */ and ignoring comment content
			Boolean isComment = false;
			if (current.equals("/") && scan.hasNext()) {
				String a = null;
				String b = null;
				String c = null;
				a = scan.next();
				if (a.equals("*")) {
					isComment = true;
					while (isComment && scan.hasNext()) {
						b = scan.next();
						if (b.equals("*") && scan.hasNext()) {
							c = scan.next();
							if (c.equals("/")) {
								isComment = false;
							}
						}
						// this is problematic
						if (b.equals("/")) {
							c = scan.next();
							if (c.equals("*")) {
								error = "missing closing symbol-*/";
							}
							return error;
						}
					}
				}
			}
			if (isComment && !(scan.hasNext())) {
				error = "missing closing symbol-*/";
			}
			//balancing strings and ignoring string content 
			Boolean isString = false;
			if (current.equals("\"")) {
				isString = true;
				String next = null;
				while (isString && scan.hasNext()) {
					next = scan.next();
					if (next.equals("\"")) {
						isString = false;
					}
				}
				if (isString && !scan.hasNext()) {
					error = "missing closing symbol-\"";
					return error;
				}
			}
		}
		if (!theStack.isEmpty()) {
			error = "symbols imbalanced-file ends with missing closing symbol";
			return error;
		}
		scan.close();
		return error;
	}
}