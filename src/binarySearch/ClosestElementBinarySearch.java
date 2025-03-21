package binarySearch;

public class ClosestElementBinarySearch {

	public static int closestElement (int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int start = 0, end = arr.length - 1, result = -1;
		while (start <= end) {
			int mid  = start + (end - start)/2;
			result = checkDiff(arr, target, mid, result);
			if (arr[mid] > target) {
				end = mid - 1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return result;
	}
	
	public static int checkDiff(int[] arr, int target, 
			int mid, int result) {
		if (result == -1 || (Math.abs(arr[mid] - target) < Math.abs(arr[result] - target))) {
			return mid;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,5,7,8};
		System.out.println(closestElement(arr, 6));

	}

}
