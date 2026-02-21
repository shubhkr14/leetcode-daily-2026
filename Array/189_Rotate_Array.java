/*
Problem: Rotate Array
Leetcode Link: https://leetcode.com/problems/rotate-array/
Difficulty: Medium
Date: 20-02-2026

Approach:
We use Reversal Algorithm to rotate the array.

Steps:
1. Reverse first n-k elements
2. Reverse last k elements
3. Reverse whole array

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public static void reverse(int i, int j, int[] nums){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(0 , n-k-1 , nums);
        reverse(n-k , n-1 , nums);
        reverse(0 , n-1 , nums);
    }
}
