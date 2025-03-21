package backTrackingAndRecurssion;

import java.util.Stack;

public class CoinChangeProblem {
	
	public static int counter = 0;

	public static void printCoins(int[] coins, int target) {
		if (coins == null || coins.length == 0) {
			return;
		}
		Stack<Integer> buffer = new Stack<>();
		printCoinsHelper(coins, 0, buffer, 0, target);
	}
	
	public static void printCoinsHelper (int[] coins, int startIndex, Stack<Integer> buffer, int currentSum, int target) {
		if (currentSum == target) {
			print(buffer);
			return;
		}
		if (currentSum > target) {
			return;
		}
		for(int i = startIndex; i < coins.length; i++) {
			buffer.push(coins[i]);
			printCoinsHelper(coins, i, buffer, currentSum+coins[i], target);
			buffer.pop();
		}
	}
	
	
	
	public static void print (Stack<Integer> buffer) {
		counter++;
		for(int current: buffer) {
			System.out.print(current + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,5};
		printCoins(coins, 5);
		System.out.println("Count: " + counter);
	}

}
