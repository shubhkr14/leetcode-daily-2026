/*
Problem: Contains Duplicate
Leetcode Link: https://leetcode.com/problems/contains-duplicate/
Difficulty: Easy
Date: 27-02-2026

Approach:
Use HashSet to store elements.
If element already exists in set, return true.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
