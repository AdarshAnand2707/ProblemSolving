package binarySearch;

public class SquareRootOFInteger {
	
	public static int floorOfSquareRoot(int x) {
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		int start = 0, end = x/2;
		while (start <= end) {
			int mid = start + (end - start)/2;
			if (square(mid) > x) {
				end = mid - 1;
			} else if (square(mid) < x) {
				if(square(mid+1) > x) {
					return mid;
				}
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int square(int x) {
		return x*x;
	}

	public static void main(String[] args) {
		System.out.println(floorOfSquareRoot(4));
		System.out.println(floorOfSquareRoot(11));

	}

}
