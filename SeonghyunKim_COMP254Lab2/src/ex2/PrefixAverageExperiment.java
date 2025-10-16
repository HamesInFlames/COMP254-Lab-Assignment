import java.util.Random;

/**
 * Seonghyun Kim - COMP254 Lab 2
 * 
 * Exercise 2:
 * Experimental analysis of prefixAverage1 (O(n^2)) and prefixAverage2 (O(n)).
 */
public class PrefixAverageExperiment {

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

    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
        Random rand = new Random();

        System.out.printf("%-10s %-20s %-20s%n", "n", "prefixAverage1 (ms)", "prefixAverage2 (ms)");

        for (int n : sizes) {
            double[] data = new double[n];
            for (int i = 0; i < n; i++)
                data[i] = rand.nextDouble();

            long start1 = System.nanoTime();
            prefixAverage1(data);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            prefixAverage2(data);
            long end2 = System.nanoTime();

            double time1 = (end1 - start1) / 1_000_000.0;
            double time2 = (end2 - start2) / 1_000_000.0;

            System.out.printf("%-10d %-20.4f %-20.4f%n", n, time1, time2);
        }

        System.out.println();
        System.out.println("Results show prefixAverage1 takes much longer as n increases");
        System.out.println("because it uses nested loops (O(n^2)).");
        System.out.println("prefixAverage2 runs much faster and scales linearly with n (O(n)).");
    }
}
