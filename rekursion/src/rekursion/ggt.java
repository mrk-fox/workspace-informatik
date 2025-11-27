package rekursion;
import java.util.ArrayList;

public class ggt {
	static ArrayList<Integer> div_a = new ArrayList<Integer>();
	static ArrayList<Integer> div_b = new ArrayList<Integer>();
	static ArrayList<Integer> div = new ArrayList<Integer>();
	
	public static int cggt(int a, int b) {
		int i = 1;
		findDiv(a, i);
		for (Integer p : div) {
		    div_a.add(p);
		}
		
		i = 1;
		findDiv(b, i);
		for (Integer p : div) {
		    div_a.add(p);
		}
		
		div_a.retainAll(div_b);
		
		int max = 0;
		for (Integer p : div) {
		    if(p < max) {p = max;}
		}
		return max;
	}
	
	public static void findDiv(int d, int i) {
		if(d % i == 0 && i<d) {
			div.add(i);
			findDiv(d, i+1);
		}
		else if(d % i != 0 && i<d) {
			i++;
			findDiv(d, i+1);
		}
		else {
			System.out.println("end_findDiv");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(cggt(12, 6));
		
	}

}
