/*
Problem: Reverse Bits
Leetcode Link: https://leetcode.com/problems/reverse-bits/
Difficulty: Easy
Date: 16-02-2026

Approach:
We iterate over all 32 bits of the integer.
At each step:
1. Extract the last bit using (n & 1)
2. Left shift result
3. Add extracted bit
4. Right shift n

Time Complexity: O(32) ~ O(1)
Space Complexity: O(1)
*/

class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}
