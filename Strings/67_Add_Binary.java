/*
Problem: Add Binary
Leetcode Link: https://leetcode.com/problems/add-binary/
Difficulty: Easy
Date: 02-03-2026

Approach:
Traverse both strings from right to left.
Add corresponding bits along with carry.
Append result and reverse at the end.

Time Complexity: O(max(n,m))
Space Complexity: O(n)
*/

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry != 0){

            int sum = carry;

            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}
