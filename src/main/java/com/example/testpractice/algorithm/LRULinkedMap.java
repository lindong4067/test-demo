package com.example.testpractice.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMap来实现LRU Cache
 */
public class LRULinkedMap<K, V> {
    private LinkedHashMap<K,V> cacheMap;

    public LRULinkedMap(int cacheSize) {
        cacheMap = new LinkedHashMap<K, V>(cacheSize, 0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cacheSize + 1 == cacheMap.size();
            }
        };
    }

    public void put(K key,V value){
        cacheMap.put(key,value) ;
    }

    public V get(K key){
        return cacheMap.get(key) ;
    }

    public Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<>(cacheMap.entrySet());
    }

    public static void main(String[] args) {
        LRULinkedMap<Integer, Integer> lruLinkedMap = new LRULinkedMap<>(16);
        lruLinkedMap.put(1, 1);
        lruLinkedMap.put(2, 2);
        lruLinkedMap.put(3, 3);
        lruLinkedMap.put(4, 4);
        lruLinkedMap.put(5, 5);
        lruLinkedMap.put(6, 6);
        System.out.println(lruLinkedMap.getAll());

    }
}
