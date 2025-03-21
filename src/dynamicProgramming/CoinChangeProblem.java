package dynamicProgramming;

public class CoinChangeProblem {
	
	public static int numberOfCoinsNeeded (int target, int[] coins) {
		int[] waysArr = new int[target + 1];
		waysArr[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i < waysArr.length; i++) {
				waysArr[i] = waysArr[i] + waysArr[i-coin];
			}
		}
		return waysArr[target];
	}

	public static void main(String[] args) {
		int[] coins = new int[] {1, 2, 5};
		System.out.println(numberOfCoinsNeeded(5, coins));
	}

}
