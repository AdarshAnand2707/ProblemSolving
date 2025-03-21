package linkedList;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Uses java's LinkedHashMap
 */
public class LRUCacheII<K, V> extends LinkedHashMap<K, V> {
	
	private static final long serialVersionUID = 1L;
	int capacity;
	
	public LRUCacheII (int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}
	
	public V read (K key) {
		if (!this.containsKey(key)) {
			return null;
		}
		return this.get(key);
	}
	
	public void write (K key, V value) {
		this.put(key, value);
	}
	
	// This methods help to implement eviction policy to remove the last accessed element
	@Override
	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > this.capacity;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		this.values().forEach((value) -> {
			builder.append(value);
			builder.append(" ");
		});
		return builder.toString();
	}

	public static void main(String[] args) {
		LRUCacheII<Integer, String> cache = new LRUCacheII<Integer, String>(5);
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

}
