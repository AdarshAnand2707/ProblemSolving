package linkedList;

import java.util.HashMap;

/**
 * This uses custom Linked hash map
 * @param <K>
 * @param <V>
 */
public class LRUCache <K, V> {
	
	HashMap<K ,Node<K, V>> map;
	
	Node<K, V> head;
	Node<K, V> tail;
	
	int capacity;
	
	public LRUCache(int capacity) {
		this.map = new HashMap<>();
		this.capacity = capacity;
	}
	
	public V read (K key) {
		Node<K, V> node = map.get(key);
		if (node == null) {
			return null;
		}
		remove(key);
		add(node.getKey(), node.getValue());
		return node.getValue();
	}
	
	public void write (K key, V value) {
		if (map.size() == this.capacity) {
			remove(head.getKey());
		}
		add(key, value);
	}
	
	private void add (K key, V value) {
		Node<K, V> newNode = new Node<>(key, value);
		appendToLinkedList(newNode);
		map.put(key, newNode);
	}
	
	private void appendToLinkedList(Node<K, V> node) {
		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.setNext(node);
			node.setPrev(tail);
		}
		tail = node;
	}
	
	private void remove (K key) {
		if (!map.containsKey(key)) {
			return;
		}
		Node<K, V> toBeRomved = map.get(key);
		removeFromLinkedList(toBeRomved);
		map.remove(key);
	}
	
	private void removeFromLinkedList(Node<K, V> toBeRemoved) {
		if(toBeRemoved.getPrev() != null) {
			toBeRemoved.getPrev().setNext(toBeRemoved.getNext());
		}
		if(toBeRemoved.getNext() != null) {
			toBeRemoved.getNext().setPrev(toBeRemoved.getPrev());
		}
		if (toBeRemoved == this.head) {
			this.head = toBeRemoved.getNext();
		}
		if(toBeRemoved == this.tail) {
			this.tail = toBeRemoved.getPrev();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node<K, V> current = head;
		while(current != null) {
			builder.append(current.getValue());
			builder.append(" ");
			current = current.getNext();
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> cache = new LRUCache<Integer, String>(5);
		cache.write(1, "A");
		cache.write(2, "B");
		cache.write(3, "C");
		cache.write(4, "D");
		cache.write(5, "E");
		System.out.println(cache);
		cache.read(4);
		System.out.println(cache);
		cache.write(6,"F");
		System.out.println(cache);
		
	}
	
	class Node <L, M> {
		Node<L, M> next;
		Node<L, M> prev;
		L key;
		M value;
		
		Node (L key, M value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Node<L, M> getNext() {
			return next;
		}

		public void setNext(Node<L, M> next) {
			this.next = next;
		}

		public Node<L, M> getPrev() {
			return prev;
		}

		public void setPrev(Node<L, M> prev) {
			this.prev = prev;
		}

		public L getKey() {
			return key;
		}

		public void setKey(L key) {
			this.key = key;
		}

		public M getValue() {
			return value;
		}

		public void setValue(M value) {
			this.value = value;
		}
	}

}
