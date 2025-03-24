package stack;

import java.util.Stack;

public class QueueUsingStack <T> {
	
	Stack<T> s1;
	Stack<T> s2;
	
	public QueueUsingStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public void enqueue(T data) {
		s1.push(data);
	}
	
	public T dequeue() throws EmptyQueueException {
		if (s2.isEmpty()) {
			flushToS2();
		}
		if (s2.isEmpty()) {
			throw new EmptyQueueException();
		}
		return s2.pop();
	}
	
	private void flushToS2() {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
	}
 
	public static void main(String[] args) throws EmptyQueueException {
		QueueUsingStack<Integer> q = new QueueUsingStack<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}
	

}

class EmptyQueueException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmptyQueueException() {}
	
}