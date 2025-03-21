package subarrayProblems;

public class SubArraySumSlidingWinmdow {

	public static int[] slidingWindow (int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] result = new int[2];
		int start = 0, end = 0, sum = arr[0];
		while(start < arr.length) {
			if (start > end) {
				end = start;
				sum = arr[start];
			}
			if (sum < target) {
				if (end == arr.length - 1)
					break;
				end++;
				sum += arr[end];
			} else if (sum > target) {
				sum -= arr[start];
				start++;
			} else {
				result[0] = start;
				result[1] = end;
				return result;
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,5,2};
		int[] result = slidingWindow(arr, 8);
		for (int i = result[0]; i  <= result[1]; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
