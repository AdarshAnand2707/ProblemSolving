package linkedList;

public class MedianInLinkedList {

	public static Node<Integer> getMedian (Node<Integer> head) {
		Node<Integer> fast = head, slow = head;
		while(fast.getNext() != null) {
			fast = fast.getNext();
			if (fast.getNext() != null) {
				fast = fast.getNext();
				slow = slow.getNext();
			}
		}
		return slow;
	}
	
	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1, null);
		Node<Integer> node2 = new Node<Integer>(2, null);
		Node<Integer> node3 = new Node<Integer>(3, null);
		Node<Integer> node4 = new Node<Integer>(4, null);
		Node<Integer> node5 = new Node<Integer>(5, null);
		LinkedList<Integer> input = new LinkedList<Integer>();
		input.append(node1);
		input.append(node2);
		input.append(node3);
		input.append(node4);
		input.append(node5);
		System.out.println(getMedian(input.head));
	}

}
