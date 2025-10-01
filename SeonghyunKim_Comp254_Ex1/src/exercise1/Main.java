package exercise1;
public class Main {
    private Node<Integer> head, tail;
    private int size;

    public Main() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
    }

    public void add(int x) {
        Node<Integer> n = new Node<>(x, tail.prev, tail);
        tail.prev.next = n; tail.prev = n; size++;
    }

    public void print() {
        for (Node<Integer> c = head.next; c != tail; c = c.next)
            System.out.print(c.data + " ");
        System.out.println();
    }

    public static Main join(Main a, Main b) {
        if (a.size == 0) return b;
        if (b.size == 0) return a;
        a.tail.prev.next = b.head.next;
        b.head.next.prev = a.tail.prev;
        a.tail = b.tail;
        a.size += b.size;
        return a;
    }

    public static void main(String[] args) {
        Main L1 = new Main(), L2 = new Main();
        L1.add(1); L1.add(2); L1.add(3);
        L2.add(4); L2.add(5); L2.add(6);
        join(L1, L2).print(); // 1 2 3 4 5 6
    }
}
