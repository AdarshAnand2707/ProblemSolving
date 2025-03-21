package backTrackingAndRecurssion;

import java.util.HashMap;

public class FibbonaciSeries {

	/**
	 * BAcktracking- Recurrsive
	 * Exponential Time Complexity.
	 * @param n
	 * @return
	 */
	public static int fibbonaci (int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibbonaci(n-1) + fibbonaci(n-2);
	}
	
	/**
	 * Backtracking - Memoization
	 * Linear Time Complexity
	 * @param n
	 * @param map
	 * @return
	 */
	public static int fibbonaci (int n, HashMap<Integer, Integer> map) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int result = fibbonaci(n-1) + fibbonaci(n-2);
		map.put(n, result);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(fibbonaci(8));
		System.out.println(fibbonaci(8, new HashMap<>()));
	}

}
