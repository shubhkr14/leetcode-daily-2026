/*
Problem: Two Sum
Leetcode Link: https://leetcode.com/problems/two-sum/
Difficulty: Easy
Date: 21-02-2026

Approach:
We check every pair of elements in the array.
If their sum equals the target, we return their indices.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
