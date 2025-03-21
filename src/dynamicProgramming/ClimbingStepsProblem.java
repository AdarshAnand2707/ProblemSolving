package dynamicProgramming;

/**
 *  you have to climb N steps. 
 *  You can jump 1 step, 3 steps or 5 steps at a time. 
 *  How many ways are there to get to the top of the steps.
 */
public class ClimbingStepsProblem {
	
	// bottom-up
	public static int waysToClimb (int x) {
		int[] arr = new int[x+1];
		arr[0] = 1;
		for(int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length) {
				arr[i+1] += arr[i];
			}
			if (i + 3 < arr.length) {
				arr[i+3] += arr[i];
			}
			if(i + 5 < arr.length) {
				arr[i+5] += arr[i];
			}
		}
		return arr[x];
	}
	
	// top-down
	public static int waysToClimbTopDown (int n) {
		int[] arr = new int[n + 1];
		arr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int minus1 = i - 1 < 0 ? 0 : arr[i-1];
			int minus3 = i - 3 < 0 ? 0 : arr[i-3];
			int minus5 = i - 5 < 0 ? 0 : arr[i-5];
			arr[i] = minus1 + minus3 + minus5;
		}
		return arr[n];
	}

	public static void main(String[] args) {
		System.out.println(waysToClimb(8));
		System.out.println(waysToClimbTopDown(8));
	}

}
