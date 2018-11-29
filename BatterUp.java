import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
public class BatterUp {
	public  int Score=0;
	public  int Outs;
	public  int nextPlayerIndex;
	public  ArrayList<Player> players= new ArrayList<Player>();
	public  Field f= new Field();
	
	public BatterUp() throws FileNotFoundException {
		
		Score=0;
		Outs=0;
		nextPlayerIndex=-1;
		createPlayers();
		System.out.println(players.get(1).getName());
		
		
		
	}
	public  void createPlayers() throws FileNotFoundException {
		Scanner input = new Scanner(new File("players.txt"));
		input.useDelimiter(",|\n");
		for(int i=0;i<9;i++) {
		String name=input.next();
		String type=input.next();
		Player p= new Player("",f.getDugout());
		if(type.equals("Average")) {
			 p = new Player(name,f.getDugout());
		}
		if(type.equals("Ringer")) {
			 p = new Ringer(name,f.getDugout());
		}
		if(type.equals("Dud")) {
			 p = new Dud(name,f.getDugout());
		}
		players.add(p);
		}
	}
	
	public  Player getNextPlayer() {
		
		Player player= new Player("",f.getDugout());
		if (nextPlayerIndex==9) {
			
			nextPlayerIndex=0;
			//return player;
			
		}
		nextPlayerIndex++;
		players.get(nextPlayerIndex).Setlocation(f.getBatterBox());
		
		
		return players.get(nextPlayerIndex);
	}
	public void play() throws FileNotFoundException {
		createPlayers();
		for(int innings=1;innings<10;innings++) {
		while(Outs<3) {
			displayField();
			Player p=getNextPlayer();
			System.out.println(p.getName()+" is batting");
			Base base=f.getBatterBox();
			p.Setlocation(base);	
			int i = p.takeTurn();
			
			if (i==0) {
				p.Setlocation(f.getDugout());
				Outs++;
			}
			else {
				movePlayers(i);
			}
			
	}
		Outs=0;
		System.out.println("INNING "+ innings+" Over With a Score of "+Score);
		}
		printStats();
	}
	public 
	void movePlayers(int bases) {
		for(int i=0;i<players.size();i++) {
			
			if(players.get(i).isNotInDugout()) {
				players.get(i).Setlocation(f.moveAhead(players.get(i).getlocation(), bases));
				if(players.get(i).getlocation().isHome()) {
					players.get(i).Setlocation(f.getDugout());
					Score++;
					
				}
			}
		}
	}
	public void printStats() throws FileNotFoundException {
		PrintWriter output = new PrintWriter("Stats.txt"); 
		output.print("GAME STATS:\n");
		output.print("************************************\n");
		
		output.printf("%s        %s  %s  %s%n", "PLAYER","HITS","AT-BATS", "AVERAGE");
		for(int i=0; i<9;i++) {
			output.printf("%s%6d%6d%6.2f%n", players.get(i).getName(),players.get(i).getHits(),players.get(i).getAtBats(), players.get(i).getBattingAverage());
		}
		output.close();
		
	}
	public String onFirst() {
		for (int i=0;i<players.size();i++){
			Player p= players.get(i);
			if(p.getlocation().getName().equals("First")) {
				System.out.println("on first: "+p.getName() );
				return p.getName();
				//b1=p.toString();
			
			}
		}
		return "Empty";
	}
	public String onSecond() {
		for (int i=0;i<players.size();i++){
			Player p= players.get(i);
			if(p.getlocation().getName().equals("Second")) {
				System.out.println("on Second: "+p.getName() );
				return p.getName();
				//b1=p.toString();
			
			}
		}
		return "Empty";
	}
	public String onThird() {
		
		for (int i=0;i<players.size();i++){
			Player p= players.get(i);
			if(p.getlocation().getName().equals("Third")) {
				System.out.println("on Third: "+p.getName() );
				return p.getName();
				//b1=p.toString();
			
			}
		}
		return "Empty";
	}
	public  void displayField() {
		String b1= onFirst();
		String b2= onSecond();
		String b3= onThird();
		
		
			 /*if(p.getlocation().getName().equals("Second")) {
				System.out.println("on Second: "+p.getName() );
				 //b2=p.toString();
				//break;
				
			}
			else if(p.getlocation().getName().equals("Third")) {
				 b3=p.toString();
				// break;
								
			}*/
			 
		
		
		System.out.printf("%s %s %s %s %s %s %n",f.bases.get(2).toString(),b1,f.bases.get(3).toString(),b2,f.bases.get(4).toString(),b3);
		 
	}
}
