//Written by Jinoh Lee (jl4622), Homework 2, Programming Problem 1
//This program checks if { }, [ ], ( ), " ", and /* */ are balanced
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SymbolBalance {

	public static void main(String[] args) throws FileNotFoundException {

		//reads File
		MyStack<Character> symbolStack = new MyStack<Character>();
		Scanner sr = new Scanner(new FileReader("Test.java"));

		//Puts every character in a stack
		while (sr.hasNext()) {
			String string = sr.nextLine();
			for (int i = 0; i < string.length(); i++) {
				symbolStack.push(string.charAt(i));
			}
		}
		sr.close();
		symbolCheck(symbolStack);
	}

	public static void symbolCheck(MyStack<Character> a) {

		MyStack<Character> tempStack = new MyStack<Character>();
		tempStack = a;
		char temp;
		int bracketCount = 0;
		int sbCount = 0;
		int pCount = 0;
		int qCount = 0;
		boolean wrongBracket = false;
		boolean wrongSquareBracket = false;
		boolean wrongParanthesis = false;
		boolean longComment = false;
		boolean quotes = false;
		boolean bracket = false;
		boolean squareBracket = false;
		boolean paranthesis = false;

		while (tempStack.size() > 1) {
			temp = tempStack.pop(); //gets last char
			if (longComment) { //ignores if part of long comment
				if (temp == '*') {
					if (tempStack.get(tempStack.size() - 1) == '/') {
						longComment = false;
					}
				}
			} else if (temp == '/') { // Checks for long comments
				if (tempStack.get(tempStack.size() - 1) == '*') {
					longComment = true;
				}
			} else if (!(bracket || squareBracket || paranthesis || quotes)) {
				if (temp == '"') {
					quotes = true;
					qCount++;
				} else if (temp == ']') {
					squareBracket = true;
					sbCount++;
				} else if (temp == '}') {
					bracket = true;
					bracketCount++;
				} else if (temp == ')') {
					paranthesis = true;
					pCount++;
				} else if (temp == '{') {
					wrongBracket = true; // Code ends with a { without }
				} else if (temp == '(') { // Code ends with a [ without ]
					wrongParanthesis = true;
				} else if (temp == '[') { // Code ends with a ( without )
					wrongSquareBracket = true;
				}
			} else if (quotes) {
				if (temp == '"') {
					qCount++;
					if (qCount % 2 == 0) {
						quotes = false;
					}
				}
			} else if (bracket) {
				if (temp == '}') {
					bracketCount++; // More closed brackets to be counted!
				} else if (temp == '{') {
					bracketCount--; // Closed a set of brackets
					if (bracketCount == 0) { // Can we move on? 
						bracket = false; 
					}
				} else if (temp == ']') { // Have to check for other symbols
					sbCount++;
				} else if (temp == '[') {
					sbCount--;
					if (sbCount < 0) { // Is there a symbol mismatch?
						wrongSquareBracket = true;
					}
				} else if (temp == ')') {
					pCount++;
				} else if (temp == '(') {
					pCount--;
					if (pCount < 0) {
						wrongParanthesis = true;
					}
				} else if (temp == '"') {
					quotes = true;
					qCount++;
				}
			} else if (squareBracket) {
				if (temp == ']') {
					sbCount++;
				} else if (temp == '[') {
					sbCount--;
					if (sbCount == 0)
						;
					{
						squareBracket = false;
					}
				} else if (temp == '}') {
					bracketCount++;
				} else if (temp == '{') {
					bracketCount--;
					if (bracketCount < 0) {
						wrongBracket = true;
					}
				} else if (temp == ')') {
					pCount++;
				} else if (temp == '(') {
					pCount--;
					if (pCount < 0) {
						wrongParanthesis = true;
					}
				} else if (temp == '"') {
					quotes = true;
					qCount++;
				}
			} else if (paranthesis) {
				if (temp == ')') {
					pCount++;
				} else if (temp == '(') {
					pCount--;
					if (pCount == 0) {
						paranthesis = false;
					}
				} else if (temp == '}') {
					bracketCount++;
				} else if (temp == '{') {
					bracketCount--;
					if (bracketCount < 0) {
						wrongBracket = true;
					}
				} else if (temp == ']') {
					sbCount++;
				} else if (temp == '[') {
					sbCount--;
					if (sbCount < 0) {
						wrongSquareBracket = true;
					}
				} else if (temp == '"') {
					quotes = true;
					qCount++;
				}
			}
		}

		// prints results
		if (longComment) {
			System.out.println("Unbalanced! Long Comments are mismatched");
			System.out.println("Missing opening '/*'");
		} else if (quotes) {
			System.out.println("Unbalanced! Quotes are mismatched");
		} else if (bracket || bracketCount != 0 || wrongBracket) {
			System.out.println("Unbalanced! Brackets { } are mismatched");
			if (bracketCount < 0) {
				System.out.println("{ Unbalance");
			} else if (bracketCount > 0) {
				System.out.println("} Unbalance");
			} else if (wrongBracket) {
				System.out.println("{ mismatch");
			}
		} else if (squareBracket || sbCount != 0 || wrongSquareBracket) {
			System.out.println("Unbalanced! Square Brackets [ ] are mismatched");
			if (sbCount < 0) {
				System.out.println("[ Unbalance");
			} else if (sbCount > 0) {
				System.out.println("] Unbalance");
			} else if (wrongSquareBracket) {
				System.out.println("[ mismatch");
			}
		} else if (paranthesis || pCount != 0 || wrongParanthesis) {
			System.out.println("Unbalanced! Parenthesis ( ) are mismatched");
			if (pCount < 0) {
				System.out.println("( Unbalance");
			} else if (pCount > 0) {
				System.out.println(") Unbalance");
			} else if (wrongParanthesis) {
				System.out.println("( mismatch");
			}
		}
	}
}

