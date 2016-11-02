import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by ShuqiChen on 16/10/1.
 */
public class SymbolBalance {

    private static MyStack<Character> stack = new MyStack<>();

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            String theLine;
            boolean balance = true;


            while ((theLine = br.readLine()) != null) {

                for (int i = 0; i < theLine.length(); i++) {


                    //if /*
                    if (theLine.charAt(i) == '/' && i < theLine.length() - 1) {
                        if (theLine.charAt(i + 1) == '*') {
                            checkcom("/*");
                            i++; //so that we will not go through the next * since this * is associated with the opening /*
                        }
                    }
                    //if */
                    else if (theLine.charAt(i) == '*' && i < theLine.length() - 1 ) {
                        if (theLine.charAt(i + 1) == '/') {
                            if (!checkcom("*/")) {
                                System.out.println("*/ is mismatched");
                                balance = false;
                                break; //leave the for loop
                            }
                        }
                    } else {


                        if (!check(theLine.charAt(i))) {
                            //System.out.println(" ");
                            //System.out.println("===");
                            System.out.println(theLine.charAt(i) + "is mismatched");
                            balance = false;
                            break;
                        }
                        checkquo(theLine.charAt(i));
                    }


                }
                if (!balance) {
                    break; //leave the while loop
                }
                //to check even numbers of quotation marks in one line
                //since java does not allow a pair of quotation mark in different lines
                else if (!stack.isEmpty()) {
                    if (stack.peek() == '"') {
                        System.out.println("quotation mark is mismatched");
                        balance = false;
                        break;
                    }
                }


            }


            br.close();

            if (stack.isEmpty() && balance) {
                System.out.println("balanced!");
            }

            //no mismatched closing symbol
            //within the stack are opening symbols that are not paired with corresponding closing symbols
            else if (balance){
                char element = stack.peek();
                while (!stack.isEmpty()) {
                    element = stack.pop();
                }

                if (element == '*') {
                    System.out.println("/* is mismatched");
                }
                else {
                    System.out.println(element + " is mismatched");
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("NO file found");
        } catch (IOException ex) {
            System.out.println("file not valid");
        } catch(IndexOutOfBoundsException exx) {
            System.out.println("Please type a file name in command line");
        }
    }


    //check ([{
    public static boolean check(char a) {
        //to avoid the IndexOutOfBounds Exception, here I first deal with the isEmpty case
        //otherwise, directly checking stack.peek() without checking isEmpty may cause the exception
        if (stack.isEmpty()) {
            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
                return true;
            }
            else if (a == ')' || a == ']' || a == '}') {
                return false;
            }
        }

        else {
            //if within /*... or "" then ignore
            if (stack.peek() == '*' || stack.peek() == '"') {
                return true;
            }

            //whenever read an opening symbol, push it into the stack
            else if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
                return true;
            }
            //case by case to check whether the closing symbol is paired with a corresponding opening symbol
            else if (a == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    return true;
                }
                else {
                    return false;
                }
            }
            else if (a == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    return true;
                }
                else {
                    return false;
                }
            }
            else if (a == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    //check quotation mark
    //if within the /*..., ignore the current element
    //since the opening and closing symbol are the same
    //we see the first " as opening mark, second " as closing mark, so on and so forth
    //mismatched if a " is left in the stack after we read through the whole file
    public static boolean checkquo(char a) {

        if (a == '"') {
            if (stack.isEmpty()) {
                stack.push(a);
            }

            else if (stack.peek() == '"') {
                stack.pop();
            }

            //if within the /*..., then do nothing but return true
            else if (stack.peek() == '*') {
                return true;
            }
            else {
                stack.push(a);
            }
        }
        return true;
    }

    //check the comment mark
    //if within the "" or /*... then ignore the current element (simply return true)
    //otherwise, if /*, then push(*)
    //if */, then check if an opening symbol has been stored in the stack
    //if no, return false
    //else, pop the opening symbol and return true
    public static boolean checkcom(String a){
        if (a.equals("/*")) {
            if (stack.isEmpty()) {
                stack.push('*');
            }

            else if (stack.peek() != '"' && stack.peek() != '*') {
                stack.push('*');
            }
            return true;
        }

        else if (a.equals("*/")) {
            if (stack.isEmpty()) {
                return false;
            }
            else if (stack.peek() == '"') {
                return true;
            }
            else if (stack.peek() == '*') {
                stack.pop();
                return true;
            }
            return false;
        }
        return true;
    }

}
