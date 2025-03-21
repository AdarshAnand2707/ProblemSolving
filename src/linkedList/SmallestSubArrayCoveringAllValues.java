package linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SmallestSubArrayCoveringAllValues {
	
	public String getShortestSubString(String doc, HashSet<String> wordSet) {
		String result = null;
		HashMap<String, Node> nodeMap = new HashMap<>();
		LinkedList linkedList = new LinkedList();
		WordIterator iter = new WordIterator(doc);
		while(iter.hasNext()) {
			WordIndex wordIndex = iter.next();
			String word = wordIndex.getWord();
			if (!wordSet.contains(word)) {
				continue;
			}
			if (nodeMap.containsKey(word)) {
				Node toDelete = nodeMap.get(word);
				linkedList.remove(toDelete);
			}
			Node newNode = new Node(word, wordIndex.getIndex());
			linkedList.append(newNode);
			nodeMap.put(word, newNode);
			if (nodeMap.size() == wordSet.size()) {
				int startIndex = linkedList.head.getIndex();
				int endIndex = linkedList.tail.getIndex() +
						linkedList.tail.getWord().length() - 1;
				if (result == null || (endIndex - startIndex + 1) < result.length()) {
					result = doc.substring(startIndex, endIndex+1);
				}
			}
		}
		return result;
	}
	


	public static void main(String[] args) {
		String doc = "a set of words that is complete in itself, typically containing a subject and predicate,\n"
				+ "conveying a statement, question, exclamation, or command, and consisting of a main clause\n"
				+ "and sometimes one or more subordinate clauses";
		HashSet<String> wordSet = new HashSet<>();
		wordSet.add("and");
		wordSet.add("of");
		wordSet.add("one");
		SmallestSubArrayCoveringAllValues p = new SmallestSubArrayCoveringAllValues();
		System.out.println(p.getShortestSubString(doc, wordSet));
		String first_name = "Adarsh";
		String my_name = first_name;
		System.out.println("first_name "+ first_name + " my_name "+ my_name);
		first_name = "Anand";
		System.out.println("first_name "+ first_name + " my_name "+ my_name);

	}
	
	class LinkedList {
		Node head;
		Node tail;
		
		public LinkedList() {
			this.head = null;
			this.tail = null;
		}
		
		public void append (Node toAdd) {
			if (head == null) {
				head = toAdd;
			} else {
				tail.setNext(toAdd);
				toAdd.setPrev(tail);
			}
			tail = toAdd;
		}
		
		public void remove (Node toRemove) {
			if (toRemove == null) {
				return;
			}
			if (toRemove.getPrev() != null) {
				toRemove.getPrev().setNext(toRemove.getNext());;
			}
			if (toRemove.getNext() != null) {
				toRemove.getNext().setPrev(toRemove.getPrev());
			}
			if (toRemove == head) {
				this.head = toRemove.getNext();
			}
			if (toRemove == tail) {
				this.tail = toRemove.getPrev();
			}
		}
	}
	
	
	class WordIndex {
		
		String word;
		
		int index;
		
		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public WordIndex (String word, int index) {
			this.word = word;
			this.index = index;
		}
		
	}
	
	/*
	* In this iterator, the position variable will always be at the start of the next
	* word in the string.
	*/
	class WordIterator implements Iterator<WordIndex> {
		
		String str;
		
		int position;
		
		
		public WordIterator (String str) {
			this.str = str.trim();
			this.position =  0;
			advanceToNextAlphabet();
		}
		
		private void advanceToNextAlphabet() {
			while(position < str.length() && 
					!Character.isAlphabetic(str.charAt(position))) {
				position++;
			}
		}
		

		@Override
		public boolean hasNext() {
			return position < str.length();
		}

		@Override
		public WordIndex next() {
			if (!hasNext()) {
				return null;
			}
			int wordStartIndex = position;
			while (position < str.length() &&
					Character.isAlphabetic(str.charAt(position))) {
				position++;
			}
			int wordEndIndex = position - 1;
			advanceToNextAlphabet();
			return new WordIndex(
					str.substring(wordStartIndex, wordEndIndex+1),wordStartIndex);
		}
		
	}
	
	class Node {
		
		Node next;
		
		Node prev;
		
		String word;
		
		int index;
		
		public Node (String word, int index) {
			super();
			this.word = word;
			this.index = index;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Node getPrev() {
			return prev;
		}
		
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
		public String getWord() {
			return word;
		}
		
		public void setWord(String word) {
			this.word = word;
		}
		
		public int getIndex() {
			return index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
	}

}
