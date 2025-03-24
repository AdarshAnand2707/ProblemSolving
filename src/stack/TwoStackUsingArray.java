package stack;

import java.lang.reflect.Array;

public class TwoStackUsingArray<T> {
	
	T[] arr;
	int s1;
	int s2;
	
	@SuppressWarnings("unchecked")
	public TwoStackUsingArray (Class<T> clazz, int size) {
		arr =  (T[]) Array.newInstance(clazz, size);
		s1 = 0;
		s2 = arr.length -1;
	}
	
	public void push (int stackNumber, T data) throws StackFullException {
		if (stackNumber != 1 && stackNumber != 2) {
			throw new IllegalArgumentException("Invalid Stack Number");
		}
		if (s1 > s2) {
			throw new StackFullException();
		}
		if (stackNumber == 1) {
			arr[s1++] = data;
		} else {
			arr[s2--] = data;
		}
	}
	
	public T pop (int stackNumber) throws StackEmptyException {
		if (stackNumber != 1 && stackNumber != 2) {
			throw new IllegalArgumentException("Invalid Stack Number");
		}
		if (stackNumber == 1 && s1 > 0) {
			return arr[--s1];
		} else  if (stackNumber == 2 && s2 < arr.length - 1) {
			return arr[++s2];
		}
		throw new StackEmptyException();
	}

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		TwoStackUsingArray<Integer> s = new TwoStackUsingArray<>(Integer.class, 10);
		s.push(1, 5);
		s.push(1, 4);
		s.push(1, 3);
		s.push(1, 2);
		s.push(2, 9);
		s.push(2, 8);
		s.push(2, 7);
		s.push(2, 6);
		System.out.println(s.pop(1));
		System.out.println(s.pop(1));
		System.out.println(s.pop(1));
		System.out.println(s.pop(2));
		System.out.println(s.pop(2));
		System.out.println(s.pop(2));

	}

}

class StackFullException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StackFullException() {}
	
}

class StackEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StackEmptyException() {}
	
}