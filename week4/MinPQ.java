package week4;

import java.util.HashMap;

/**
 * Created by vnagarajan on 7/19/16.
 */
public class MinPQ<Key extends Comparable<Key>> {
    private int size = 0;
    private Key[] keys = null;
    private HashMap<Key, Integer> map; //maps Key to location in keys array

    public MinPQ(int cap) {
        keys = (Key[]) new Comparable[cap + 1];
        map = new HashMap<>();
    }

    public void insert(Key key) {
        if (key == null) {
            throw new RuntimeException("Cannot insert null key");
        }
        keys[++size] = key;
        map.put(key, size);
        bubbleUp(size);
    }

    public Key deleteMin() {
        Key key = keys[1];
        keys[1] = keys[size];
        map.put(keys[1], 1);
        map.remove(key);
        keys[size] = null;
        size--;
        bubbleDown(1);
        return key;
    }

    public void deleteKey(Key key) {
        int index = map.get(key);
        keys[index] = keys[size];
        map.put(keys[index], index);
        map.remove(key);
        keys[size] = null;
        size--;
        bubbleDown(index);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void bubbleUp(int index) {
        while (index >= 1) {
            int parentIndex = index / 2;
            if (parentIndex < 1) {
                return;
            }
            if (keys[parentIndex].compareTo(keys[index]) > 0) {
                //swap parent and index since parent is greater than child
                Key temp = keys[parentIndex];
                keys[parentIndex] = keys[index];
                keys[index] = temp;
                map.put(keys[parentIndex], parentIndex);
                map.put(keys[index], index);
                index = parentIndex;
            } else {
                return;
            }
        }
    }

    private void bubbleDown(int index) {
        int leftChildIndex = 2 * index;
        while (leftChildIndex <= size) {
            int smallerIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex <= size) {
                if (keys[leftChildIndex].compareTo(keys[rightChildIndex]) > 0) {
                    smallerIndex = rightChildIndex;
                }
            }
            if (keys[smallerIndex].compareTo(keys[index]) < 0) {
                Key temp = keys[smallerIndex];
                keys[smallerIndex] = keys[index];
                keys[index] = temp;
                map.put(keys[smallerIndex], smallerIndex);
                map.put(keys[index], index);
                index = smallerIndex;
                leftChildIndex = 2 * index;
            } else {
                return;
            }
        }
    }
}
