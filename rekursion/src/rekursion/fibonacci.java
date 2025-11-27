package rekursion;

public class fibonacci {
	static int pre = 0;
	static int lok = 1; 
	public static int fibonacci(int num) {
		int s_d = lok;
		lok = pre+lok;
		pre = s_d;
		num = num -1;
		if (num != 1) {
			fibonacci(num);
		}
		return lok;
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(8));

	}

}
