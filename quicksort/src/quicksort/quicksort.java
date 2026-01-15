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
	    int i = left;
	    int j = right - 1;
	    int pivot = data[right];

	    while (i <= j) {
	        while (i <= j && data[i] <= pivot) {
	            i++;
	        }
	        while (i <= j && data[j] > pivot) {
	            j--;
	        }
	        if (i < j) {
	            int tmp = data[i];
	            data[i] = data[j];
	            data[j] = tmp;
	        }
	    }

	    int tmp = data[i];
	    data[i] = data[right];
	    data[right] = tmp;

	    return i;
	}

} // <- class klammer
