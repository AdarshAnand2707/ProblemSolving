package linkedList;

public class ReverseLinkedList {
	
	public static void reverse (LinkedList<Integer> list) {
		Node<Integer> current = list.head, previous = null;
		while (current != null) {
			Node<Integer> next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		list.head = previous;
		list.tail = null;
	}

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1, null);
		Node<Integer> node2 = new Node<Integer>(2, null);
		Node<Integer> node3 = new Node<Integer>(3, null);
		Node<Integer> node4 = new Node<Integer>(4, null);
		Node<Integer> node5 = new Node<Integer>(5, null);
		Node<Integer> node6 = new Node<Integer>(6, null);
		LinkedList<Integer> input = new LinkedList<Integer>();
		input.append(node1);
		input.append(node2);
		input.append(node3);
		input.append(node4);
		input.append(node5);
		input.append(node6);
		System.out.println(input);
		reverse(input);
		System.out.println(input);
	}

}
