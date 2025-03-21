package dynamicProgramming;

public class LongestIncreasingSubsequence {
	
	public static int longestIncreasingSubsequence (int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int result = 1;
		int[] lis = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				} 
			}
			result = Math.max(result, lis[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr= new int[] {1, 3, 2, 5, 3, 5, 6};
		System.out.println(longestIncreasingSubsequence(arr));
	}

}
