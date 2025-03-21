package backTrackingAndRecurssion;

public class PrintAllCombinationsOfGivenSize {

	public static void printAllCombination(int[] arr, int size) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int[] buffer = new int[size];
		printAllCombintionHelper(arr, 0, buffer, 0);
	}
	
	public static void printAllCombintionHelper(int[] arr, int start, int[] buffer, int bufferIndex) {
		if (bufferIndex == buffer.length) {
			printBufferHelper(buffer);
			return;
		}
		if (start == arr.length) {
			return;
		}
		for (int i = start; i < arr.length; i++) {
			buffer[bufferIndex] = arr[i];
			printAllCombintionHelper(arr, i+1, buffer, bufferIndex+1);
		}
	}
	
	public static void printBufferHelper (int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7};
		printAllCombination(arr, 3);

	}

}
