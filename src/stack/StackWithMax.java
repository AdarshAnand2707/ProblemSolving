package stack;

import java.util.Stack;

public class StackWithMax<T extends Comparable<T>> {
	Stack<T> main;
	Stack<T> max;

	public StackWithMax() {
		main = new Stack<>();
		max = new Stack<>();
	}

	public void push(T data) {
		main.push(data);
		if (max.isEmpty() || data.compareTo(max.peek()) >= 0) {
			max.push(data);
		}
	}
	
	public T max() throws StackEmptyException {
		if (max.isEmpty()) {
			throw new StackEmptyException();
		}
		return max.peek();
	}
	
	public T pop () throws StackEmptyException {
		if (main.isEmpty()) {
			throw new StackEmptyException();
		}
		T item = main.pop();
		if (item.equals(max.peek())) {
			max.pop();
		}
		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}