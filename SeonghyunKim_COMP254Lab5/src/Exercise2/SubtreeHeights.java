package Exercise2;

/*
  Seonghyun Kim - COMP254 Lab 5
 
  Exercise 2:
  For every node p in tree T, print (element, height of its subtree).
  We use a postorder traversal because we must know children’s heights first.
 */
public class SubtreeHeights {

    // Binary Tree Node
    static class Node<E> {
        E element;
        Node<E> left, right;

        Node(E e) {
            element = e;
        }
    }

    /*
      postorderHeight:
      - Visit left subtree → right subtree → node itself.
      - Compute height = max(leftHeight, rightHeight) + 1.
      - Print the node and its height.
     */
    public static <E> int postorderHeight(Node<E> p) {
        if (p == null) return -1; // empty subtree height
        int leftH = postorderHeight(p.left);
        int rightH = postorderHeight(p.right);
        int h = Math.max(leftH, rightH) + 1;
        System.out.println("Node " + p.element + " → Subtree height: " + h);
        return h;
    }

    public static void main(String[] args) {
        // Build tree
        Node<String> root = new Node<>("A");
        root.left = new Node<>("B");
        root.right = new Node<>("C");
        root.left.left = new Node<>("D");
        root.left.right = new Node<>("E");
        root.right.right = new Node<>("F");

        /*
           Tree structure:
                A
               / \
              B   C
             / \   \
            D   E   F
        */

        System.out.println("Node and their subtree heights (postorder):\n");
        postorderHeight(root);
    }
}
