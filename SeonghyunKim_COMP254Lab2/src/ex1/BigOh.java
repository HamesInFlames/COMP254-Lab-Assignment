
/**
 * Seonghyun Kim - COMP254 Lab 2
 * 
 * Exercise 1:
 * Analyze and explain the Big-Oh running time of five example methods.
 */
class BigOh {

    /**
     * Example 1: O(n)
     * 
     * This loop runs once for each element in the array.
     * The total number of iterations grows linearly with n.
     */
    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++)
            total += arr[j];
        return total;
    }

    /**
     * Example 2: O(n)
     * 
     * The loop runs n/2 times due to j += 2, but constants are ignored in Big-Oh.
     * Therefore, the time complexity is still linear, O(n).
     */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j += 2)
            total += arr[j];
        return total;
    }

    /**
     * Example 3: O(n^2)
     * 
     * The outer loop runs n times and the inner loop runs an increasing number
     * of times (1 + 2 + 3 + ... + n). This forms a triangular pattern of growth,
     * resulting in a quadratic relationship: O(n^2).
     */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++)
            for (int k = 0; k <= j; k++)
                total += arr[j];
        return total;
    }

    /**
     * Example 4: O(n)
     * 
     * The loop runs n times, performing a constant amount of work each iteration.
     * Therefore, the total running time grows linearly with n.
     */
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j = 0; j < n; j++) {
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    /**
     * Example 5: O(n^3)
     * 
     * Three nested loops result in cubic growth. The inner-most loop runs
     * proportional to n for each of the middle and outer loops.
     */
    public static int example5(int[] first, int[] second) {
        int n = first.length, count = 0;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < n; j++)
                for (int k = 0; k <= j; k++)
                    total += first[k];
            if (second[i] == total)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 9};
        System.out.println("Example 1 Output: " + example1(arr));
        System.out.println("Example 2 Output: " + example2(arr));
        System.out.println("Example 3 Output: " + example3(arr));
        System.out.println("Example 4 Output: " + example4(arr));
        System.out.println("Example 5 Output: " + example5(arr, arr));
    }
}
