package ImportantProblems;


/**
 * n * n matrix 
 * each element representing a direction - up, down, left, right
 * start point - destination point
 * 
 * 
 * 
 * 
 */
public class Inteview {
	
	public static boolean isDestinationReachable(char[][] arr,int startI, int startJ, int destI, int destJ) {
		if (!isInBound(arr, startI, startJ)) {
			return false;
		}
		if(startI == destI && startJ == destJ) {
			return true;
		}
		char nextMove = arr[startI][startJ];
		int[] next = direction(nextMove, startI, startJ);
		if (isDestinationReachable(arr,next[0], next[1], destI, destJ)) {
			return true;
		}
		return false;
		
	}
	
	public static int[] direction(char direction, int i, int j) {
		switch (direction) {
		case 'U' : return new int[]{i-1,j};
		case 'L' : return new int[]{i,j-1};
		case 'R' : return new int[]{i,j+1};
		case 'D' : return new int[]{i+1,j};
		default: return new int[] {i, j};
		}
	}
	
	public static boolean isInBound (char[][] arr, int i, int j) {
		return !(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length); 
	}
	
	
	
	public static void main (String[] args) {
		char[][] grid = new char[][] {
			{'R', 'R', 'R', 'L'},
			{'L', 'L', 'R', 'D'},
			{'R', 'L', 'R', 'D'},
			{'L', 'R', 'U', 'D'}
			};
			
			System.out.println(isDestinationReachable(grid, 0, 0, 2, 2));
		
 	}

}
