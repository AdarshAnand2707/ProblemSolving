package backTrackingAndRecurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class wordBreak {
	
	public static List<String> getWordBreak (String str, HashSet<String> dictionary) {
		if (str == null || str.length() == 0) {
			return null;
		}
		State[] memo = new State[str.length()];
		Arrays.fill(memo, State.Unvisited);
		List<String> result = new ArrayList<>();
		if (canFormWord(str, 0, memo, result, dictionary)) {
			return result;
		}
		return null;
	}
	
	public static boolean canFormWord(String str, int startIndex, State[] memo, List<String> result, HashSet<String> dict) {
		if(startIndex == str.length()) {
			return true;
		}
		if (memo[startIndex] == State.Not_Found) {
			return false;
		}
		for(int i = startIndex; i < str.length(); i++) {
			String candidate = str.substring(startIndex, i+1);
			if (dict.contains(candidate)) {
				result.add(candidate);
				if (canFormWord(str, i+1, memo, result, dict)) {
					return true;
				} else {
					result.remove(result.size() - 1);
					memo[i] = State.Not_Found;
				}
			}
		}
		return false;
	}
	
	public static int countNumberOfSentences(String str, HashSet<String> dict) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int[] memo = new int[str.length()+1];
		Arrays.fill(memo, -1);
		memo[str.length()] = 1;
		return countNumberOfSentences(str, dict, 0, memo);	
	}
	
	public static int countNumberOfSentences(String str, HashSet<String> dict, int start, int[] memo) {
		if (memo[start] != -1) {
			return memo[start];
		}
		int totalCount = 0;
		for (int i = start; i < str.length(); i++) {
			String candidate = str.substring(start, i+1);
			if (dict.contains(candidate)) {
				totalCount += countNumberOfSentences(str, dict, i+1, memo);
			}
		}
		memo[start] = totalCount;
		return totalCount;
	}
	
	public enum State {
		Unvisited,
		Not_Found
	}
	
	public static void main(String[] args) {
		String s = "ilikesamsungmobile";
        List<String> dict = Arrays.asList("i", "like", "sam", "sung",
                           "samsung", "mobile", "ice",
                            "and", "cream", "icecream",
                            "man", "go", "mango");
        HashSet<String> dictSet = new HashSet<>(dict);
        List<String> result = getWordBreak(s, dictSet);
        for (String str: result) {
        	System.out.print(str + " ");
        }
        System.out.println();
        System.out.println(countNumberOfSentences(s, dictSet));
	}

}
