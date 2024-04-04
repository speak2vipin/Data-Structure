package com.vipin.algorithm.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class MRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_ENTRIES = 10; // Adjust the cache size as needed

    public MRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    public static void main(String[] args) {
        MRUCache<Integer, String> cache = new MRUCache<>();

        // Adding items to the cache
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        // Accessing an item (moves it to the MRU position)
        System.out.println(cache.get(2));

        // Adding more items, potentially causing eviction
        cache.put(4, "Four");
        cache.put(5, "Five");

        // Displaying the current contents of the cache
        System.out.println("Current cache contents: " + cache);
    }
}

