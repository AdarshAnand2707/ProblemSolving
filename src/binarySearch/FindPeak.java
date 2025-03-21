package binarySearch;

public class FindPeak {
	
	public static int getPeak(int[] arr) {
		if (arr == null || arr.length ==0) {
			return -1;
		}
		int start = 0, end = arr.length -1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			int right = mid < (arr.length -1) ? arr[mid+1] : Integer.MIN_VALUE;
			int left = mid > 0 ? arr[mid-1] : Integer.MIN_VALUE;
			if (left < arr[mid] && right > arr[mid]) {
				start = mid + 1;
			} else if (left > arr[mid] && right < arr[mid]) {
				end = mid -1;
			} else if (left > arr[mid] && right > arr[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,4,5,2};
		System.out.println(arr[getPeak(arr)]);

	}

}
