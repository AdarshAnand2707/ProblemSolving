package backTrackingAndRecurssion;

public class PhoneNumberMnemonics {
	
	public static void printWords(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		char[] buffer = new char[arr.length];
		printwordHelper(arr, 0, buffer, 0);
	}
	
	public static void printwordHelper(int[] arr, int start, char[] buffer, int bufferIndex) {
		if (bufferIndex == buffer.length) {
			printWordsBuffer(buffer);
			return;
		}
		if (start == arr.length) {
			return;
		}
		char[] letters = getLetters(arr[start]);
		if (letters.length == 0) {
			printwordHelper(arr, start+1, buffer, bufferIndex);
		}
		for(int i = 0; i < letters.length; i++) {
			buffer[bufferIndex] = letters[i];
			printwordHelper(arr, start+1, buffer, bufferIndex+1);
		}
	}
	
	public static char[] getLetters (int num) {
		switch(num) {
		case 0: return new char[]{};
		case 1: return new char[]{};
		case 2: return new char[]{'a', 'b','c'};
		case 3: return new char[]{'d', 'e','f'};
		case 4: return new char[]{'g', 'h','i'};
		case 5: return new char[]{'j', 'k','l'};
		case 6: return new char[]{'m', 'n','o'};
		case 7: return new char[]{'p', 'q','r','s'};
		case 8: return new char[]{'t','u', 'v'};
		case 9: return new char[]{'w','x', 'y', 'z'};
		}
		throw new IllegalArgumentException("Invalid Digit " + num);
	}
	
	public static void printWordsBuffer (char[] buffer) {
		for (int i =0; i < buffer.length;  i++) {
			System.out.print(buffer[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] num = new int[] {4, 5, 6};
		printWords(num);
	}

}
