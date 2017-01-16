package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {

	Map<String, Integer> votes = new HashMap<String, Integer>();
	
	public VoteList(){
		
	}
	
	public void addVote(String party){
		if(votes.putIfAbsent(party, 1)!=null){
			votes.replace(party, votes.get(party)+1);
		}
		setChanged();
		notifyObservers("vote");
		System.out.println("Voted");
	}
	
	public Map<String, Integer> getVotes(){
		return votes;
	}
}