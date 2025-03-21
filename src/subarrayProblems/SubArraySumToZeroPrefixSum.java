package subarrayProblems;

import java.util.HashMap;

public class SubArraySumToZeroPrefixSum {

	public static int[] subArraySumToZero (int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] result = new int[2];
		int prefixSum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];
			if (prefixSum == 0) {
				result[0] =0;
				result[1] = i;
				return result;
			}
			if (map.containsKey(prefixSum)) {
				result[0] = map.get(prefixSum) + 1;
				result[1] = i;
				return result;
			}
			map.put(prefixSum, i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr= new int[] {2,4,-2,1,-3,5,-3};
		int[] result = subArraySumToZero(arr);
		for (int i =result[0]; i<= result[1]; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
