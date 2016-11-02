/* Kelly Ryu
 * hr2362
 * MyTest.java - tests SymbolBalance java for missing /*
 */

public class Test {
    public static void main(String[] args){
        System.out.println("hello");
        /* This is a valid comment*/
            
        String y = "[} brackets are ignored inside quotations";
            
        /
        * This is invalid
        There is no opening symbol for comment block */
              
    }
}
