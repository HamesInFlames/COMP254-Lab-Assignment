package exercise1;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        T data; Node<T> prev, next;
        Node(T d, Node<T> p, Node<T> n) { data = d; prev = p; next = n; }
    }

    private Node<T> head, tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
    }

    public void add(T data) {
        Node<T> n = new Node<>(data, tail.prev, tail);
        tail.prev.next = n; tail.prev = n; size++;
    }

    public void print() {
        for (Node<T> c = head.next; c != tail; c = c.next)
            System.out.print(c.data + " ");
        System.out.println();
    }

    public static <T> DoublyLinkedList<T> join(DoublyLinkedList<T> a, DoublyLinkedList<T> b) {
        if (a.size == 0) return b;
        if (b.size == 0) return a;
        a.tail.prev.next = b.head.next;
        b.head.next.prev = a.tail.prev;
        a.tail = b.tail;
        a.size += b.size;
        return a;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> L1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> L2 = new DoublyLinkedList<>();
        L1.add(1); L1.add(2); L1.add(3);
        L2.add(4); L2.add(5); L2.add(6);
        join(L1, L2).print(); // 1 2 3 4 5 6
    }
}
