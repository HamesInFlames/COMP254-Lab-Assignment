package exercise2;

public class Main {
    private Node<Integer> head, tail;

    public Node<Integer> addLast(int x) {
        Node<Integer> n = new Node<>(x);
        if (head == null) head = tail = n;
        else { tail.next = n; tail = n; }
        return n;
    }

    public void print() {
        for (Node<Integer> c = head; c != null; c = c.next)
            System.out.print(c.data + " ");
        System.out.println();
    }

    private Node<Integer> prev(Node<Integer> t) {
        if (t == head) return null;
        for (Node<Integer> p = head; p != null; p = p.next)
            if (p.next == t) return p;
        return null;
    }

    public void swapNodes(Node<Integer> a, Node<Integer> b) {
        if (a == null || b == null || a == b) return;
        Node<Integer> pa = prev(a), pb = prev(b);
        if (a.next == b) { // adjacent a->b
            if (pa != null) pa.next = b; else head = b;
            a.next = b.next; b.next = a;
        } else if (b.next == a) { // adjacent b->a
            if (pb != null) pb.next = a; else head = a;
            b.next = a.next; a.next = b;
        } else { // non-adjacent
            Node<Integer> an = a.next, bn = b.next;
            if (pa != null) pa.next = b; else head = b;
            if (pb != null) pb.next = a; else head = a;
            b.next = an; a.next = bn;
        }
        if (a.next == null) tail = a;
        if (b.next == null) tail = b;
    }

    public static void main(String[] args) {
        Main L = new Main();
        Node<Integer> n1 = L.addLast(10);
        Node<Integer> n2 = L.addLast(20);
        Node<Integer> n3 = L.addLast(30);
        Node<Integer> n4 = L.addLast(40);
        Node<Integer> n5 = L.addLast(50);

        L.print();                  // 10 20 30 40 50
        L.swapNodes(n2, n5); L.print(); // 10 50 30 40 20
        L.swapNodes(n3, n4); L.print(); // 10 50 40 30 20
        L.swapNodes(n1, n5); L.print(); // 50 40 30 20 10
    }
}
