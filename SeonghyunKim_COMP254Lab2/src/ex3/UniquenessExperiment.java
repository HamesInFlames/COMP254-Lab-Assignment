import java.util.Arrays;
import java.util.Random;

/**
 * Seonghyun Kim - COMP254 Lab 2
 * 
 * Exercise 3:
 * Experimental analysis of unique1 (O(n^2)) and unique2 (O(n log n)).
 * Determines the largest n that completes within one minute (60,000 ms).
 */
public class UniquenessExperiment {

    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++)
                if (data[j] == data[k])
                    return false;
        return true;
    }

    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);
        Arrays.sort(temp);
        for (int j = 0; j < n - 1; j++)
            if (temp[j] == temp[j + 1])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int maxTimeMs = 60_000;

        System.out.printf("%-12s %-15s %-15s%n", "n", "unique1 (ms)", "unique2 (ms)");
        int[] testSizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};

        for (int n : testSizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++)
                data[i] = rand.nextInt(n * 10);

            long start1 = System.currentTimeMillis();
            unique1(data);
            long time1 = System.currentTimeMillis() - start1;

            long start2 = System.currentTimeMillis();
            unique2(data);
            long time2 = System.currentTimeMillis() - start2;

            System.out.printf("%-12d %-15d %-15d%n", n, time1, time2);

            if (time1 > maxTimeMs && time2 > maxTimeMs) {
                System.out.println("\nBoth algorithms exceeded 60 seconds — stopping test.");
                break;
            }
        }

        System.out.println();
        System.out.println("unique1 (O(n^2)) grows much faster and becomes impractical for large n.");
        System.out.println("unique2 (O(n log n)) scales efficiently and can handle much larger n.");
    }
}
