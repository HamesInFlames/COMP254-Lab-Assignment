package Exercise3;

import java.util.ArrayList;

/*
  Seonghyun Kim - COMP254 Lab 5
 
  Exercise 3:
  Implement a recursive upheap for a HeapPriorityQueue.
  Upheap restores the heap order after inserting a new key.
 */
public class RecursiveUpheap {

    static class HeapPriorityQueue<K extends Comparable<K>> {
        ArrayList<K> heap = new ArrayList<>();

        public void insert(K key) {
            heap.add(key);
            upheap(heap.size() - 1);
        }

        private void swap(int i, int j) {
            K temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        /*
          Recursive upheap:
          - Compare node with parent.
          - If smaller, swap and recurse upward.
         */
        private void upheap(int j) {
            if (j == 0) return; // reached root
            int parent = (j - 1) / 2;
            if (heap.get(j).compareTo(heap.get(parent)) < 0) {
                swap(j, parent);
                upheap(parent); // recursion
            }
        }

        public void printHeap() {
            System.out.println(heap);
        }
    }

    public static void main(String[] args) {
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();
        pq.insert(40);
        pq.insert(50);
        pq.insert(20);
        pq.insert(30);
        pq.insert(10);

        System.out.println("Heap after recursive upheaps:");
        pq.printHeap();
    }
}
