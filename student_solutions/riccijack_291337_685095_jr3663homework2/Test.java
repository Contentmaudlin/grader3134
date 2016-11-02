public class Test {
    public static final void main(String[] args) {
        /* this Symbol Balancer can handle any craziness * {}-[
        within block comments /* /*** ))))[})0)
         */

        /* it will ignore regular uses of asterisks and slashes,
        those don't need to be balanced
         */
        int x = 3*2;
        double y = x / 5;
        /*but if you don't finish a quote by the end of the line
        the balancer will catch the error
         */
        System.out.println("Hello.);
                "
                /*even if the next character on the next line is the closed quote */
    }
}