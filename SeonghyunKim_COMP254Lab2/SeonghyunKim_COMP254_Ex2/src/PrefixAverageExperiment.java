// Seonghyun Kim - COMP254 Lab 2
// Experimental analysis of prefixAverage1 and prefixAverage2
// Based on StringExperiment.java structure

import java.util.Random;

public class PrefixAverageExperiment {

    /**
     * Experimental Analysis of prefixAverage1 and prefixAverage2
     * 
     * This program measures how long each method takes to run
     * with increasing input size n.
     * 
     * Arrays are filled with random double values.
     * prefixAverage1 uses O(n^2) time due to nested loops.
     * prefixAverage2 uses O(n) time due to a single loop.
     */
    public static void main(String[] args) {
        int n = 1000;      // starting array size
        int trials = 6;    // number of test sizes
        Random rand = new Random();

        System.out.printf("%-10s %-20s %-20s%n", "n", "prefixAverage1 (ms)", "prefixAverage2 (ms)");
        System.out.println("-------------------------------------------------------------");

        for (int t = 0; t < trials; t++) {
            double[] data = new double[n];
            for (int i = 0; i < n; i++)
                data[i] = rand.nextDouble();

            long start1 = System.currentTimeMillis();
            PrefixAverage.prefixAverage1(data);
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            PrefixAverage.prefixAverage2(data);
            long end2 = System.currentTimeMillis();

            long time1 = end1 - start1;
            long time2 = end2 - start2;

            System.out.printf("%-10d %-20d %-20d%n", n, time1, time2);

            n *= 2; // double the input size for the next trial
        }

        System.out.println();
        System.out.println("Results show prefixAverage1 takes much longer as n increases");
        System.out.println("because it uses nested loops (O(n^2)).");
        System.out.println("prefixAverage2 runs much faster and scales linearly with n (O(n)).");
    }
}
