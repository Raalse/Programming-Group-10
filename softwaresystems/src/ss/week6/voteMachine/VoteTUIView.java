package ss.week6.voteMachine;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class VoteTUIView implements VoteView{
	
	VoteMachine machine = new VoteMachine();
	Scanner in = new Scanner(System.in);
	
	public VoteTUIView(VoteMachine machine){
		this.machine = machine;
	}
	
	public void start(){
		while(in.hasNextLine()){
			String input = in.next();
			switch(input){
			case "VOTE":
				if(in.hasNext()){
					String vote = in.next();
					machine.vote(vote);
					update(machine.getVotes(), "vote");
				}
				else{System.out.println("No argument given");}
				break;
			case "ADD":
				if(in.hasNext()){
					input = in.next();
					if(input.equals("PARTY")){
						String party = in.next();
						machine.addParty(party);
						update(machine.getParties(), "party");
					}
					else{System.out.println("No valid command");}
				}
				else{System.out.println("No valid command");}
				break;
			case "VOTES":
				showVotes(machine.getVotes().getVotes());
				break;
			case "PARTIES":
				showParties(machine.getParties().getParties());
				break;
			case "EXIT":
				stop();
				System.out.println("Exited");
				break;
			case "HELP":
				System.out.println("VOTE [party]        Adds vote to the party");
				System.out.println("ADD PARTY [party]   Adds party to the system");
				System.out.println("VOTES               Shows votes per party");
				System.out.println("PARTIES             Shows the parties");
				System.out.println("EXIT                Exits the program");
				break;
			default:
				System.out.println("No valid input");
				break;
			}
		}
	}
	
	public void update(Observable o, Object arg){
		o.notifyObservers(arg);
	}
	
	public void stop(){
		in.close();
		System.exit(0);
	}
	
	public void showVotes(Map<String, Integer> votes){
		System.out.println(votes.toString());
	}
	
	public void showParties(List<String> parties){
		System.out.println(parties.toString());
	}
	
	public void showError(String error){
		
	}
	
}