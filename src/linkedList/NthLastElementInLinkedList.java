package linkedList;

public class NthLastElementInLinkedList {
	
	public static Node<Integer> getNthLastElement (LinkedList<Integer> linkedList, int n) {
		Node<Integer> slow = linkedList.head;
		Node<Integer> fast = linkedList.get(n+1);
		while(fast != null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}
		return slow;
 	}

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1, null);
		Node<Integer> node2 = new Node<Integer>(2, null);
		Node<Integer> node3 = new Node<Integer>(3, null);
		Node<Integer> node4 = new Node<Integer>(4, null);
		Node<Integer> node5 = new Node<Integer>(5, null);
		Node<Integer> node6 = new Node<Integer>(6, null);
		Node<Integer> node7 = new Node<Integer>(7, null);
		Node<Integer> node8 = new Node<Integer>(8, null);
		LinkedList<Integer> input = new LinkedList<Integer>();
		input.append(node1);
		input.append(node2);
		input.append(node3);
		input.append(node4);
		input.append(node5);
		input.append(node6);
		input.append(node7);
		input.append(node8);
		System.out.println(getNthLastElement(input, 3));
	}

}
