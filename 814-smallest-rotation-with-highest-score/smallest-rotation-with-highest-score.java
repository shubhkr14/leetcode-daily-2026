class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;

        int[] change = new int[n];

        for (int i = 0; i < n; i++) {

            if (nums[i] <= i) {
                change[0]++;
            }
            int loseStart = (i - nums[i] + 1 + n) % n;

            change[loseStart]--;
            
            change[i + 1 < n ? i + 1 : 0]++;
        }

        int score = 0;
        int bestScore = -1;
        int bestK = 0;

        for (int k = 0; k < n; k++) {
            score += change[k];

            if (score > bestScore) {
                bestScore = score;
                bestK = k;
            }
        }

        return bestK;
    }
}