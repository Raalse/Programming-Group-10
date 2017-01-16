package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine{
	
	VoteList votes = new VoteList();
	PartyList parties = new PartyList();
	static VoteView view;
	
	public VoteMachine(){
		
	}
	
	public static void main(String[] args){
		VoteMachine machine = new VoteMachine();
		view = new VoteGUIView(machine);
		machine.parties.addObserver(view);
		machine.votes.addObserver(view);
		machine.start();
	}
	
	public void start(){
		view.start();
	}
	
	public void addParty(String party){
		parties.addParty(party);
	}
	
	public void vote(String party){
		if(parties.hasParty(party)){
			votes.addVote(party);
		}
		else{
			System.out.println("No valid party");
		}
	}
	
	public PartyList getParties(){
		return parties;
	}
	
	public VoteList getVotes(){
		return votes;
	}
	
}

/*
 * 6.16
 * The MVC pattern makes sure that the functionality and basic structure all happens in the Model,
 * display of information all happens in the View
 * and the connections and retrieval of data all happen in the Controller.
**/