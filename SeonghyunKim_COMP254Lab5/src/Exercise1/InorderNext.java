package Exercise1;

/*
  Seonghyun Kim - COMP254 Lab 5
 
  Exercise 1:
  Implement inorderNext(p): Return the node visited after p in an inorder traversal.
 
  Inorder means:
 - Visit left subtree
 - Visit current node
 - Visit right subtree
 */
public class InorderNext {

    // Basic Binary Tree Node
    static class Node<E> {
        E element;
        Node<E> parent, left, right;

        public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
            element = e;
            parent = p;
            left = l;
            right = r;
        }
    }

    /* 
     inorderNext(p):
     - If p has a right child → go to right, then all the way left.
     - Otherwise → go up the parent chain until you come from a left child.
     - If none found → p was the last node → return null.
     */
    public static <E> Node<E> inorderNext(Node<E> p) {
        if (p.right != null) {
            Node<E> walk = p.right;
            while (walk.left != null)
                walk = walk.left;
            return walk;
        } else {
            Node<E> walk = p;
            Node<E> parent = walk.parent;
            while (parent != null && parent.right == walk) {
                walk = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    // Helper to print result
    public static <E> void printNext(Node<E> p) {
        Node<E> next = inorderNext(p);
        System.out.println("Next inorder node after " + p.element + ": " +
                (next == null ? "null (last node)" : next.element));
    }

    public static void main(String[] args) {
        // Build a sample binary tree manually
        Node<String> A = new Node<>("A", null, null, null);
        Node<String> B = new Node<>("B", A, null, null);
        Node<String> C = new Node<>("C", A, null, null);
        A.left = B;
        A.right = C;
        Node<String> D = new Node<>("D", B, null, null);
        Node<String> E = new Node<>("E", B, null, null);
        B.left = D;
        B.right = E;

        // Inorder traversal is: D → B → E → A → C
        printNext(D); // Next = B
        printNext(B); // Next = E
        printNext(E); // Next = A
        printNext(A); // Next = C
        printNext(C); // Next = null
    }
    /* 
    What are the worst-case running times of your algorithms?
    where h is the height of the tree.

    If the tree is perfectly balanced:
    → h = O(log n)

    If the tree is skewed (like a linked list):
    → h = O(n) 
    */
}
