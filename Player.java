import java.util.Random;

public class Player {
	private  String Name;
	private  int Strikes=0;
	private int atBats;
	private int hits;
	private  int Balls=0;
	public  Base Location;
	public Player(String name, Base base) {
		atBats=0;
		hits=0;
		setName(name);
		Location=base;
		
		
	}
	public  void setName(String name) {
		//System.out.println("bob");
		Name=name;
	}
	public  String getName() {
		//System.out.println(Name);
		return Name;
	}
	public  int getHits() {
		//System.out.println(Name);
		return hits;
	}
	public  int getAtBats() {
		//System.out.println(Name);
		return atBats;
	}
	public  void Setlocation(Base i) {
		Location=i;
			}
	public  Base getlocation() {
		return Location;
			}
	public  Boolean isNotInDugout()
	{
		if(Location.isDugout()) {
			return false;
		}
		return true;
	}
	public int[] roll() 
	{
		Random rand=new Random();
		int[] rolls=new int[2];
		rolls[0]=rand.nextInt(6)+1;
		rolls[1]=rand.nextInt(6)+1;
		System.out.print("   Rolled  "+rolls[0]+" "+rolls[1]+" ");
		return rolls;
		
	}
	public  int bat() {
		int[] rolls=roll();
		int basesToMove=0;
		if(rolls[0]==rolls[1]&&rolls[0]<5) {
			switch(rolls[0]){
			case 1:
				System.out.println("Single!");
				return 1;
			
			case 2:
				System.out.println("Double!");
				return 2;
				 
			case 3:
				System.out.println("Triple!");
				return 3;
				
			case 4:
				System.out.println("Home Run!");
				return 4;
				
			}
			
		}
		else if((rolls[0]+rolls[1])%2==0) {
			
			System.out.println("Ball!");
			basesToMove = 0;
			Balls++;
			return basesToMove;
			
			
		}
			
		else if((rolls[0]+rolls[1])%2!=0) {
			
			System.out.println("Strike!");
			basesToMove = 0;
			Strikes++;
			return basesToMove;
			
			
		}
		return basesToMove;
		
	}
	public  int takeTurn() {
		Strikes=0;
		Balls=0;
		atBats+=1;
		while(Balls<4&&Strikes<3){
			int x=bat();
			if(x!=0) {
				hits+=1;
				return x;
			}
			
			
		}
		if(Balls==4) {
			System.out.println("Walk");
			return 1;
		}
			System.out.println("Strike Out!!");
			return 0;
		
	}
	public  String toString(){
		
		return " "+getName();
	}
	public double getBattingAverage()
	{
		double battingAvg=0;
		if(hits>0) {
			 battingAvg=atBats/hits;}
	
		return battingAvg;
	}
	
	}



