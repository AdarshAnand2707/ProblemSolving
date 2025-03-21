package linkedList;

public class OddEvenNodeList {
	
	@SuppressWarnings({ "unchecked" })
	public static LinkedList<Integer>[] getOddEvenNodeList (LinkedList<Integer> input) {
		LinkedList<Integer> oddList = new LinkedList<Integer>();
		LinkedList<Integer> evenList = new LinkedList<Integer>();
		LinkedList<Integer>[] result = new LinkedList[2];
		Node<Integer> current = input.head;
		int index = 0;
		while(current != null) {
			index++;
			LinkedList<Integer> destination = index % 2 == 0 ? evenList : oddList;
			destination.append(current);
			current = current.getNext();
		}
		if (evenList.tail != null) {
			evenList.tail.next = null;
		}
		if (oddList.tail != null) {
			oddList.tail.next = null;
		}
		result[0] = oddList;
		result[1] = evenList;
		return result;
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
		LinkedList<Integer>[] result = getOddEvenNodeList(input);
		for (LinkedList<Integer> res: result) {
			System.out.println(res);
		}
		
	}

}
