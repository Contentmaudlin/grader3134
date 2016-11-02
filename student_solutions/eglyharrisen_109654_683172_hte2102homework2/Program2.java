//Tester for TwoStackQueue
public class Program2 {

	/*
	 * If tester works, this code's output should be a definitive ranking of US sports
	 * teams as follows:
	 * Vikings
	 * Royals
	 * Timberwolves
	 * 1
	 * Man City
	 * Michigan State
	 * 2
	 * Everyone Else
	 * Packers
	 * 0
	 * Little Leaguers
	 * null
	 * Michigan
	 * Is Michigan that bad?
	 * true
	 */
	public static void main(String[] args) {
		TwoStackQueue<String> SportsTeamRankings = new TwoStackQueue<String>();
		//Basic enqueueing and dequeueing to create desired print out and
		//demonstrate effectiveness of the TwoStackQueue methods
		SportsTeamRankings.enqueue("Vikings");
		SportsTeamRankings.enqueue("Royals");
		System.out.println(SportsTeamRankings.dequeue());
		SportsTeamRankings.enqueue("Timberwolves");
		System.out.println(SportsTeamRankings.dequeue());
		SportsTeamRankings.enqueue("Man City");
		System.out.println(SportsTeamRankings.dequeue());
		System.out.println(SportsTeamRankings.size());
		System.out.println(SportsTeamRankings.dequeue());
		SportsTeamRankings.enqueue("Michigan State");
		SportsTeamRankings.enqueue("Everyone Else");
		System.out.println(SportsTeamRankings.dequeue());
		SportsTeamRankings.enqueue("Packers");
		System.out.println(SportsTeamRankings.size());
		System.out.println(SportsTeamRankings.dequeue());
		System.out.println(SportsTeamRankings.dequeue());
		System.out.println(SportsTeamRankings.size());
		SportsTeamRankings.enqueue("Little Leaguers");
		System.out.println(SportsTeamRankings.dequeue());
		System.out.println(SportsTeamRankings.dequeue());
		SportsTeamRankings.enqueue("Michigan");
		SportsTeamRankings.enqueue("Is Michigan that bad?");
		System.out.println(SportsTeamRankings.dequeue());
		System.out.println(SportsTeamRankings.dequeue());
		System.out.println(SportsTeamRankings.isEmpty());
	}
}
