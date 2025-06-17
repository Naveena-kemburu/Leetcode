class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        long[] dp = new long[k + 2];
        dp[0] = m;

        for (int i = 2; i <= n; i++) {
            long[] next = new long[k + 2];
            for (int j = 0; j <= Math.min(i - 2, k); j++) {
                next[j] = (next[j] + dp[j] * (m - 1)) % MOD;
                next[j + 1] = (next[j + 1] + dp[j]) % MOD;
            }
            dp = next;
        }

        return (int) dp[k];
    }
}
