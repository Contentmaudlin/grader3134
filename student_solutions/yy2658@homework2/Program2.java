/*it should output
*0
*7
*116th street
*110th street
*103rd street
*96th street
*86th street
*79th street
*72nd street
*0
*null
 */

//yy2658
//Tester for two stack queue

public class Program2 {

	public static void main(String[] args) {
		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());
		q.enqueue("116th street");
		q.enqueue("110th street");
		q.enqueue("103rd street");
		q.enqueue("96th street");
		q.enqueue("86th street");
		q.enqueue("79th street");
		q.enqueue("72nd street");
		System.out.println(q.size());
		while(!q.isEmpty()){
			System.out.println(q.dequeue());
		}
		System.out.println(q.size());
		System.out.println(q.dequeue());
		


		
		

	}

}