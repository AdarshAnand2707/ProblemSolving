package binarySearch;

public class InsertNumberToArray {

	public static int IndextoInsertNumber(int[] arr, int target) {
		if (arr == null) {
			return -1;
		}
		if (arr.length == 0) {
			return 0;
		}
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start)/2;
			if (arr[mid] <= target) {
				if (mid == arr.length - 1) {
					return arr.length;
				}
				start = mid + 1;
			} else {
				if (mid == 0 || arr[mid - 1] <= target) {
					return mid;
				}
				end = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,4,5,6,8};
		System.out.println(IndextoInsertNumber(arr, 3));
	}

}
