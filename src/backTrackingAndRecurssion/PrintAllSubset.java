package backTrackingAndRecurssion;

public class PrintAllSubset {

	public static void printAllSubSet (int[] arr) {
		if (arr == null) {
			return;
		}
		int[] buffer = new int[arr.length];
		printAllSubsetHelper(arr, buffer, 0, 0);
	}
	
	public static void printAllSubsetHelper (int[] arr, int[] buffer,
			int startIndex, int bufferIndex) {
		print(buffer, bufferIndex);
		if (startIndex == arr.length) {
			return;
		}
		for (int i = startIndex; i < arr.length; i++) {
			buffer[bufferIndex] = arr[i];
			printAllSubsetHelper(arr, buffer, i+1, bufferIndex+1);
		}
	}
	
	public static void print (int[] buffer, int bufferIndex) {
		System.out.print("[ ");
		for(int i = 0; i < bufferIndex; i++) {
			System.out.print(buffer[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3};
		printAllSubSet(arr);

	}

}
