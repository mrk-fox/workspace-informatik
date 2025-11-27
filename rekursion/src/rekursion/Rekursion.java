package rekursion;

public class Rekursion {
	static int wasser = 4;
	
	public static void baumfaellen(int a) {
		System.out.println("hacke stark");
		if(trinkewasser()) {
			System.out.println("Kein Wasser mehr!");
		}
		else if(a==1) {
			System.out.println("Baum fällt!");
		}
		else if(a==0) {
			System.out.println("Baum hat dich erschlagen! (looser haha)");
		}
		
		else {
			baumfaellen(a-2);
		}
	}
	public static boolean trinkewasser() {
		boolean state = false;
		wasser = wasser - 1;
		if(wasser == 0) {
			state = true;
		}
		return state;
	}
	
	public static void main(String[] args) {
		baumfaellen(6);
	}
	
	

}
