

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -1_000_000_00000L, right = 1_000_000_00000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessEqual(nums1, nums2, mid) < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= x) l = m + 1;
                    else r = m;
                }
                count += l;
            } else if (a < 0) {
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= x) r = m;
                    else l = m + 1;
                }
                count += nums2.length - l;
            } else {
                if (x >= 0) count += nums2.length;
            }
        }
        return count;
    }
}
