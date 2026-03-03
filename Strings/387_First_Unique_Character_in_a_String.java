/*
Problem: First Unique Character in a String
Leetcode Link: https://leetcode.com/problems/first-unique-character-in-a-string/
Difficulty: Easy
Date: 07-03-2026

Approach:
1. Use frequency array of size 26.
2. Count occurrences of each character.
3. Traverse string again to find first character with frequency 1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Count frequency
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        // Find first unique character
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
