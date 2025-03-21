package backTrackingAndRecurssion;

import java.util.Arrays;

public class BackTrackingMazeProblem {

	public static boolean pathExists(int[][] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		State[][] memo = new State[arr.length][arr[0].length];
		for (State[] state: memo) {
			Arrays.fill(state, State.Unvisited);
		}
		return pathExistsHelper(arr, 0, 0, memo);
	}
	
	public static boolean pathExistsHelper(int[][] arr, int i, int j, State[][] memo) {
		if (isIndexOutOfBound(arr, i, j) || arr[i][j] == 1 || memo[i][j] == State.Visiting || memo[i][j] == State.Path_not_Found) {
			return false;
		}
		if (i == arr.length -1 && j == arr[0].length -1) {
			return true;
		}
		memo[i][j] = State.Visiting;
		int[][] paths = new int[][] {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
		for (int[] path: paths) {
			if (pathExistsHelper(arr, path[0], path[1], memo)) {
				return true;
			}
		}
		memo[i][j] = State.Path_not_Found;
		return false;
	}
	
	public static boolean isIndexOutOfBound (int[][] arr, int i , int j) {
		return i < 0 || i >= arr.length || j < 0 || j >= arr.length;
	}
	
	public enum State {
		Unvisited,
		Visiting,
		Path_not_Found
	}
	
	public static int countNumberOfPaths (int[][] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		boolean[][] visiting = new boolean[arr.length][arr[0].length];
		for (boolean[] visit: visiting) {
			Arrays.fill(visit, false);
		}
		int[][] memo = new int[arr.length][arr[0].length];
		for(int[] m : memo) {
			Arrays.fill(m, -1);
		}
		return countNumberOfPaths(arr, 0, 0,memo, visiting);
	}
	
	public static int countNumberOfPaths(int[][] arr, int i, int j, int[][] memo, boolean[][] visiting) {
		if (isIndexOutOfBound(arr, i, j) || arr[i][j] == 1 || visiting[i][j]) {
			return 0;
		}
		if (i == arr.length -1 && j == arr[0].length - 1) {
			return 1;
		}
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		visiting[i][j] = true;
		int numberOfPath = 0;
		int[][] paths = new int[][] {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
		for (int[] path: paths) {
			numberOfPath += countNumberOfPaths(arr, path[0], path[1], memo, visiting);
		}
		visiting[i][j] = false;
		memo[i][j] = numberOfPath;
		return numberOfPath;
	}
	
	
	public static void main(String[] args) {
		int[][] maze = new int[][] {{0,1,0,0,0}, 
									{0,1,0,1,0},
									{0,1,0,1,0},
									{0,1,0,1,0},
									{0,0,0,1,0}};
									
		System.out.println(pathExists(maze));
		System.out.println(countNumberOfPaths(maze));
		int[][] grid = {{ 0, 0, 0, 0 },
		                { 0, 1, 0, 0 },
		                { 1, 0, 0, 0 },
		                { 0, 0, 0, 0 } };
		System.out.println(countNumberOfPaths(grid));
	}

}
