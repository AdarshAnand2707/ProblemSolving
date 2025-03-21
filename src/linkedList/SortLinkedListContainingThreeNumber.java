package linkedList;

public class SortLinkedListContainingThreeNumber {
	
	public static LinkedList<Integer> sortList (LinkedList<Integer> input) {
		LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();

		Node<Integer> current = input.head;
		while(current != null) {
			switch(current.data) {
				case 0 : linkedList0.append(current); break;
				case 1 : linkedList1.append(current); break;
				case 2 : linkedList2.append(current); break;
				default: throw new IllegalArgumentException(
						"Invalid value: " + current.getData());
			}
			current = current.next;
		}
		if(linkedList0.tail != null) {
			linkedList0.tail.next = null;
		}
		if(linkedList1.tail != null) {
			linkedList1.tail.next = null;
		}
		if(linkedList2.tail != null) {
			linkedList2.tail.next = null;
		}
		LinkedList<Integer> result = new LinkedList<Integer>();
		result.append(linkedList0);
		result.append(linkedList1);
		result.append(linkedList2);
		return result;
	}
	

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1, null);
		Node<Integer> node2 = new Node<Integer>(0, null);
		Node<Integer> node3 = new Node<Integer>(2, null);
		Node<Integer> node4 = new Node<Integer>(1, null);
		Node<Integer> node5 = new Node<Integer>(2, null);
		Node<Integer> node6 = new Node<Integer>(1, null);
		LinkedList<Integer> input = new LinkedList<Integer>();
		input.append(node1);
		input.append(node2);
		input.append(node3);
		input.append(node4);
		input.append(node5);
		input.append(node6);
		LinkedList<Integer> result = sortList(input);
		System.out.println(result);
		
	}

}
