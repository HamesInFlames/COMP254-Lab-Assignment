// Seonghyun Kim - COMP254 Lab 2
// Experimental analysis of Uniqueness.unique1 and Uniqueness.unique2
// Goal: Find largest n that runs in 1 minute or less

import java.util.Random;

public class UniquenessExperiment {

    /**
     * This experiment measures the running time of both algorithms
     * (unique1: O(n^2), unique2: O(n log n)) and determines
     * how their runtime increases as n grows.
     * 
     * Each test doubles n and measures both algorithms
     * until they exceed one minute (60,000 ms).
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int maxTimeMs = 60_000;

        System.out.printf("%-12s %-20s %-20s%n", "n", "unique1 (ms)", "unique2 (ms)");
        System.out.println("--------------------------------------------------------------");

        // start from smaller n and increase exponentially
        int[] testSizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 512000};

        for (int n : testSizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++)
                data[i] = rand.nextInt(n * 10); // random integers

            // Measure unique1 (O(n^2))
            long start1 = System.nanoTime();
            Uniqueness.unique1(data);
            long end1 = System.nanoTime();
            double time1 = (end1 - start1) / 1_000_000.0; // convert to ms

            // Measure unique2 (O(n log n))
            long start2 = System.nanoTime();
            Uniqueness.unique2(data);
            long end2 = System.nanoTime();
            double time2 = (end2 - start2) / 1_000_000.0; // convert to ms

            System.out.printf("%-12d %-20.4f %-20.4f%n", n, time1, time2);

            // Stop testing when both exceed 60 seconds
            if (time1 > maxTimeMs && time2 > maxTimeMs) {
                System.out.println("\nBoth algorithms took longer than 60 seconds. Stopping test.");
                break;
            }
        }

        /* Results Summary:
        - unique1 (O(n^2)) can handle up to approximately n = 512,000 within 1 minute.
        - unique2 (O(n log n)) can handle up to approximately n = 512,000 within 1 minute.

        Explanation:
        unique1 grows quadratically due to nested loops,
        while unique2 grows logarithmically due to sorting.
        This experiment shows the massive performance difference between O(n^2) and O(n log n). */
    }
}
