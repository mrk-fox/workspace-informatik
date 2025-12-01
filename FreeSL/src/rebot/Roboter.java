package rebot;

public class Roboter {
	String name;
	int increment_num;
	char department;
	
	public Roboter(String pName, int pIncrement_num, char pDepartment) {
		name = pName;
		increment_num = pIncrement_num;
		department = pDepartment;
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
	
		
}
