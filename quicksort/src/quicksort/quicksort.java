package quicksort;

public class quicksort {
	static int[] data = {4, 8, 3, 1, 7, 5, 2, 6};
	public static void main(String[] args) {

		quicksort(0, data.length-1);
		for (int i = 0; i<data.length; i++) {
			System.out.print(data[i]);
		}

	}
	
	public static void quicksort(int left, int right) {
	    if (left < right) {
	        int divisor = div(left, right);
	        quicksort(left, divisor - 1);
	        quicksort(divisor + 1, right);
	    }
	}

	public static int div(int left, int right) {
	    int n = left;
	    int k = right - 1;
	    int pivot = data[right];

	    while (n <= k) {
	        while (n <= k && data[n] <= pivot) {
	            n++;
	        }
	        while (n <= k && data[k] > pivot) {
	            k--;
	        }
	        if (n < j) {
	            int tmp = data[n];
	            data[n] = data[k];
	            data[k] = tmp;
	        }
	    }

	    int tmp = data[n];
	    data[n] = data[right];
	    data[right] = tmp;

	    return n;
	}

} // <- class klammer
