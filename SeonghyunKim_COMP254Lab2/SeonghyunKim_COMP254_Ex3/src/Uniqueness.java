// Seonghyun Kim - COMP254 Lab 2
// Exercise 3 – Experimental analysis of unique1 and unique2

import java.util.Arrays;

public class Uniqueness {

    /** 
     * unique1: O(n^2)
     * 
     * example of how it runs:
     * compares every pair of elements in the array using two nested loops.
     * if any two elements are equal, returns false.
     * 
     * the total comparisons are (n * (n - 1)) / 2,
     * which grows quadratically with n, making it O(n^2).
     */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++)
                if (data[j] == data[k])
                    return false;
        return true;
    }

    /** 
     * unique2: O(n log n)
     * 
     * example of how it runs:
     * first sorts the array (O(n log n)),
     * then checks for duplicates by scanning adjacent elements (O(n)).
     * 
     * therefore, the total complexity is O(n log n).
     */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);
        Arrays.sort(temp);
        for (int j = 0; j < n - 1; j++)
            if (temp[j] == temp[j + 1])
                return false;
        return true;
    }
}
