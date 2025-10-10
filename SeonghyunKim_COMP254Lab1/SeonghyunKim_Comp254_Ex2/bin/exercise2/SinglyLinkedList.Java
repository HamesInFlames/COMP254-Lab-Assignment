package exercise2;

public class SinglyLinkedList<T> {
    public static class Node<T> { T data; Node<T> next; Node(T d){data=d;} }
    private Node<T> head, tail; private int size;

    public Node<T> addLast(T x){
        Node<T> n=new Node<>(x);
        if(head==null) head=tail=n; else { tail.next=n; tail=n; }
        size++; return n;
    }
    public void print(){
        for(Node<T> c=head;c!=null;c=c.next) System.out.print(c.data+" ");
        System.out.println();
    }
    private Node<T> prev(Node<T> t){
        if(t==head) return null;
        for(Node<T> p=head;p!=null;p=p.next) if(p.next==t) return p;
        return null;
    }
    // swap two nodes by references (not just data)
    public void swapNodes(Node<T> a, Node<T> b){
        if(a==null||b==null||a==b) return;
        Node<T> pa=prev(a), pb=prev(b);
        if((a!=head && pa==null) || (b!=head && pb==null)) return; // not found
        // ensure distinct cases: adjacent a->b, adjacent b->a, or non-adjacent
        if(a.next==b){ // pa -> a -> b -> bn
            Node<T> bn=b.next;
            if(pa!=null) pa.next=b; else head=b;
            b.next=a; a.next=bn;
        } else if(b.next==a){ // pb -> b -> a -> an
            Node<T> an=a.next;
            if(pb!=null) pb.next=a; else head=a;
            a.next=b; b.next=an;
        } else { // non-adjacent
            Node<T> an=a.next, bn=b.next;
            if(pa!=null) pa.next=b; else head=b;
            if(pb!=null) pb.next=a; else head=a;
            b.next=an; a.next=bn;
        }
        // fix tail
        if(a.next==null) tail=a; else if(b.next==null) tail=b;
    }

    // demo
    public static void main(String[] args){
        SinglyLinkedList<Integer> L=new SinglyLinkedList<>();
        var n1=L.addLast(10); var n2=L.addLast(20); var n3=L.addLast(30);
        var n4=L.addLast(40); var n5=L.addLast(50);
        L.print();                // 10 20 30 40 50
        L.swapNodes(n2,n5); L.print(); // 10 50 30 40 20
        L.swapNodes(n3,n4); L.print(); // 10 50 40 30 20
        L.swapNodes(n1,n5); L.print(); // 50 40 30 20 10
    }
}
