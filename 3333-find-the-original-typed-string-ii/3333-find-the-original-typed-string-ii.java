class Solution {
    public int possibleStringCount(String word, int k) {
        final int MOD = 1_000_000_007;
        int n = word.length();
        long total = 1;
        int cnt = 1;
        List<Integer> seg = new ArrayList<>();

        // Grouping consecutive characters
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            } else {
                total = (total * cnt) % MOD;
                seg.add(cnt - 1);
                cnt = 1;
            }
        }
        // Last group
        total = (total * cnt) % MOD;
        seg.add(cnt - 1);

        int minLen = seg.size();
        if (k <= minLen) return (int) total;
        k -= minLen;

        long[] dp = new long[k];
        dp[0] = 1;

        for (int x : seg) {
            long[] pref = new long[k];
            pref[0] = dp[0];
            for (int i = 1; i < k; i++) {
                pref[i] = (pref[i - 1] + dp[i]) % MOD;
            }

            long[] newDp = new long[k];
            for (int i = 0; i < k; i++) {
                if (i - x - 1 >= 0) {
                    newDp[i] = (pref[i] - pref[i - x - 1] + MOD) % MOD;
                } else {
                    newDp[i] = pref[i];
                }
            }
            dp = newDp;
        }

        long invalid = 0;
        for (long x : dp) {
            invalid = (invalid + x) % MOD;
        }

        return (int) ((total - invalid + MOD) % MOD);
    }
}
