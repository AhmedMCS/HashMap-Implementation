package HashMap;

import java.util.StringJoiner;

public class HashMap<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
    }

    private int size = 10;
    private HashNode<K, V>[] map;

    public HashMap() {
        map = new HashNode[size];
    }

    public void put(K key, V value) {
        int hashIndex = Math.abs(key.hashCode()) % size;
        HashNode<K, V> entry = map[hashIndex];

        if (entry == null) {
            map[hashIndex] = new HashNode<K, V>(key, value);
            return;
        }

        while (entry.next != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.next;
        }

        if (entry.getKey().equals(key)) {
            entry.setValue(value);
            return;
        }
        entry.next = new HashNode<K, V>(key, value);
    }

    public V get(K key) {
        int hashIndex = Math.abs(key.hashCode()) % size;
        HashNode<K, V> entry = map[hashIndex];

        if (entry == null) {
            return null;
        }

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public HashNode<K, V> remove(K key) {
        int hashIndex = Math.abs(key.hashCode()) % size;
        HashNode<K, V> entry = map[hashIndex];

        if (entry == null) {
            return null;
        }

        if (entry.getKey().equals(key)) {
            map[hashIndex] = entry.next;
            entry.next = null;
            return entry;
        }

        HashNode<K, V> prev = entry;
        entry = entry.next;

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                prev.next = entry.next;
                entry.next = null;
                return entry;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (int i = 0; i < size; i++) {
            HashNode<K, V> entry = map[i];
            while (entry != null) {
                sj.add(entry.getKey() + "=" + entry.getValue());
                entry = entry.next;
            }
        }
        return sj.toString();
    }
}
