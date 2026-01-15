package quicksort;
import java.util.Random;

public class main {

	static int[] basicarray = {4, 8, 3, 1, 7, 5, 2, 6};
	static int left_pos = 0;
	static int right_pos = basicarray.length-2;
	static int pivot_pos = 0;
	static int pivot = basicarray[pivot_pos];
	static int right = basicarray[right_pos];
	static int left = basicarray[left_pos];
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(5);
		n += 1;
		pivot_pos = n;
		pivot = basicarray[pivot_pos];
		
		while (left > pivot) {
			left_pos++;
			System.out.println("l:" + left_pos);
		}
		while (right > pivot) {
			right_pos--;
			System.out.println("r:" + right_pos);
		}
		save();
		basicarray[right_pos] = left;
		basicarray[left_pos] = right;
		print();
	}
	
	public static void save() {
		pivot = basicarray[pivot_pos];
		right = basicarray[right_pos];
		left = basicarray[left_pos];
	}
	
	public static void print() {
		for (int i = 0; i<basicarray.length; i++) {
			System.out.println(basicarray[i]);
		}
	}

}
