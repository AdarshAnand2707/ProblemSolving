package linkedList;

public class DetectCycleInLinkedList {
	
	public static boolean detctCycle(Node<Integer> head) {
		Node<Integer> fast = head, slow = head;
		while (fast != null) {
			fast = fast.getNext();
			if (fast == slow) {
				return true;
			}
			if (fast != null) {
				fast = fast.getNext();
				if (fast == slow) {
					return true;
				}
			}
			slow = slow.getNext();
		}
		return false;
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
		node8.next = node3;
		input.tail = node8;
		System.out.println(detctCycle(input.head));

	}

}
