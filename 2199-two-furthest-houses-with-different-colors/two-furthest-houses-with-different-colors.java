class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0;

        // Fix the first house
        for (int j = n - 1; j >= 0; j--) {
            if (colors[0] != colors[j]) {
                ans = Math.max(ans, j);
                break;
            }
        }

        // Fix the last house
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                ans = Math.max(ans, n - 1 - i);
                break;
            }
        }

        return ans;
    }
}