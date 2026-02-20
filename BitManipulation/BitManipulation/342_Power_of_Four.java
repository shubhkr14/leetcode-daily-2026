/*
Problem: Power of Four
Leetcode Link: https://leetcode.com/problems/power-of-four/
Difficulty: Easy
Date: 19-02-2026

Approach:
A number is power of 4 if:
1. It is power of 2 → only one set bit
2. That set bit is at even position

So:
(n & (n-1)) == 0  → checks power of 2
(n & 0x55555555) != 0 → checks even position bit

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        return ((n&(n-1))==0) && ((n & 0x55555555)!=0);
    }
}
