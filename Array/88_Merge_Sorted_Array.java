/*
Problem: Merge Sorted Array
Leetcode Link: https://leetcode.com/problems/merge-sorted-array/
Difficulty: Easy
Date: 23-02-2026

Approach:
Use three pointers from the back:
i → last element of nums1
j → last element of nums2
k → last position of nums1

Place the larger element at position k.

Time Complexity: O(m+n)
Space Complexity: O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            }
            else{
                nums1[k--]=nums2[j--];
            }
        }

        while(j >= 0){
            nums1[k--]=nums2[j--];
        }
    }
}
