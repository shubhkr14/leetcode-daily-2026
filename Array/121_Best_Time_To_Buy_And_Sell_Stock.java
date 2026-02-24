/*
Problem: Best Time to Buy and Sell Stock
Leetcode Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Difficulty: Easy
Date: 25-02-2026

Approach:
Track minimum price so far.
Calculate profit at each step.
Update maximum profit accordingly.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            }
            else if(price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
