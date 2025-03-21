package dynamicProgramming;

import java.util.HashMap;

public class Fibbonaci {
	
	// reccursion
	public static int recFibbonaci(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return recFibbonaci(n-1) + recFibbonaci(n-2);
	}
	
	// memoization
	public static int memFibbonaci (int n, HashMap<Integer, Integer> memo) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		int result = memFibbonaci(n-1, memo) + memFibbonaci(n-2, memo);
		memo.put(n, result);
		return result;
	}
	
	// Tabulation
	public static int tabFibbonaci (int n) {
		int nminus1 = 1, nminus2 = 1, nth = 1;
		for (int i = 2; i <= n; i++) {
			nth = nminus1 + nminus2;
			nminus2 = nminus1;
			nminus1 = nth;
		}
		return nth;
	}
	

	public static void main(String[] args) {
		System.out.println(recFibbonaci(5));
		System.out.println(memFibbonaci(5, new HashMap<>()));
		System.out.println(tabFibbonaci(5));
	}

}
