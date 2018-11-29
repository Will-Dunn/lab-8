
public class Base {
	public  String Name;
	public  Base(String name) {
		setName(name);
		
		
	}
	public  void setName(String name) {
		//sets the name 
		Name=name;
		
	}
	public  String getName() {
		// gets the name 
		return Name;
	}
	public  boolean isDugout() {
		//if name is dug out 
		if(Name.equals("Dugout"))
			return true;
		return false;
	}
	
	public  boolean isHome() {
		//if name is home
		if(Name.equals("Home"))
			return true;
		return false;
	}
	public  String toString() {
		return "["+Name+"]";
	}
}
