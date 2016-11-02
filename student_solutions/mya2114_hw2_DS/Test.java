/*

If this program works correctly, 
then it should throw the exception:

There is no closing symbol for {


*/


///////////////////////////////////////////////////////////////////////////////////////


	import java.util.ArrayList;
	import java.util.List;


public class Test {	

	    // Initialize instance variables
	    private int firstNumber = 0;
	    private int secondNumber = 0;
	    private int thirdNumber = 0;
	    private int pointer = 0;

	    List<Integer> codes = new ArrayList<Integer>();
	    List<Integer> codesList = new ArrayList<Integer>();
	    String side = "";


	    // Constructor which takes in the secret codes and stores them in a list
	    public Test(int secret1, int secret2, int secret3) {
	        firstNumber = secret1;
	        secondNumber = secret2;
	        thirdNumber = secret3;
	        codes.clear();
	        codes.add(Integer.valueOf(firstNumber));
	        codes.add(Integer.valueOf(secondNumber));
	        codes.add(Integer.valueOf(thirdNumber));
	        }


	    // Constructor if no argument passed. Make the secret code 0,0,0
	    public Test() {
	        codes.clear();
	        codes.add(0);
	        codes.add(0);
	        codes.add(0);
	    }


	    // simulate reseting the lock back to its initial position
	    public void reset() {
	        pointer = 0;
	        codesList.clear();
	        side = "";
	    }


	    // Simulate a gym lock turning left.
	    public void turnLeft(int ticks) {
	        // ensure the lock is actually turned
	        if (ticks != 0) {
	            // Increment the pointer by the number of ticks
	            pointer += ticks;
	            // if the pointer goes above 39, then it should reset again...
	            while (pointer >= 40) {
	                pointer -= 40 ; 
	            }

	        // add the new pointer location to the list which stores all pointer
	        // locations
	        codesList.add(Integer.valueOf(pointer));

	        // add the side the lock was turned to the list which stores the
	        // direction lock was turned in
	        side += "L";

	        }
	        }


	    public void turnRight(int ticks) {
	    // ensure the lock is actually turned
	        if (ticks != 0) {
	            // decrease the pointer by number of ticks
	            pointer -= ticks;
	                // if the pointer cross 0 to negative, it will go to 39 instead of
	                // -1. This function is simulated
	                while (pointer < 0) {
	                    pointer += 40;
	                }
	                    
	    // add the new pointer location to the list which stores all pointer
	    // locations
	    codesList.add(Integer.valueOf(pointer));

	    // add the side the lock was turned to the list which stores the
	    // direction lock was turned in
	    side += "R";
		    }
		}

	        // Simulate trying to open a gym lock
	        public boolean open() {

	            // assume the lock can be unlocked
	            // perform checks and change it to false if it fails a test
	            boolean unlock = true;
	            
	            //If no secret code is entered, then the lock should open
	            //when the pointer is at 0
	            if(codes.get(0)==0 && codes.get(1)==0 && codes.get(2)==0){
	                if (pointer ==0)
	                    return true;
	            }
	            
	            // check if the lock was turned at least thrice and it was turned last
	            // in the correct directions Right, Left, Right. Make unlock false
	            // If not satisfied
	            if (codesList.size() >= 3 && 
	               side.substring(side.length() - 3).equals("RLR")) {

	            // compare the list which holds the secret numbers and the last
	            // three
	            // numbers the lock pointed to to see if the lock should be
	            // unlocked.
	            // Make unlock false if any number is not the same, or is not in the
	            // the same sequence
	            // This is how a locker works
	            for (int i = 0; i < codes.size(); i++) {
	                if (codes.get(i) != codesList.get(codesList.size() - 3 + i)) {
	                    unlock = false;
	                }
	             }
		     } 
	             else {
	                 unlock = false;
	             }
	 
	             // return unlock value. Will return true if it passes all tests.
	             return unlock;
	        }

	//this should print an exception since there is no closing curly brace 
