import java.util.Random;

public class Ringer extends Player{

	public Ringer(String name, Base base) {
		super(name, base);
		
	}
	public int[] roll() {
		Random rand=new Random();
		int[] rolls=new int[2];
		rolls[0]=rand.nextInt(3)+1;
		rolls[1]=rand.nextInt(3)+1;
		System.out.print("   Rolled  "+rolls[0]+" "+rolls[1]+" ");
		return rolls;
		
	}

}
