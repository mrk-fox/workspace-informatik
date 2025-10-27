package learn;

public class child extends human {
	

	
	String school;
	int grades;
	int nc;
	
	public child(String name, int nc) {
		super(name);
		this.nc = nc;
		// TODO Auto-generated constructor stub
	}
	
	public void uni() {
		if(nc < 1.4) {
			System.out.println("Aachen ruft");
		}
	}
	
	
}
