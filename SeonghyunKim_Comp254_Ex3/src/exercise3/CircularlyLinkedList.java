package exercise3;

public class CircularlyLinkedList<T> implements Cloneable {
    private Node<T> tail; // if not null, tail.next is head
    private int size;

    public void addLast(T x) {
        Node<T> n = new Node<>(x);
        if (tail == null) {
            tail = n;
            n.next = n;
        } else {
            n.next = tail.next;
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void print() {
        if (tail == null) {
            System.out.println();
            return;
        }
        Node<T> h = tail.next, c = h;
        do {
            System.out.print(c.data + " ");
            c = c.next;
        } while (c != h);
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    @Override
    public CircularlyLinkedList<T> clone() {
        try {
            CircularlyLinkedList<T> other = (CircularlyLinkedList<T>) super.clone();
            if (tail == null) {
                other.tail = null;
                other.size = 0;
                return other;
            }

            Node<T> h = tail.next, c = h;
            Node<T> newHead = new Node<>(c.data), prev = newHead;
            c = c.next;
            while (c != h) {
                Node<T> nn = new Node<>(c.data);
                prev.next = nn;
                prev = nn;
                c = c.next;
            }
            prev.next = newHead; // close the ring
            other.tail = prev;
            other.size = size;
            return other;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
