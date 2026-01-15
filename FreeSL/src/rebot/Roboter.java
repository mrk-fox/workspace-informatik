package rebot;
import java.util.Random;

public class Roboter {
	Random rnd = new Random();
	String name;
	int increment_num;
	char department;
	String uniqueHex;
	int bat;
	boolean loads;
	
	public Roboter(String pName, int pIncrement_num, char pDepartment) {
		name = pName;
		increment_num = pIncrement_num;
		department = pDepartment;
		uniqueHex = Hex.generateUnboundedRandomHex();
		bat = 100;
		loads = false;
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
		if(rnd.nextInt(3) == 0)  {
			bat = bat - minus;
		}
	}
	
	public void chargeBat(int plus) {
		bat = bat + plus;
	}
	
	public int getBat() {
		return bat;
	}
	
	public void changeLoad() {
		loads = !loads;
	}
	
	public boolean currentLoad() {
		return loads;
	}
}
