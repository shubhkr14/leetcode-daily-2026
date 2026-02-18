/*
Problem: Power of Two
Leetcode Link: https://leetcode.com/problems/power-of-two/
Difficulty: Easy
Date: 18-02-2026

Approach:
A number is power of 2 if it has only one set bit in binary form.

For example:
4  -> 100
8  -> 1000

So n & (n - 1) removes the lowest set bit.
If result becomes 0, then only one set bit was present.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
