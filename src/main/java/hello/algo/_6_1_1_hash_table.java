package hello.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _6_1_1_hash_table {
    public static void main(String[] args) {
        ArrayHashMap a = new ArrayHashMap();
        a.put(123, "toi lalai");

        System.out.println(a.get(123));
    }
}

/* Key-value pair */
class Pair {
    public int key;
    public String val;

    public Pair(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

/* Hash table based on array implementation */
class ArrayHashMap {
    private List<Pair> buckets;

    public ArrayHashMap() {
        // Initialize an array, containing 100 buckets
        buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
    }

    /* Hash function */
    private int hashFunc(int key) {
        int index = key % 100;
        return index;
    }

    /* Query operation */
    public String get(int key) {
        int index = hashFunc(key);
        Pair pair = buckets.get(index);
        if (pair == null)
            return null;
        return pair.val;
    }

    /* Add operation */
    public void put(int key, String val) {
        Pair pair = new Pair(key, val);
        int index = hashFunc(key);
        buckets.set(index, pair);
    }

    /* Remove operation */
    public void remove(int key) {
        int index = hashFunc(key);
        // Set to null, indicating removal
        buckets.set(index, null);
    }

    /* Get all key-value pairs */
    public List<Pair> pairSet() {
        List<Pair> pairSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                pairSet.add(pair);
        }
        return pairSet;
    }

    /* Get all keys */
    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                keySet.add(pair.key);
        }
        return keySet;
    }

    /* Get all values */
    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                valueSet.add(pair.val);
        }
        return valueSet;
    }

    /* Print hash table */
    public void print() {
        for (Pair kv : pairSet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
    }
}