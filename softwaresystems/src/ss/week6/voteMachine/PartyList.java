package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.Observable;

public class PartyList extends Observable {

	ArrayList<String> parties = new ArrayList<String>();
	
	public PartyList(){
		
	}
	
	public void addParty(String party){
		parties.add(party);
		setChanged();
		notifyObservers("party");
		System.out.println("Added");
	}
	
	public ArrayList<String> getParties(){
		return parties;
	}
	
	public boolean hasParty(String party){
		return parties.contains(party);
	}
}