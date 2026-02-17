/*
Problem: Counting Bits
Leetcode Link: https://leetcode.com/problems/counting-bits/
Difficulty: Easy
Date: 17-02-2026

Approach:
For any number i,
number of set bits in i = number of set bits in (i/2) + last bit of i

i >> 1 removes the last bit
i & 1 gives the last bit

So:
dp[i] = dp[i >> 1] + (i & 1)

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
}
