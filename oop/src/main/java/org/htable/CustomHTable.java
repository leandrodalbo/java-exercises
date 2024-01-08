package org.htable;

import java.security.Key;

public class CustomHTable<K, V> {

    private final Entry[] entries;
    private final Integer size;

    public CustomHTable(Integer size) {
        this.size = size;
        this.entries = new Entry[size];
    }


    public void put(K key, V value) {
        if (entries[this.hash(key)] == null) {
            entries[this.hash(key)] = new Entry(key, value, null);
        } else {
            Entry entry = entries[this.hash(key)];

            while (entry.next != null) {
                entry = entry.next;
            }

            entry.next = new Entry(key, value, null);
        }
    }

    public V get(K key) {
        if (entries[this.hash(key)] != null) {
            Entry entry = entries[this.hash(key)];

            while (entry.next != null && entry.key != key) {
                entry = entry.next;
            }

            return (V) entry.value;
        }
        return null;
    }

    public Integer getSize() {
        return size;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % size);
    }

    private class Entry<K, V> {
        private final K key;

        private final V value;

        private Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry getNext() {
            return next;
        }
    }

}
