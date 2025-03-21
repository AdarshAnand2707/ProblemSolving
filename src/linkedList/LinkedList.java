package linkedList;

public class LinkedList <T extends Comparable<T>> {
	
	Node<T> head;
	Node<T> tail;
	
	public LinkedList() {
		this(null, null);
	}
	
	public LinkedList(Node<T> head, Node<T> tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	public Node<T> get (int n) {
		Node<T> node = head;
		for (int i = 0; i < n - 1; i++) {
			if (node != null) {
				node = node.next;
			} else {
				throw new IndexOutOfBoundsException(
						"No node at Index "+ n);
			}
		}
		if (node == null) {
			throw new IndexOutOfBoundsException(
					"No node at Index "+ n);
		}
		return node;
	}
	
	public void append(Node<T> n) {
		if (head == null) {
			head = n;
		} else {
			tail.setNext(n);
		}
		tail = n;
	}
	
	public void append (LinkedList<T> toAppend) {
		if (toAppend == null || toAppend.head == null) {
			return;
		}
		this.append(toAppend.head);
		this.tail = toAppend.tail;
	}
	
	public void delete (Node<T> n) {
		if (n == null) {
			return;
		}
		if (n == this.head) {
			this.delete(n, null);
		}
		Node<T> prev = head;
		Node<T> current = head.getNext();
		while (current != null) {
			if (current.equals(n)) {
				break;
			}
			prev = current;
			current = current.getNext();
		}
		this.delete(n, prev);
	}
	
	public void delete (Node<T> n, Node<T> prev) {
		if (n == null) {
			return;
		}
		if (n == this.head) {
			this.head = n.next;
		}
		if (n == this.tail ) {
			this.tail = prev;
		}
		if (prev != null) {
			prev.setNext(n.getNext());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node<T> current = head;
		while(current != null) {
			builder.append(current.getData());
			builder.append(" ");
			current = current.getNext();
		}
		return builder.toString();
	}

}
