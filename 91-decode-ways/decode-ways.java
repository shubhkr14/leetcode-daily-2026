class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[n] = 1; // empty string
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1]; // take one digit
            }

            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i + 2]; // take two digits
            }
        }

        return dp[0];
    }
}