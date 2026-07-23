class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] lis = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int h = env[1];
            int idx = Arrays.binarySearch(lis, 0, len, h);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            lis[idx] = h;

            if (idx == len) {
                len++;
            }
        }

        return len;
    }
}