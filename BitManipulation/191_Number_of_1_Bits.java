/*
Problem: Number of 1 Bits
Leetcode Link: https://leetcode.com/problems/number-of-1-bits/
Difficulty: Easy
Date: 17-02-2026

Approach:
We count the number of set bits (1s) in the binary representation of n.

At each step:
1. Check the last bit using (n & 1)
2. If it's 1, increase count
3. Right shift n by 1

Time Complexity: O(32) ~ O(1)
Space Complexity: O(1)
*/

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0;i<32;i++){
            if((n & 1) == 1){
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
