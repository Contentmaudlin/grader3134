public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
    MyStack<AnyType> s1 = new MyStack<AnyType>();
    MyStack<AnyType> s2 = new MyStack<AnyType>();

	 // Performs the enqueue operation
    public void enqueue(AnyType x){
       if (s2.size() > 0){
            migrateStack(s2, s1);
            s1.myPush(x);
       } else {
        s1.myPush(x);
       }
    }

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue(){
        migrateStack(s1, s2);
        return s2.myPop();
    }

    // Checks if the Queue is empty
    public boolean isEmpty(){
        if ((s1.size() == 0) && (s2.size() == 0)){
            return true;
        }
        return false;
    }

    // Returns the number of elements currently in the queue
    public int size(){

         int counter = 0;

         if (s1.size() > 0){
            while(s1.size() > 0){ // move all contents from s1 to s2, count how many items
             counter++;
             AnyType holder = s1.myPop();
             s2.myPush(holder);
            }
            migrateStack(s2, s1); // return contents to s1 
         }
         
     
         if (s2.size() > 0){
            while (s2.size() > 0){ // move all contents from s2 to s1, count how many items
             counter++;
             AnyType holder = s2.myPop();
             s1.myPush(holder);
            }
            migrateStack(s1, s2); // return contents to s2
         }
         
         return counter; // return size of queue
    }

    // accordian all the contents of stack A to stack B
    private void migrateStack(MyStack<AnyType> a, MyStack<AnyType> b){
        while(a.size() > 0){
            AnyType holder = a.myPop();
            b.myPush(holder);
        } 
    }

}