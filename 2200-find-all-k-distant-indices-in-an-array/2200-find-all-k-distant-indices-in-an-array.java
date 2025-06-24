class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndices = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) keyIndices.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int idx : keyIndices) {
                if (Math.abs(i - idx) <= k) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}
