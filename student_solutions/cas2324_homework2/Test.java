/*
 * Sup. Test to make sure we ignore comments and also catch
 * an opening curly { mismatch.
 */

/*
 * [This [)}] should be fine.
 * "As should this.
(] */

public class Test {
    private String s = "Yo! Fine? } ( Should be!";
    public static final void main(String[] args) {
        System.out.println("Hellow.");
        int[] arr = new int{; // Should cause an error.
    }
}
