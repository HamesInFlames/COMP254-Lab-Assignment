package Exercise3;

/**
 * Seonghyun Kim - COMP254 Lab 4
 *
 * Exercise 3:
 * Implement concatenate(LinkedQueue<E> Q2) that appends all elements
 * from Q2 to the end of Q1 in O(1) time.
 */
public class LinkedQueue<E> {

    // Node class
    private static class Node<E> {
        E element;
        Node<E> next;
        Node(E e, Node<E> n) { element = e; next = n; }
    }

    private Node<E> head = null, tail = null;
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else tail.next = newest;
        tail = newest;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E answer = head.element;
        head = head.next;
        size--;
        if (isEmpty()) tail = null;
        return answer;
    }

    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2.isEmpty()) return;

        if (this.isEmpty()) {
            this.head = Q2.head;
            this.tail = Q2.tail;
        } else {
            this.tail.next = Q2.head;
            this.tail = Q2.tail;
        }
        this.size += Q2.size;

        // Empty Q2
        Q2.head = Q2.tail = null;
        Q2.size = 0;
    }

    public void printQueue() {
        Node<E> walk = head;
        while (walk != null) {
            System.out.print(walk.element + " ");
            walk = walk.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> Q1 = new LinkedQueue<>();
        LinkedQueue<Integer> Q2 = new LinkedQueue<>();

        Q1.enqueue(1);
        Q1.enqueue(2);
        Q1.enqueue(3);

        Q2.enqueue(4);
        Q2.enqueue(5);

        System.out.println("Queue 1 before: ");
        Q1.printQueue();

        System.out.println("Queue 2 before: ");
        Q2.printQueue();

        Q1.concatenate(Q2);

        System.out.println("\nQueue 1 after concatenate: ");
        Q1.printQueue();

        System.out.println("Queue 2 after concatenate (should be empty): ");
        Q2.printQueue();
    }
}
