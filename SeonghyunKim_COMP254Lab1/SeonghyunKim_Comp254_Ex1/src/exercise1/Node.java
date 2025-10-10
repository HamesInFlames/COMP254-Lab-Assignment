package exercise1;
public class Node<T> {
    T data;
    Node<T> prev, next;
    Node(T d, Node<T> p, Node<T> n) { data = d; prev = p; next = n; }
}