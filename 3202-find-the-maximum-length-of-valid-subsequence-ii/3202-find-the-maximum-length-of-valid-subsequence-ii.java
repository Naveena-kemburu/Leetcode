class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int rem = (nums[j] + nums[i]) % k;
                dp[i][rem] = Math.max(dp[i][rem], dp[j][rem] + 1);
                maxLen = Math.max(maxLen, dp[i][rem]);
            }
        }

        return maxLen == 0 ? 1 : maxLen + 1;
    }
}
