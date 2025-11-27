package rekursion;

public class sagObPalindrom {
	public static void helper(String wort) {
		char[] ca = wort.toCharArray();
		int length = ca.length-1;
		System.out.println("Wort: "+wort);
		System.out.println("Length: "+length);
		System.out.println("");
		System.out.println(String.valueOf(sagObPalindrom(ca, length, 0)));
		}
	
	
	public static boolean sagObPalindrom(char[] ca, int length, int nul) {

		if(ca[nul] != ca[length]) {
			return false;
			
		}
		if(length-nul > 1) {
			sagObPalindrom(ca, length-1, nul+1);
			return true;
		}
		else {
			return false;
		}

		
	}
	
	public static void main(String[] args) {
		helper("panap");

	}

}
