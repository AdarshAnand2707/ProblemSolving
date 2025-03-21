package subarrayProblems;

public class MaxSubarraySumKadanesAlgo {
	
	public static int bruteForceApprocah (int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Input Array cannot be null");
		}
		int result =Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum+= arr[j];
				result = Math.max(sum, result);
			}
		}
		return result;
	}
	
	public static int kadanesAlgorithm (int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Input Array Cannot be Null");
		}
		int result = arr[0], maxSumEndingHere = arr[0];
		for (int i =1; i < arr.length; i++) {
			maxSumEndingHere = Math.max(maxSumEndingHere + arr[i], arr[i]);
			result = Math.max(maxSumEndingHere, result);
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,-1,2,-3,2,-5};
		System.out.println(bruteForceApprocah(arr));
		System.out.println(kadanesAlgorithm(arr));
	}

}
