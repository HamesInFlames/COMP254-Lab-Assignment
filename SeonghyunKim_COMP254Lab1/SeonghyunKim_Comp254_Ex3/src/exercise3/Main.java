package exercise3;

public class Main {
    public static void main(String[] args) {
        CircularlyLinkedList<String> C = new CircularlyLinkedList<>();
        C.addLast("A");
        C.addLast("B");
        C.addLast("C");
        C.print(); // A B C

        CircularlyLinkedList<String> D = C.clone();
        D.print(); // A B C

        C.addLast("D");
        C.print(); // A B C D
        D.print(); // A B C (unchanged)
    }
}
