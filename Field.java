import java.util.*;

public class Field {
	public  ArrayList<Base> bases= new ArrayList<Base>();
	//public static Base[] bases=new Base[6];
	public Field() {
		
		Base DugOut=new Base("DugOut");
				bases.add(DugOut);
		Base BatterBox=new Base("BatterBox");
				bases.add(BatterBox);
		Base First=new Base("First");
				bases.add(First);
		Base Second=new Base("Second");
				bases.add(Second);
		Base Third=new Base("Thrid");
				bases.add(Third);
		Base Home=new Base("Home");
				bases.add(Home);
		//getDugout();
	}
	public   Base getDugout() {
		return bases.get(0);
	}
	public   Base getBatterBox() {
		return bases.get(1);
	}
	public  Base moveAhead(Base startingBase, int numberOfBases)
	{
		int startingBaseIndexNumber = bases.indexOf(startingBase);
		int newBaseIndexNumber = Math.min(startingBaseIndexNumber + numberOfBases, 5);
		Base newBase= bases.get(newBaseIndexNumber);
		return newBase;
		
		
	}
	
}
