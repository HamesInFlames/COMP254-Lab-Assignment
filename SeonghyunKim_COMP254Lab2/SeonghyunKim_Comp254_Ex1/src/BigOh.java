class BigOh {
    /**
     * Example 1: O(n)
     * 
     * example of running example1, if the values within arr = {4, 7, 2, 9}
     * the n = 4
     * for (int j = 0; j < 4; j++) it will loop 4 times
     *    total += arr[j];
     * 
     * this will run 4 times and add the value within arr until it is empty which is 22 and will stop.
     * therefore the time complexity is O(n)
     * because the loop executes once for each element in the array.
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
     * example of running example2, if the values within arr = {4, 7, 2, 9}
     * 
     * the n = 4 again, total = 0
     * for (int j = 0; j < 4 ; j+=2) it will loop 2 times because of j+=2
     *   total += arr[j];
     * returning total of 4
     * 
     * for the second loop, it will run with the j being 2
     * for (int j = 2; j<4 ; j+=2) it will loop 1 time because of j+=2
     *  total += arr[2]; because arr[2] = 2
     * returning total of 6
     * 
     * for the third and final loop, it will run with the j being 4
     * for (int j = 4; 4<4 ; j+=2) it will not loop because the condition is false
     * therefore it will return total of 6
     * 
     * in total the loop runs 2 times out of 4 indexes, but since Big-O ignores constants, 
     * it is still considered O(n)
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
     * example of running example3, if the values within arr = {4, 7, 2, 9}
     * 
     * the n = 4 again, total = 0
     * for (int j = 0; j < 4; j++) → outer loop runs 4 times
     *    for (int k = 0; k <= j; k++) → inner loop depends on j
     * 
     * when j = 0 → k runs 1 time  
     * when j = 1 → k runs 2 times  
     * when j = 2 → k runs 3 times  
     * when j = 3 → k runs 4 times  
     * 
     * total loops = 1 + 2 + 3 + 4 = 10 total inner operations
     * 
     * because the inner loop runs more each time, it grows quadratically
     * therefore the time complexity is O(n^2)
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
     * example of running example4, if the values within arr = {4, 7, 2, 9}
     * 
     * the n = 4 again, prefix = 0, total = 0
     * for (int j = 0; j < 4; j++)
     *   prefix += arr[j];
     *   total += prefix;
     * 
     * loop 1 → j=0 → prefix=4 → total=4  
     * loop 2 → j=1 → prefix=11 → total=15  
     * loop 3 → j=2 → prefix=13 → total=28  
     * loop 4 → j=3 → prefix=22 → total=50  
     * 
     * the loop only runs 4 times and performs constant work each time,
     * so the time complexity is O(n)
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
     * example of running example5, if both first and second arrays are {4, 7, 2, 9}
     * 
     * the n = 4 again
     * for (int i = 0; i < 4; i++) → outer loop runs 4 times
     *    for (int j = 0; j < 4; j++) → middle loop runs 4 times for each i
     *       for (int k = 0; k <= j; k++) → inner loop depends on j
     * 
     * inner loops combined → (1 + 2 + 3 + 4) = 10 operations per j  
     * middle + inner → about 4 * 10 = 40 operations per i  
     * outer loop runs 4 times → total ≈ 4 * 40 = 160 operations  
     * 
     * this shows cubic growth (n * n * n)
     * therefore the time complexity is O(n^3)
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
        System.out.println("Example 1 Output: " + example1(arr)); // Output: 22
        System.out.println("Example 2 Output: " + example2(arr)); // Output: 6
        System.out.println("Example 3 Output: " + example3(arr));
        System.out.println("Example 4 Output: " + example4(arr));
        System.out.println("Example 5 Output: " + example5(arr, arr));
    }
}
