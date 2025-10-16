package ex1;
/*
Create a recursive algorithm to compute the product of two positive integers, m and n,
using only addition and subtraction. Implement the Java or Python code.
Hint: You need subtraction to count down from m or n and addition to do the arithmetic.
*/

public class ProductRecursive {

    /**
     * Recursively computes the product of two positive integers m and n
     * using only addition and subtraction.
     * 
     * Base case: if n == 1 → return m
     * Recursive step: m * n = m + product(m, n - 1)
     * 
     * Running time: O(n)
     */
    public static int product(int m, int n) {
        if (n == 0)
            return 0; // anything multiplied by 0 is 0
        if (n == 1)
            return m; // stop condition
        return m + product(m, n - 1); // add m n times
    }

    public static void main(String[] args) {
        int m = 7, n = 5;
        int result = product(m, n);
        System.out.println(m + " × " + n + " = " + result);
        System.out.println("Running time: O(n)");
    }
}
