class Solution {
    private static final int MOD = (int)1e9 + 7;
    private static final int N = (int)1e5 + 10;
    private static final long[] fact = new long[N], invFact = new long[N];

    static {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < N; ++i) {
            fact[i] = fact[i - 1] * i % MOD;
            invFact[i] = modPow(fact[i], MOD - 2);
        }
    }

    private static long modPow(long a, int e) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return res;
    }

    private static long nCk(int n, int k) {
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        if (k > n - 1) return 0;
        long combinations = nCk(n - 1, k);
        long ways = combinations * m % MOD * modPow(m - 1, n - k - 1) % MOD;
        return (int) ways;
    }
}
