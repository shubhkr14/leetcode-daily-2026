class Solution {

    private int[][] rects;
    private int[] prefix;
    private Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefix = new int[rects.length];

        int sum = 0;

        for (int i = 0; i < rects.length; i++) {
            int x1 = rects[i][0];
            int y1 = rects[i][1];
            int x2 = rects[i][2];
            int y2 = rects[i][3];

            int points = (x2 - x1 + 1) * (y2 - y1 + 1);

            sum += points;
            prefix[i] = sum;
        }
    }

    public int[] pick() {
        int target = random.nextInt(prefix[prefix.length - 1]) + 1;
        int left = 0;
        int right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int[] rect = rects[left];

        int x1 = rect[0];
        int y1 = rect[1];
        int x2 = rect[2];
        int y2 = rect[3];

        int x = x1 + random.nextInt(x2 - x1 + 1);
        int y = y1 + random.nextInt(y2 - y1 + 1);

        return new int[]{x, y};
    }
}