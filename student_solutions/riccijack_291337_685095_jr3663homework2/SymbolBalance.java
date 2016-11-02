import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.util.LinkedList;

public class SymbolBalance{
    //Integer values for all relevant symbols are initialized
    private static final int leftBrace = 91;
    private static final int rightBrace = 93;

    private static final int leftBracket = 123;
    private static final int rightBracket = 125;

    private static final int leftParenthesis = 40;
    private static final int rightParenthesis = 41;

    private static final int asterisk = 42;
    private static final int quote = 34;
    private static final int slash = 47;

    private static final int newLine = 10;

    //Closing symbol method matches an opening symbol with its corresponding closing symbol
    private static int closingSymbol(int openingSymbol){
        int closer = -1;
        switch(openingSymbol){
            case leftParenthesis:
                closer = rightParenthesis;
                break;
            case leftBrace:
                closer = rightBrace;
                break;
            case leftBracket:
                closer = rightBracket;
                break;
            case quote:
                closer = quote;
                break;
            case asterisk:
                closer = asterisk;
                break;
            case slash:
                closer = slash;
                break;
        };

        return closer;
    }

    /** Balance Symbols method takes a buffered java file as an argument
     * and checks it for symbol imbalance
     */
    public static void BalanceSymbols(BufferedReader javaFile){
        //Stack object initialized
        MyStack<Integer> charStack = new MyStack<>();
        int inputChar;
        int topOfStack;

        //pos variable tracks position of input character, blockPosHandler used for block comment scenarios
        int pos = 0;
        int blockPosHandler = -1;
        int blockPosValue = -1;
        //int i = 0;

        try {
            while ((inputChar = javaFile.read()) != -1) {

                //Check top of stack
                if(charStack.top() == null){
                    topOfStack = -1;
                }else{
                    topOfStack = charStack.top();
                }

                //If "{", "(", or "[" are found outside of a comment or a quote, push to stack
               if((inputChar == leftBrace || inputChar == leftParenthesis || inputChar == leftBracket) && topOfStack != quote && topOfStack != asterisk){
                   charStack.push(inputChar);

                   //If " is found in a quote, pop stack to end quote. Otherwise push to stack if not in comment
               }else if(inputChar == quote){
                   if(topOfStack == quote) {
                       charStack.pop();
                   }else if(topOfStack != asterisk){
                       charStack.push(inputChar);
                   }

                //If asterisk appears within block comment, note position. If asterisk follows slash, initiate block comment
               }else if(inputChar == asterisk){
                   if(topOfStack == asterisk){
                       //charStack.pop();
                       blockPosHandler = pos;
                       blockPosValue = asterisk;
                   }else if((pos - blockPosHandler == 1) && blockPosValue == slash){
                       charStack.push(slash);
                       charStack.push(inputChar);
                   }

                   //If slash follows an asterisk, end the comment by double popping stack.
                   //If not in a comment or quote, note the position of the slash
               }else if(inputChar == slash){
                   if(topOfStack == asterisk && (pos - blockPosHandler == 1) && blockPosValue == asterisk){
                       charStack.pop();
                       charStack.pop();
                   }else if(topOfStack != asterisk && topOfStack != quote){
                       //charStack.push(inputChar);
                       blockPosHandler = pos;
                       blockPosValue = slash;
                   }

                   //If a quote is not balanced by the end of the line, throw an error message
               }else if(inputChar == newLine && topOfStack == quote){
                   int poppedVal = charStack.pop();
                   char c = (char) poppedVal;
                   System.out.println("Error: The quote symbol " + c + " has not been balanced on the proper line.");
                   return;
               }

               //If a closing character is given check to see if the stack has its corresponding opening symbol
               if((inputChar == rightBrace || inputChar == rightParenthesis || inputChar == rightBracket) && topOfStack != asterisk && topOfStack != quote){
                if(charStack.isEmpty()){
                    char c = (char) inputChar;
                    System.out.println("Error: No opening symbol for " + c);
                    return;
                }else{
                    int poppedVal = charStack.pop();
                    int popMatch = closingSymbol(poppedVal);

                    if(inputChar != popMatch){
                        char poppedValChar = (char) poppedVal;
                        char c = (char) inputChar;
                        System.out.println("Error: Mismatched opening symbol. Symbol " + poppedValChar + " cannot be closed by " + c);
                        return;
                    }
                }
               }

               //Note the position of the character
               pos++;
            }

            //Once all characters have been read, check to see if stack is empty
            if(!charStack.isEmpty()){
                int poppedVal = charStack.pop();
                char c = (char) poppedVal;
                System.out.println("Error: The symbol " + c + " has not been balanced.");
            }else{
                System.out.println("All symbols are balanced!");
            }


            /*LinkedList<Integer> l = charStack.getStackList();
            for(int k = 0; k < l.size(); k++){
                int j = l.get(k);
                char b = (char) j;
                System.out.println(b);
            } */
        }catch (IOException e){
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    public static void main(String[] args){

        try {
            BufferedReader javaFile = new BufferedReader(new FileReader(args[0]));

            BalanceSymbols(javaFile);
        }catch (IOException e){
            System.out.println("Input Error: " + e.getMessage());
        }

    }
}