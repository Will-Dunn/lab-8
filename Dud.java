import java.util.Random;

public class Dud extends Player{

	public Dud(String name, Base base) {
		super(name, base);
		
	}
	public int[] roll() {
		Random rand=new Random();
		int[] rolls=new int[2];
		rolls[0]=rand.nextInt(10)+1;
		rolls[1]=rand.nextInt(10)+1;
		System.out.print("   Rolled  "+rolls[0]+" "+rolls[1]+" ");
		return rolls;
		
	}

}
