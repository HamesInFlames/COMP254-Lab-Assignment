// Seonghyun Kim - COMP254 Lab 2
// Exercise 2 – Experimental Analysis of prefixAverage1 and prefixAverage2

import java.util.Random;

/**
 * This class provides two methods for computing prefix averages.
 * 
 * prefixAverage1 -> O(n^2)
 * prefixAverage2 -> O(n)
 * 
 * Each method returns an array where a[j] is the average of x[0]...x[j].
 */
public class PrefixAverage {

    /** 
     * prefixAverage1: O(n^2)
     * 
     * example of running prefixAverage1, if x = {3, 6, 9, 12}
     * 
     * this method creates a new array a of size n and uses two loops.
     * the outer loop goes through each element of x (n times).
     * the inner loop adds up all the elements from x[0] to x[j].
     * 
     * so for j = 0 → total = x[0]
     *    for j = 1 → total = x[0] + x[1]
     *    for j = 2 → total = x[0] + x[1] + x[2]
     * 
     * the total work done = 1 + 2 + 3 + ... + n = n(n+1)/2,
     * which grows quadratically, so time complexity is O(n^2).
     */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0;
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1);
        }
        return a;
    }

    /** 
     * prefixAverage2: O(n)
     * 
     * example of running prefixAverage2, if x = {3, 6, 9, 12}
     * 
     * this method uses one loop and keeps a running total of the prefix sum.
     * 
     * so for j = 0 → total = 3, a[0] = 3/1 = 3
     *    for j = 1 → total = 9, a[1] = 9/2 = 4.5
     *    for j = 2 → total = 18, a[2] = 18/3 = 6
     *    for j = 3 → total = 30, a[3] = 30/4 = 7.5
     * 
     * since each iteration runs once, total work is proportional to n,
     * therefore time complexity is O(n).
     */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int j = 0; j < n; j++) {
            total += x[j];
            a[j] = total / (j + 1);
        }
        return a;
    }
}
