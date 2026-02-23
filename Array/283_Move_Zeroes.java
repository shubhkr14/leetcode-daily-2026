/*
Problem: Move Zeroes
Leetcode Link: https://leetcode.com/problems/move-zeroes/
Difficulty: Easy
Date: 24-02-2026

Approach:
Use two pointers:
Slow pointer points to where next non-zero element should go.
Fast pointer scans the array.

When nums[fast] != 0:
Swap nums[slow] and nums[fast]

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {

        int slow = 0;

        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
}
