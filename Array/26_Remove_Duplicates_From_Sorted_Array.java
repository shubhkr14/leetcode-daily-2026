/*
Problem: Remove Duplicates from Sorted Array
Leetcode Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Difficulty: Easy
Date: 22-02-2026

Approach:
Use two pointers:
Slow pointer keeps track of unique elements.
Fast pointer scans the array.
When nums[fast] != nums[slow], move slow and copy element.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
