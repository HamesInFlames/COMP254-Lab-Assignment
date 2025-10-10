package exercise3;

public class CircularlyLinkedList<T> implements Cloneable {
    private static class Node<T>{ T data; Node<T> next; Node(T d){data=d;} }
    private Node<T> tail; private int size;

    public void addLast(T x){
        Node<T> n=new Node<>(x);
        if(tail==null){ tail=n; n.next=n; }
        else { n.next=tail.next; tail.next=n; tail=n; }
        size++;
    }
    public void print(){
        if(tail==null){ System.out.println(); return; }
        Node<T> h=tail.next; Node<T> c=h;
        do{ System.out.print(c.data+" "); c=c.next; } while(c!=h);
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public CircularlyLinkedList<T> clone(){
        try{
            CircularlyLinkedList<T> other=(CircularlyLinkedList<T>)super.clone();
            if(tail==null){ other.tail=null; other.size=0; return other; }
            Node<T> h=tail.next, c=h;
            Node<T> newHead=new Node<>(c.data), prev=newHead;
            c=c.next;
            while(c!=h){ Node<T> nn=new Node<>(c.data); prev.next=nn; prev=nn; c=c.next; }
            prev.next=newHead;           // close the ring
            other.tail=prev; other.size=size;
            return other;
        }catch(CloneNotSupportedException e){ throw new AssertionError(e); }
    }

    // demo
    public static void main(String[] args){
        CircularlyLinkedList<String> C=new CircularlyLinkedList<>();
        C.addLast("A"); C.addLast("B"); C.addLast("C");
        C.print(); // A B C
        CircularlyLinkedList<String> D=C.clone();
        D.print(); // A B C
        C.addLast("D");
        C.print(); // A B C D
        D.print(); // A B C  (unchanged)
    }
}
