package rekursion;

public class potenz {
	public static int i = 0;
	public static int res = 0;
	public static int berechenPotenz(int a, int b) {
		
		
		if(i < b) {
			res = a*a;
			i = i + 1;
			
			System.out.println("AP");
		}
		else {
			berechenPotenz(res,b-i);
			System.out.println("BP");
			}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(berechenPotenz(2,2));
	}

}
