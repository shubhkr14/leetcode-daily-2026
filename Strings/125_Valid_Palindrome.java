/*
Problem: Valid Palindrome
Leetcode Link: https://leetcode.com/problems/valid-palindrome/
Difficulty: Easy
Date: 01-03-2026

Approach:
Use two pointers.
Skip non-alphanumeric characters.
Compare characters after converting to lowercase.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i < j){

            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) !=
               Character.toLowerCase(s.charAt(j))){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}
