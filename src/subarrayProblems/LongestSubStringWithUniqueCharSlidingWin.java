package subarrayProblems;

import java.util.HashMap;

public class LongestSubStringWithUniqueCharSlidingWin {
	
	public static int[] longestSubString (String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		int[] result = new int[] {0, 0};
		int start = 0, end = 0, maxSubStringLength = 1;;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put(str.charAt(0), 0);
		while (end < str.length() - 1) {
			end++;
			char currentChar = str.charAt(end);
			if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
				start = map.get(currentChar) + 1;
			}
			map.put(currentChar, end);
			if (end - start + 1 > maxSubStringLength) {
				result[0] = start;
				result[1] = end;
				maxSubStringLength =end - start +1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "whatwhywhere";
		int[] result = longestSubString(str);
		System.out.print(str.substring(result[0], result[1] + 1));

	}

}
