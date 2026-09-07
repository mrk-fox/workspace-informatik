package main;

public class WindDir {
	double p;
	public WindDir(double pp) {
		if (pp > 360.0 || pp < 0.0) {
			System.out.println("Given value ouf of bound range. Unit: Degrees (°)");
		} else {
			p = pp;
		}
	}
	
	public double getWDir() {
		return p;
	}
	
	public void setWdir(double pi) {
		if (pi > 360.0 || pi < 0.0) {
			System.out.println("Given value ouf of bound range. Unit: Degrees (°)");
		} else {
			p = pi;
		}
	}
}
