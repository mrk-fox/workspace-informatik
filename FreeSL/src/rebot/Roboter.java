package rebot;

public class Roboter {
	String name;
	int increment_num;
	char department;
	String uniqueHex;
	int bat;
	
	public Roboter(String pName, int pIncrement_num, char pDepartment) {
		name = pName;
		increment_num = pIncrement_num;
		department = pDepartment;
		uniqueHex = Hex.generateUnboundedRandomHex();
		int bat = 100;
		}
	
	public String giveName() {
		return name;
	}
	public int giveNum() {
		return increment_num;
	}
	public char giveDepartment() {
		return department;
	}
	
	public String giveHex() {
		return uniqueHex;
	}
	
	public void changeBat(int minus) {
		bat = bat - minus;
	}
	
	public void chargeBat() {
		bat = 100;
	}
	
	public int getBat() {
		return bat;
	}
}
