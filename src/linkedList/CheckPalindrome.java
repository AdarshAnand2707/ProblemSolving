package linkedList;

public class CheckPalindrome {
	
	public static boolean isPalindrome (LinkedList<String> list) {
		if (list == null || list.head == null) {
			return false;
		}
		Node<String> mid = findMid(list.head);
		Node<String> last = reverse(mid);
		Node<String> start = list.head, end = last;
		while (start != null && end != null) {
			if (start.getData() != end.getData()) {
				return false;
			}
			start = start.getNext();
			end = end.getNext();
		}
		return true;
	}
	
	public static Node<String> findMid (Node<String> head) {
		Node<String> fast = head, slow = head;
		while (fast.getNext() != null) {
			fast = fast.getNext();
			if (fast.getNext() == null) {
				break;
			}
			fast = fast.getNext();
			slow = slow.getNext();
		}
		return slow;
	}
	
	public static Node<String> reverse (Node<String> head) {
		Node<String> prev = null, curr = head;
		while (curr != null) {
			Node<String> next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		Node<String> node1 = new Node<String>("A", null);
		Node<String> node2 = new Node<String>("B", null);
		Node<String> node3 = new Node<String>("C", null);
		Node<String> node4 = new Node<String>("B", null);
		Node<String> node5 = new Node<String>("A", null);
		LinkedList<String> input = new LinkedList<String>();
		input.append(node1);
		input.append(node2);
		input.append(node3);
		input.append(node4);
		input.append(node5);
		System.out.println(isPalindrome(input));
	}

}
