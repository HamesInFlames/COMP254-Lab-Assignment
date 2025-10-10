package exercise3;

public
package exercise3;

public class Main implements Cloneable {
    private Node<String> tail;
    private int size;

    public void addLast(String x) {
        Node<String> n = new Node<>(x);
        if (tail == null) { tail = n; n.next = n; }
        else { n.next = tail.next; tail.next = n; tail = n; }
        size++;
    }

    public void print() {
        if (tail == null) { System.out.println(); return; }
        Node<String> h = tail.next, c = h;
        do { System.out.print(c.data + " "); c = c.next; } while (c != h);
        System.out.println();
    }

    @Override
    public Main clone() {
        try {
            Main other = (Main) super.clone();
            if (tail == null) { other.tail = null; other.size = 0; return other; }
            Node<String> h = tail.next, c = h;
            Node<String> newHead = new Node<>(c.data), prev = newHead;
            c = c.next;
            while (c != h) {
                Node<String> nn = new Node<>(c.data);
                prev.next = nn; prev = nn; c = c.next;
            }
            prev.next = newHead;
            other.tail = prev; other.size = size;
            return other;
        } catch (CloneNotSupportedException e) { throw new AssertionError(e); }
    }

    public static void main(String[] args) {
        Main C = new Main();
        C.addLast("A"); C.addLast("B"); C.addLast("C");
        C.print();               // A B C
        Main D = C.clone();
        D.print();               // A B C
        C.addLast("D");
        C.print();               // A B C D
        D.print();               // A B C
    }
}{

}
