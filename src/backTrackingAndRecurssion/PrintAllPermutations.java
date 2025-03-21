package backTrackingAndRecurssion;

public class PrintAllPermutations {

	public static void printAllPermuations (int[] arr, int x) {
		if (arr == null || arr.length == 0 || arr.length < x) {
			return;
		}
		int[] buffer = new int[x];
		boolean[] isInBuffer = new boolean[arr.length];
		printAllPermutationsHelper(arr, buffer, 0, isInBuffer);
	}
	
	public static void printAllPermutationsHelper(int[] arr,int[] buffer, int bufferIndex, boolean[] isInBuffer) {
		if (bufferIndex == buffer.length) {
			print(buffer);
			return;
		}
		for (int i =0; i < arr.length; i++) {
			if(!isInBuffer[i]) {
				isInBuffer[i] = true;
				buffer[bufferIndex] = arr[i];
				printAllPermutationsHelper(arr, buffer, bufferIndex + 1, isInBuffer);
				isInBuffer[i] = false;
			}
		}
		
	}
	
	
	public static void print (int[] buffer) {
		System.out.print("[ ");
		for(int i = 0; i < buffer.length; i++) {
			System.out.print(buffer[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6};
		printAllPermuations(arr, 3);

	}

}
