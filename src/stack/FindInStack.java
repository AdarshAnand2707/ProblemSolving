package stack;

import java.util.Stack;

public class FindInStack {
	
	public static boolean find (int target, Stack<Integer> s) {
		if (s == null) {
			return false;
		}
		Stack<Integer> temp = new Stack<>();
		boolean found = false;
		while (!s.isEmpty()) {
			if (s.peek() == target) {
				found = true;
				break;
			}
			temp.push(s.pop());
		}
		while (!temp.isEmpty()) {
			s.push(temp.pop());
		}
		return found;
	}
	
	public static void main (String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		s.push(0);
		System.out.println(find (3, s));
		System.out.println(find (6, s));
	}

}
