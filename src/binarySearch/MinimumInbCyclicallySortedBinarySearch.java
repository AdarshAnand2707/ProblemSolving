package binarySearch;

public class MinimumInbCyclicallySortedBinarySearch {

	public static int minimumInCyclicallySortedArray (int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int start = 0, end = arr.length - 1, pivot = arr[arr.length - 1];
		while (start <= end) {
			int mid = start + (end - start)/2;
			if (arr[mid] <= pivot && (mid == 0 || arr[mid - 1] > arr[mid])) {
				return mid;
			} else if (arr[mid] > pivot) {
				start = mid + 1;
			} else if (arr[mid] < pivot) {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr= new int[] {4,5,1,2,3};
		System.out.println((minimumInCyclicallySortedArray(arr)));

	}

}
