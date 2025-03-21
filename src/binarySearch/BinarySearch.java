package binarySearch;

public class BinarySearch {

	public static int search (int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int start = 0, end = arr.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(arr[mid] > target) {
				end = mid - 1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static <A extends Comparable<A>> int search(A[] arr, A target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start)/2;
			if (arr[mid].compareTo(target) > 0) {
				start = mid + 1;
			} else if (arr[mid].compareTo(target) < 0) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int searchWithDuplicate (int[] arr, int target) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start)/2;
			if(arr[mid] < target) {
				start = mid + 1;
			} else if (arr[mid] > target || (arr[mid] == target && mid > 0 && arr[mid - 1] == target)) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
