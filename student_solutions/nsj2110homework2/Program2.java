public class Program2 {

    /** This code should output: 
     *  0
     *  Uranus
     *  Mercury
     *  3
     *  Neptune
     *  Saturn
     *  Jupiter
     *  Earth
     *	Mars
     */
    public static final void main(String[] args) {

	TwoStackQueue<String> qPlanet = new TwoStackQueue<String>();

	System.out.println(qPlanet.size());
	qPlanet.enqueue("Uranus");
	qPlanet.enqueue("Mercury");
	System.out.println(qPlanet.dequeue());
	qPlanet.enqueue("Neptune");
	qPlanet.enqueue("Saturn");
	qPlanet.enqueue("Jupiter");
	System.out.println(qPlanet.dequeue());
	System.out.println(qPlanet.size());
	qPlanet.enqueue("Earth");
	qPlanet.enqueue("Mars");

	while(!qPlanet.isEmpty())
	    System.out.println(qPlanet.dequeue());

    }

}