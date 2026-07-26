class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        return helper(a, b, b.length - 1);
    }

    private int helper(int a, int[] b, int idx) {
        if (idx < 0) return 1;

        return (powMod(helper(a, b, idx - 1), 10) *
                powMod(a, b[idx])) % MOD;
    }

    private int powMod(int a, int k) {
        int res = 1;
        a %= MOD;

        while (k > 0) {
            if ((k & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            k >>= 1;
        }

        return res;
    }
}