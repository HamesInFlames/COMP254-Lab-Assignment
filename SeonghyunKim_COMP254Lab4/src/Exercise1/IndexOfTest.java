package Exercise1;

/**
 * Seonghyun Kim - COMP254 Lab 4
 *
 * Exercise 1:
 * Extend the PositionalList ADT with indexOf(p), which returns
 * the index (0-based) of position p using only ADT methods.
 */
public class IndexOfTest {

    // Simplified PositionalList interface
    public interface Position<E> {
        E getElement();
    }

    public interface PositionalList<E> {
        int size();
        boolean isEmpty();
        Position<E> first();
        Position<E> last();
        Position<E> before(Position<E> p);
        Position<E> after(Position<E> p);
        Position<E> addFirst(E e);
        Position<E> addLast(E e);
        Position<E> addAfter(Position<E> p, E e);
    }

    // Basic implementation using a nested Node class
    public static class LinkedPositionalList<E> implements PositionalList<E> {
        private static class Node<E> implements Position<E> {
            private E element;
            private Node<E> prev, next;
            public Node(E e, Node<E> p, Node<E> n) {
                element = e; prev = p; next = n;
            }
            public E getElement() { return element; }
        }

        private Node<E> header, trailer;
        private int size = 0;

        public LinkedPositionalList() {
            header = new Node<>(null, null, null);
            trailer = new Node<>(null, header, null);
            header.next = trailer;
        }

        private Node<E> validate(Position<E> p) { return (Node<E>) p; }
        private Position<E> position(Node<E> node) {
            if (node == header || node == trailer) return null;
            return node;
        }

        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }

        public Position<E> first() { return position(header.next); }
        public Position<E> last() { return position(trailer.prev); }
        public Position<E> before(Position<E> p) {
            Node<E> node = validate(p);
            return position(node.prev);
        }
        public Position<E> after(Position<E> p) {
            Node<E> node = validate(p);
            return position(node.next);
        }

        private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
            Node<E> newest = new Node<>(e, pred, succ);
            pred.next = newest;
            succ.prev = newest;
            size++;
            return newest;
        }

        public Position<E> addFirst(E e) { return addBetween(e, header, header.next); }
        public Position<E> addLast(E e) { return addBetween(e, trailer.prev, trailer); }
        public Position<E> addAfter(Position<E> p, E e) {
            Node<E> node = validate(p);
            return addBetween(e, node, node.next);
        }

        // The required method
        public int indexOf(Position<E> p) {
            Position<E> walk = first();
            int index = 0;
            while (walk != null && walk != p) {
                walk = after(walk);
                index++;
            }
            if (walk == null)
                throw new IllegalArgumentException("Position not found in list.");
            return index;
        }
    }

    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        var p1 = list.addLast("A");
        var p2 = list.addLast("B");
        var p3 = list.addLast("C");
        var p4 = list.addLast("D");

        System.out.println("Index of A: " + list.indexOf(p1));
        System.out.println("Index of B: " + list.indexOf(p2));
        System.out.println("Index of D: " + list.indexOf(p4));
    }
}
