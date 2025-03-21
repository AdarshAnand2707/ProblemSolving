package linkedList;

public class Node<T extends Comparable<T>> {

	Node<T> next;
	T data;
	
	public Node(T data, Node<T> next) {
		super();
		this.next = next;
		this.data = data;
	}

	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
	
}
