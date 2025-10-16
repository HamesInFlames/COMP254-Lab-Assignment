package ex2;

import java.util.Scanner;

/*
Write a short recursive Java method that determines if a string s is a palindrome,
that is, it is equal to its reverse. Examples include "racecar" and
"gohangasalamiimalasagnahog".
*/

public class PalindromeCheck {

    /**
     * Checks recursively whether a string is a palindrome.
     * 
     * Base case: if the string length <= 1 → palindrome.
     * Recursive step: check first and last characters, then recurse on substring.
     * 
     * Running time: O(n)
     */
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = sc.nextLine();

        if (isPalindrome(input))
            System.out.println("\"" + input + "\" is a palindrome!");
        else
            System.out.println("\"" + input + "\" is NOT a palindrome.");

        System.out.println("Running time: O(n)");
        sc.close();
    }
}
