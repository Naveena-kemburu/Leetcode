class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length(), maxLen = 0;
        long num = 0, power = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                maxLen++;
            } else {
                if (num + power > k) continue;
                num += power;
                maxLen++;
            }
            if (power <= k) power <<= 1;
        }

        return maxLen;
    }
}
