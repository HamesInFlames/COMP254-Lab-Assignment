package Exercise2;

import java.util.Stack;

/**
 * Seonghyun Kim - COMP254 Lab 4
 *
 * Exercise 2:
 * Implement a method transfer(S, T) that moves all elements
 * from stack S to stack T, maintaining order.
 */
public class StackTransfer {

    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            E elem = S.pop();
            T.push(elem);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();

        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

        System.out.println("Original S: " + S);
        System.out.println("Original T: " + T);

        transfer(S, T);

        System.out.println("\nAfter transfer:");
        System.out.println("S (empty): " + S);
        System.out.println("T (reversed order): " + T);
    }
}
